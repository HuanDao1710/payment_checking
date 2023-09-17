package com.falcongames.payment_checking.service.impl;

import com.falcongames.payment_checking.domain.dto.TransactionDTO;
import com.falcongames.payment_checking.domain.entity.PackageEntity;
import com.falcongames.payment_checking.domain.entity.TransactionEntity;
import com.falcongames.payment_checking.mapper.TransactionMapper;
import com.falcongames.payment_checking.repository.PackageRepository;
import com.falcongames.payment_checking.repository.TransactionRepository;
import com.falcongames.payment_checking.service.ITransactionService;
import com.falcongames.payment_checking.utils.ExpiredTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
	private final TransactionRepository transactionRepository;
	private final PackageRepository packageRepository;

	@Override
	@Transactional
	public TransactionDTO create(TransactionDTO dto) {
		PackageEntity packageEntity = packageRepository.findOneByPackageId(dto.getPackageId());
		if(Objects.isNull(packageEntity)) return null;

		List<TransactionEntity> transactions = transactionRepository.findAllByPackageOrderAndAccountId(packageEntity, dto.getAccountId());
		if(CollectionUtils.isEmpty(transactions) || isExpiredTransaction(transactions)) {
			TransactionEntity entity = TransactionMapper.INSTANCE.toEntity(dto);
			entity.setExpiredTime(ExpiredTime.createExpiredTime(packageEntity.getDuration()));
			entity.setPackageOrder(packageEntity);
			return TransactionMapper.INSTANCE.toDTO(transactionRepository.save(entity));
		}
		return null;
	}

	private boolean isExpiredTransaction(List<TransactionEntity> entities) {
		LocalDate currentDate = LocalDate.now();
		long count =  entities.stream().map(e -> e.getExpiredTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
				.filter(localDate -> localDate.isAfter(currentDate)) // filter nhung entity chua het han
				.count();
		return count == 0;
	}

}
