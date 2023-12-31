package com.falcongames.payment_checking.domain.entity;

import com.falcongames.payment_checking.constant.Duration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "packages_order", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class PackageEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "package_id")
	private String packageId;
	@Column(name = "duration", nullable = false)
	@Enumerated(EnumType.STRING)
	private Duration duration;
	@ManyToOne
	@JoinColumn(name = "app_id", referencedColumnName = "app_id", nullable = false)
	private AppInfoEntity appInfo;
	@OneToMany(mappedBy = "packageOrder")
	private List<TransactionEntity> transactions;
}
