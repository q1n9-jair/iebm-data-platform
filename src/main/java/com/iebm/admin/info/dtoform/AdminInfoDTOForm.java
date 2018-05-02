package com.iebm.admin.info.dtoform;

import com.iebm.dto.AdminInfoDTO;

public class AdminInfoDTOForm extends AdminInfoDTO {
	private String company;// 公司名
	private String companyRemark;// 公司备注
	private String department;// 部门名称
	private String departmentRemark;// 部门备注信息
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyRemark() {
		return companyRemark;
	}
	public void setCompanyRemark(String companyRemark) {
		this.companyRemark = companyRemark;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentRemark() {
		return departmentRemark;
	}
	public void setDepartmentRemark(String departmentRemark) {
		this.departmentRemark = departmentRemark;
	}
	
	
}
