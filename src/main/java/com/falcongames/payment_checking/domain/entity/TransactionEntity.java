package com.falcongames.payment_checking.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "account_id", nullable = false)
	private long accountId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id" , referencedColumnName = "package_id", nullable = false)
	private PackageEntity packageOrder;

	@Column(name = "expired_time", nullable = false)
	private Date expiredTime;
}
