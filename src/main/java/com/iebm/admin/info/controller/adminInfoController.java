package com.iebm.admin.info.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iebm.util.CommonRetrunUtil;
import com.iebm.util.RedisUtil;

@Controller
@RequestMapping(value = "/admins")
public class adminInfoController {
	@Autowired
	private RedisUtil<Object> redisUtil;

	/****
	 * redis案例测试
	 * @param account
	 * @param pwd
	 * @return
	 */
	@PostMapping(value = "/redisTest")
	@ResponseBody
	public CommonRetrunUtil login(String account, String pwd) {
		CommonRetrunUtil commonRetrunUtil = new CommonRetrunUtil();
		List<Object> redisList = new ArrayList<Object>();
		try {
			if (redisUtil.hasKey("test") == true) {
				redisList = redisUtil.lGet("test", 0, -1);// 获取全部
			} else {
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < 10; i++) {
					list.add("ks" + i);
				}
				redisUtil.lSet("test", list);//
				redisList = redisUtil.lGet("test", 0, -1);// 获取全部
			}
			commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_SUCCESS_CODE);
			commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_SUCCESS_MESSAGE);
			commonRetrunUtil.setCommonReturnObject(redisList);
			return commonRetrunUtil;
		} catch (Exception e) {
			commonRetrunUtil.setCommonReturnCode(CommonRetrunUtil.RETRUN_FAILURE_CODE);
			commonRetrunUtil.setCommonReturnMessage(CommonRetrunUtil.RETRUN_FAILURE_MESSAGE);
			commonRetrunUtil.setCommonReturnObject("redis获取失败！");
			return commonRetrunUtil;
		}
	}
}
