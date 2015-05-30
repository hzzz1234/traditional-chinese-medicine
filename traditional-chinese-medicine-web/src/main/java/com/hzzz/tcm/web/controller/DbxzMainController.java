package com.hzzz.tcm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.web.service.DbxzMainService;
import com.hzzz.tcm.web.vo.DbxzMainVo;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

@Controller
public class DbxzMainController extends BaseController {

	@Resource
	DbxzMainService dbxzMainService;

	@RequestMapping("/home")
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

	@RequestMapping("/home/finish/{recordid}")
	@ResponseBody
	public Object finish(@PathVariable("recordid") Integer recordid) {
		int count = dbxzMainService.updatefinish(recordid);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/home/cancel/{recordid}")
	@ResponseBody
	public Object cancel(@PathVariable("recordid") Integer recordid) {
		int count = dbxzMainService.updatedelete(recordid);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/home/reback/{recordid}")
	@ResponseBody
	public Object reback(@PathVariable("recordid") Integer recordid) {
		int count = dbxzMainService.updateRollback(recordid);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/home/arrange/{patientid}")
	@ResponseBody
	public Object arrange(@PathVariable("patientid") Integer patientid) {
		Dbxzpatient dbxzpatient = dbxzMainService.selectPatient(patientid);
		Map<String, Object> map = new HashMap<String, Object>();
		if (dbxzpatient == null || dbxzpatient.getDeleted() == 1) {
			map.put("flag", "error");
			map.put("result", "无此病历号");
			Object o = JSON.toJSON(map);
			return o;
		}
		int count = dbxzMainService.insertArrange(patientid);
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/home/getArrangePatients")
	@ResponseBody
	public Object getArrangePatients() {
		List<DbxzRecord> dbxzRecords = dbxzMainService.selectArrangeRecords();
		return dbxzRecords;
	}

	@RequestMapping("/home/rescue/{recordid}")
	@ResponseBody
	public Object rescue(@PathVariable("recordid") Integer recordid) {
		int count = dbxzMainService.updateRescue(recordid);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/home/clean/")
	@ResponseBody
	public Object rescue(String recordids) {
		String[] s = recordids.split(",");
		int count = 0;
		for (String ss : s) {
			count += dbxzMainService.updatedelete(Integer.valueOf(ss));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}
}
