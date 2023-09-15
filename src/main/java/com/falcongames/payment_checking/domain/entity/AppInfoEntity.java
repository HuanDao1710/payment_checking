package com.falcongames.payment_checking.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppInfoEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appInfo")
	private List<PackageEntity> packages;

	@Column(name = "topic", nullable = false)
	private String topic;
}
