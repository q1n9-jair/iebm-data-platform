package com.iebm.admin.LoginShiro.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iebm.admin.info.service.AdminInfoService;
import com.iebm.util.CommonRetrunUtil;

@Controller
@RequestMapping(value = "/admin")
public class LoginShiroContrller {
	@Autowired
	private AdminInfoService adminInfoService;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/doLogin")
	@ResponseBody
	public CommonRetrunUtil login(String account, String pwd) {
		CommonRetrunUtil commonRetrunUtil = new CommonRetrunUtil();
		if (account == null || "".equals(account)) {
			commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_FAILURE_CODE);
			commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_FAILURE_MESSAGE);
			commonRetrunUtil.setCommonReturnObject("请输入账号！");
			return commonRetrunUtil;
		}
		if (pwd == null || "".equals(pwd)) {
			commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_FAILURE_CODE);
			commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_FAILURE_MESSAGE);
			commonRetrunUtil.setCommonReturnObject("请输入密码！");
			return commonRetrunUtil;
		}
		try {//密码123
			if (adminInfoService.adminLogin(account, pwd) == 0) {

				commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_SUCCESS_CODE);
				commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_SUCCESS_MESSAGE);
				commonRetrunUtil.setCommonReturnObject(
						SecurityUtils.getSubject().getSession().getAttribute("adminInfoDTOForm"));
			}else{
				commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_FAILURE_CODE);
				commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_FAILURE_MESSAGE);
				commonRetrunUtil.setCommonReturnObject("账号不存在或密码错误！");
				return commonRetrunUtil;
			}
		} catch (Exception e) {
			commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_FAILURE_CODE);
			commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_FAILURE_MESSAGE);
			commonRetrunUtil.setCommonReturnObject("登陆失败！");
			return commonRetrunUtil;
		}
		return commonRetrunUtil;

	}
}
