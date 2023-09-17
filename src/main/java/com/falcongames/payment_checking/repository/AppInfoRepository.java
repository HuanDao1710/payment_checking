package com.falcongames.payment_checking.repository;

import com.falcongames.payment_checking.domain.entity.AppInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfoEntity, Long> {
}
