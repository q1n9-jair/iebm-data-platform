package com.iebm.admin.info.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.iebm.admin.info.dtoform.AdminInfoDTOForm;
import com.iebm.dto.AdminCompanyInfoDTO;
import com.iebm.dto.AdminDepartmentInfoDTO;

@Mapper
public interface AdminInfoDAO {
	/****
	 * 展示所有公司
	 * 
	 * @return
	 */
	public List<AdminCompanyInfoDTO> showCompanyList();

	/*****
	 * 根据条件查询部门
	 * 
	 * @param companyId
	 * @return
	 */
	public List<AdminDepartmentInfoDTO> showDepartmentInfo(AdminDepartmentInfoDTO adminDepartmentInfoDTO);

	/****
	 * 根据id或账号查询管理员详细信息
	 * 
	 * @param adminInfoDTOForm
	 * @return
	 */
	public AdminInfoDTOForm selectIdShowAdminInfo(Map<String, Object>map);

	/****
	 * 分页查询管理员列表
	 * 
	 * @param adminInfoDTOForm
	 * @return
	 */
	public List<AdminInfoDTOForm> showAdminPageInfoList(AdminInfoDTOForm adminInfoDTOForm);

	/*****
	 * 管理员登录
	 * 
	 * @param map
	 * @return
	 */
	public int adminLogin(Map<String, Object> map);

}
