package com.iebm.dto;
/*****
 * 管理员对应的部门
 * @author Administrator
 *
 */
public class AdminDepartmentInfoDTO extends AbstractDTO{
private  int id;
private  String companyId;//公司id
private   String department;//部门名称
private  String  remark;//备注信息
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCompanyId() {
	return companyId;
}
public void setCompanyId(String companyId) {
	this.companyId = companyId;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

}
