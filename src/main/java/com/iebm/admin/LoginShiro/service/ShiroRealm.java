package com.iebm.admin.LoginShiro.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iebm.admin.info.dao.AdminInfoDAO;
import com.iebm.admin.info.dtoform.AdminInfoDTOForm;

@Component
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private AdminInfoDAO adminInfoDAO;

	/**
	 * 授权用户权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	/**
	 * 验证用户身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String account = token.getUsername();
		String password = String.valueOf(token.getPassword());
		AdminInfoDTOForm adminInfoDTOForm = new AdminInfoDTOForm();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		adminInfoDTOForm = adminInfoDAO.selectIdShowAdminInfo(map);
		if (adminInfoDTOForm != null) {
			map.put("password", password);
			int count = adminInfoDAO.adminLogin(map);
			if (count > 0) {
				SecurityUtils.getSubject().getSession().setAttribute("adminId", adminInfoDTOForm.getId());//把id放到缓存
				SecurityUtils.getSubject().getSession().setAttribute("adminInfoDTOForm", adminInfoDTOForm);//将json放到信息减少个人信息查询
				return new SimpleAuthenticationInfo(adminInfoDTOForm.getId(), password,
						getName());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
