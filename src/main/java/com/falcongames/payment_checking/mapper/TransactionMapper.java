package com.falcongames.payment_checking.mapper;

import com.falcongames.payment_checking.domain.dto.TransactionDTO;
import com.falcongames.payment_checking.domain.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

	TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "modifiedDate", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "modifiedBy", ignore = true)
	TransactionEntity toEntity(TransactionDTO dto);
	TransactionDTO toDTO(TransactionEntity entity);

}
