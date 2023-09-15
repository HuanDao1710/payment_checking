package com.falcongames.payment_checking.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass   // anotation JPA đánh dấu 1 lớp trừa tượng, là supper class của các entity khác
@Getter
@Setter // Lombok
@NoArgsConstructor // Tạo constructor không chứa tham só
@AllArgsConstructor // Tạo constructor chưa tất cả tham số	Lombok
@EntityListeners(AuditingEntityListener.class) // Lớp lắng nghe sự kiện tự động cập nhật 	ngày tạo và ngày thêm, sửa, xóa dữ liệu
public class BaseEntity {

	@Column(name = "created_date")
	@CreatedDate
	private Date createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	private Date modifiedDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "modified_by")
	private String modifiedBy;
}
