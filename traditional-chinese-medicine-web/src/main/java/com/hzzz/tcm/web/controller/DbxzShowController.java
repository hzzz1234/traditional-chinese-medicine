package com.hzzz.tcm.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzzz.tcm.web.service.DbxzShowService;
import com.hzzz.tcm.web.vo.DbxzShowVo;

@Controller
public class DbxzShowController extends BaseController {
	@Resource
	DbxzShowService dbxzShowService;

	@RequestMapping("/Show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		DbxzShowVo dbxzShowVo = new DbxzShowVo();
		dbxzShowVo.setDbxzRecords(dbxzShowService.selectArrangeRecords());
		mv.addObject("dbxzShowVo", dbxzShowVo);
		mv.setViewName("dbxz/show");
		return mv;
	}
}
