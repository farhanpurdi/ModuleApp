package com.test.app.common.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_MODULE")
@NamedQuery(name="ViewModule.findAll", query="SELECT v FROM ViewModule v")
public class ViewModule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ROW_NUM")
	private Long rowNum;
	
	@Column(name="MODULE_NAME")
	private String moduleName;
	
	@Column(name="MODULE_ORDER")
	private Long moduleOrder;
	
	public ViewModule() {
		
	}
	
	public Long getRowNum() {
		return rowNum;
	}

	public void setRowNum(Long rowNum) {
		this.rowNum = rowNum;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Long getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(Long moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="USER_NAME")
	private String userName;

}
