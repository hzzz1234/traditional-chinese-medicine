package com.hzzz.tcm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzzz.tcm.web.service.DbxzMainService;
import com.hzzz.tcm.web.vo.DbxzMainVo;

@Controller
public class DbxzMainController extends BaseController {

	@Resource
	DbxzMainService dbxzMainService;

	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		whichmainmenu = 1;
		DbxzMainVo dbxzMainVo = new DbxzMainVo();
		dbxzMainVo.setWaitList(dbxzMainService.selectArrangeRecords());
		dbxzMainVo.setRescueList(dbxzMainService.selectRescueRecords());
		mv.setViewName("dbxz/home");
		mv.addObject("dbxzMainVo", dbxzMainVo);
		mv.addObject("whichmainmenu", whichmainmenu);
		return mv;
	}
}
