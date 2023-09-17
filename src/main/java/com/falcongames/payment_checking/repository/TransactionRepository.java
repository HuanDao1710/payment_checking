package com.falcongames.payment_checking.repository;

import com.falcongames.payment_checking.domain.entity.PackageEntity;
import com.falcongames.payment_checking.domain.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	List<TransactionEntity> findAllByPackageOrderAndAccountId(PackageEntity packageId, String AccountId);
}
