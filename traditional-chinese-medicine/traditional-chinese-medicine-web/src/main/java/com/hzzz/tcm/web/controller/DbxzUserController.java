package com.hzzz.tcm.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.web.service.DbxzUserService;
import com.hzzz.tcm.web.vo.DbxzUserVo;
import com.hzzz.tcm.web.vo.Page;

@Controller
public class DbxzUserController extends BaseController {
	@Resource
	DbxzUserService dbxzUserService;

	@RequestMapping("/User")
	public ModelAndView user(DbxzUserVo dbUserVo) {
		ModelAndView mv = new ModelAndView();
		Page page = new Page();
		Long count = dbxzUserService.selectDbxzpatientsCount(dbUserVo.getCondition());
		List<Dbxzpatient> ps = dbxzUserService.selectDbxzpatients(dbUserVo.getCondition(), page);
		page.setItemCount(count);
		dbUserVo.setDbxzPatients(ps);
		dbUserVo.setPage(page);
		whichmainmenu = 2;
		mv.addObject("whichmainmenu", whichmainmenu);
		mv.addObject("dbUserVo", dbUserVo);
		mv.setViewName("dbxz/user");
		return mv;
	}
}
