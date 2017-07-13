package com.hzzz.tcm.web.controller;

import java.util.ArrayList;
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
import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.web.service.DbxzUserService;
import com.hzzz.tcm.web.vo.DbxzPatientVo;
import com.hzzz.tcm.web.vo.DbxzUserVo;
import com.hzzz.tcm.web.vo.Page;
import com.hzzz.tcm.web.vo.wrapper.DbxzPatientSpec;

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
		List<Dbxzprescription> pres = dbxzUserService.selectDbxzprescriptions();
		Long maxId = dbxzUserService.selectMaxId();
		if(maxId == null){
			maxId = 1l;
		}
		page.setItemCount(count);
		dbUserVo.setDbxzPatients(ps);
		dbUserVo.setDbxzprescriptions(pres);
		dbUserVo.setPage(page);
		whichmainmenu = 2;
		mv.addObject("whichmainmenu", whichmainmenu);
		mv.addObject("dbUserVo", dbUserVo);
		mv.addObject("maxId", maxId);
		mv.setViewName("dbxz/user");
		return mv;
	}

	@RequestMapping("/User/query")
	@ResponseBody
	public Object query(String condition) {
		Page page = new Page();
		Long count = dbxzUserService.selectDbxzpatientsCount(condition);
		List<Dbxzpatient> ps = dbxzUserService.selectDbxzpatients(condition, page);
		page.setItemCount(count);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("result", ps);
		return JSON.toJSON(map);
	}

	@RequestMapping("/User/getUser/{pid}")
	@ResponseBody
	public Object getUser(@PathVariable("pid") Integer pid) {
		DbxzPatientSpec d = dbxzUserService.selectDbxzpatientSpecById(pid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", d);
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/addMedicine/")
	@ResponseBody
	public Object addMedicine(String medicine) {
		Dbxzprescription dbxzprescription = dbxzUserService.selectbyMedication(medicine);
		Map<String, Object> map = new HashMap<String, Object>();
		if (dbxzprescription != null) {
			map.put("flag", "error");
			map.put("result", "重复添加");
			Object o = JSON.toJSON(map);
			return o;
		}
		Dbxzprescription dpre = new Dbxzprescription();
		dpre.setMedication(medicine);
		dpre.setUse("");
		int count = dbxzUserService.replaceSelectivePrescription(dpre);
		if (count > 0) {
			dbxzprescription = dbxzUserService.selectbyMedication(medicine);
			map.put("flag", "ok");
			map.put("result", dbxzprescription);
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/updateUser/")
	@ResponseBody
	public Object updateUser(DbxzPatientVo dbxzPatientVo) {
		Dbxzpatient dbxzpatient = new Dbxzpatient();
		Map<String, Object> map = new HashMap<String, Object>();
		dbxzpatient.setId(dbxzPatientVo.getId());
		dbxzpatient.setName(dbxzPatientVo.getName());
		dbxzpatient.setAge(dbxzPatientVo.getAge());
		dbxzpatient.setDuration(dbxzPatientVo.getDuration());
		dbxzpatient.setSex((byte) dbxzPatientVo.getSex());
		dbxzpatient.setContact(dbxzPatientVo.getContact());
		dbxzpatient.setSymptom(dbxzPatientVo.getSymptom());

		List<Integer> prescriptionids = new ArrayList<Integer>();
		if (!dbxzPatientVo.getPrescriptionids().equals("")) {
			String[] s = dbxzPatientVo.getPrescriptionids().split(",");
			for (String ss : s) {
				prescriptionids.add(Integer.valueOf(ss));
			}
		}

		int count = dbxzUserService.insertPatient(dbxzpatient, prescriptionids);
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/addUser/")
	@ResponseBody
	public Object addUser(DbxzPatientVo dbxzPatientVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (dbxzUserService.selectPatientByPrimaryKey(dbxzPatientVo.getId()) != null) {
			map.put("flag", "error");
			map.put("result", "已经存在对应病历号的病人");
			Object o = JSON.toJSON(map);
			return o;
		}
		Dbxzpatient dbxzpatient = new Dbxzpatient();
		dbxzpatient.setId(dbxzPatientVo.getId());
		dbxzpatient.setName(dbxzPatientVo.getName());
		dbxzpatient.setAge(dbxzPatientVo.getAge());
		dbxzpatient.setDuration(dbxzPatientVo.getDuration());
		dbxzpatient.setSex((byte) dbxzPatientVo.getSex());
		dbxzpatient.setContact(dbxzPatientVo.getContact());
		dbxzpatient.setSymptom(dbxzPatientVo.getSymptom());
		List<Integer> prescriptionids = new ArrayList<Integer>();
		if (!dbxzPatientVo.getPrescriptionids().equals("")) {
			String[] s = dbxzPatientVo.getPrescriptionids().split(",");
			for (String ss : s) {
				prescriptionids.add(Integer.valueOf(ss));
			}
		}
		int count = dbxzUserService.insertPatient(dbxzpatient, prescriptionids);
		long maxId = dbxzUserService.selectMaxId();
		if (count > 0) {
			map.put("flag", "ok");
			map.put("maxId", maxId);
		} else {
			map.put("flag", "error");
			map.put("result", "插入数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/deleteRecord/{recordid}")
	@ResponseBody
	public Object deleteRecord(@PathVariable("recordid") Integer recordid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = dbxzUserService.deleteRecord(recordid);
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/deletePatient/{patientid}")
	@ResponseBody
	public Object deletePatient(@PathVariable("patientid") Integer patientid) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = dbxzUserService.deleteSelectivePatient(patientid);
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/deletePrescriptions/")
	@ResponseBody
	public Object deletePrescriptions(String prescriptions) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		if (!prescriptions.equals("")) {
			String[] s = prescriptions.split(",");
			for (String ss : s) {
				count += dbxzUserService.updateDeletePrescriptionById(Integer.valueOf(ss));
			}
		}
		if (count > 0) {
			map.put("flag", "ok");
		} else {
			map.put("flag", "error");
			map.put("result", "数据库失败");
		}
		Object o = JSON.toJSON(map);
		return o;
	}

	@RequestMapping("/User/getPrescriptions")
	@ResponseBody
	public Object getPrescriptions() {
		List<Dbxzprescription> pres = dbxzUserService.selectDbxzprescriptions();
		return pres;
	}

}
