package com.iebm.dto;

import java.util.Date;

/****
 * 公共抽象属性
 * 
 * @author Administrator
 *
 */
public class AbstractDTO {
	private String createBy;// 创建人
	private Date createTime;// 创建时间
	private Date updatetTime;// 更新时间
	private String updateBy;// 更新人
	private String createTimeStr;// 创建时间字符串
	private String updatetTimeStr;// 更新时间字符串

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdatetTime() {
		return updatetTime;
	}

	public void setUpdatetTime(Date updatetTime) {
		this.updatetTime = updatetTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdatetTimeStr() {
		return updatetTimeStr;
	}

	public void setUpdatetTimeStr(String updatetTimeStr) {
		this.updatetTimeStr = updatetTimeStr;
	}

}
