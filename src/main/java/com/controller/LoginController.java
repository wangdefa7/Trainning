package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 @Autowired private UserService userService;

	 /**
	  * 进入网站
	  **/
	@GetMapping("/")
	public String login(Model model) {
		logger.info("进入网站");
		model.addAttribute("user", new User());
		return "login/login";
	}

	/**
	 * 进入首页
	 **/
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 进入注册页面
	 **/
	@GetMapping("/register")
	public String register() {
		return "login/register";
	}

	@GetMapping("/title")
	public String title() {
		return "system/title";
	}
	
	//用户的登录
    @PostMapping(value = "/loginWeb")
    public String loginWeb(User user,Model model) {
    	logger.info("登录信息user:{}",user);
    	int result = userService.loginUser(user);
    	String msg;
    	if (result == 1){
			logger.info("登陆成功，用户的ID：{}", user.getId());
			return "index";
    	}else if (result > 1){
    		msg = "登录失败，该用户在系统中的账户异常，请联系管理员处理";
		}else {
			msg = "登录失败，该用户未注册";
		}
    	model.addAttribute("msg",msg);
		logger.error("登录失败，根据登录信息查询出来的条数:{}", result);
        return "error";
    }

	//用户的注册
	@PostMapping(value = "/registerUser")
	public String registerUser(User user,Model model) {
		logger.info("注册信息user:{}",user);
		String msg;
		try{
			int result = userService.registerUser(user);
			if (result == 1){
				logger.info("注册成功，用户的ID：{}", user.getId());
				model.addAttribute("msg","注册成功，请登录");
				return "login/login";
			}else{
				msg = "注册失败";
			}
		}catch (Exception e){
			logger.error("注册时出现异常",e);
			msg = "注册失败";
		}
		logger.error(msg);
		model.addAttribute("msg",msg);
		return "register";
	}


		
}
