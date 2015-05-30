package com.hzzz.tcm.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzzz.tcm.domain.model.Dbxzsystemuser;
import com.hzzz.tcm.web.service.DbxzSystemUserService;

@Controller
public class DbxzLoginController extends BaseController {
	@Resource
	DbxzSystemUserService dbxzSystemUserService;

	@RequestMapping("/login")
	public ModelAndView main(String username, String password) {
		ModelAndView mv = new ModelAndView();
		Dbxzsystemuser dbxzsystemuser = dbxzSystemUserService.selectByUserNameAndPassword(username, password);
		if (dbxzsystemuser == null) {
			mv.setViewName("dbxz/login");
			return mv;
		} else {
			HttpSession session = this.request.getSession();
			session.setAttribute("username", username);
			return new ModelAndView("redirect:/home");
		}
	}

	@RequestMapping("/quit")
	public ModelAndView quit(String username, String password) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = this.request.getSession();
		session.removeAttribute("username");
		return new ModelAndView("redirect:/home");
	}
}
