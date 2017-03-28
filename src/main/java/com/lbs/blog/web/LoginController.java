package com.lbs.blog.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbs.blog.datatype.UserBean;

@RestController
public class LoginController {

	
	@RequestMapping("/login")
	public String login(UserBean user,HttpSession session) {
		if(user.isNullBean()){
			return "error:get null info,please input email and password";
		}else{//后期从数据库验证 用户信息合法性  以及  sso扩展
			session.setAttribute("user_info", user);
			//System.out.println(url);
			return "success:hello,"+user.getEmail()+";your password is:"+user.getPassword();
		}
	}
}
