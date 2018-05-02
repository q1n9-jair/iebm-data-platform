package com.iebm.admin.info.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iebm.admin.info.dao.AdminInfoDAO;
import com.iebm.admin.info.dtoform.AdminInfoDTOForm;
import com.iebm.admin.info.service.AdminInfoService;
import com.iebm.dto.AdminCompanyInfoDTO;
import com.iebm.dto.AdminDepartmentInfoDTO;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdminInfoDAO adminInfoDAO;

	@Override
	public List<AdminCompanyInfoDTO> showCompanyList() {
		return adminInfoDAO.showCompanyList();
	}

	@Override
	public List<AdminDepartmentInfoDTO> showDepartmentInfo(AdminDepartmentInfoDTO adminDepartmentInfoDTO) {
		return adminInfoDAO.showDepartmentInfo(adminDepartmentInfoDTO);
	}

	@Override
	public AdminInfoDTOForm selectIdShowAdminInfo(Map<String, Object> map) {
		return adminInfoDAO.selectIdShowAdminInfo(map);
	}

	@Override
	public List<AdminInfoDTOForm> showAdminPageInfoList(AdminInfoDTOForm adminInfoDTOForm) {
		return adminInfoDAO.showAdminPageInfoList(adminInfoDTOForm);
	}

	@Override
	public int adminLogin(String account, String password) {
		try {
			password = Md5Crypt.apr1Crypt(password, "asd");
		} catch (Exception e) {
			logger.error("对登录密码进行MD5转换出现异常", e);
			return -1;
		}
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);

		} catch (AuthenticationException e) {
			logger.error("登录失败", e);
			token.clear();
			return -1;
		}
		return 0;
	}
	
}
