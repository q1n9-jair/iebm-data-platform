package com.iebm.dto;
/***
 * 管理员对应的公司
 * @author Administrator
 *
 */
public class AdminCompanyInfoDTO extends AbstractDTO{
	private int id;
	private String company;// 公司名
	private String remark;// 备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
