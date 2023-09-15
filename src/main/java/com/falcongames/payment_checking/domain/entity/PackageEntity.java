package com.falcongames.payment_checking.domain.entity;

import com.falcongames.payment_checking.constant.Duration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "packages_order")
@Getter
@Setter
@NoArgsConstructor
public class PackageEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "duration", nullable = false)
	@Enumerated(EnumType.STRING)
	private Duration duration;

	@ManyToOne
	@JoinColumn(name = "app_id", referencedColumnName = "id", nullable = false)
	private AppInfoEntity appInfo;

	@OneToMany(mappedBy = "packageOrder")
	private List<TransactionEntity> transactions;
}
