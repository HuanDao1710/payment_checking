package com.falcongames.payment_checking.repository;

import com.falcongames.payment_checking.domain.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {
	PackageEntity findOneByPackageId(String packageId);
}
