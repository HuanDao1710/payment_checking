package com.falcongames.payment_checking.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "app_info", schema = "public")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppInfoEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "app_id")
	private String appId;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appInfo")
	private List<PackageEntity> packages;
	@Column(name = "topic", nullable = false)
	private String topic;
}
