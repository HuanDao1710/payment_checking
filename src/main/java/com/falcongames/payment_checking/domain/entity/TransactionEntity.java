package com.falcongames.payment_checking.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "account_id", nullable = false)
	private String accountId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id" , referencedColumnName = "package_id", nullable = false)
	private PackageEntity packageOrder;
	@Column(name = "expired_time", nullable = false)
	private Date expiredTime;
}
