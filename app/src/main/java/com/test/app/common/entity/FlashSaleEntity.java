package com.test.app.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="FLASH_SALE")
@NamedQuery(name="FlashSaleEntity.findAll", query="SELECT g FROM FlashSaleEntity g")
public class FlashSaleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="PRIVILEGES")
	private Long privileges;
	
	public FlashSaleEntity() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Long privileges) {
		this.privileges = privileges;
	}
	
}