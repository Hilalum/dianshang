package com.zhgy.action;

import com.zhgy.entity.CpuEntity;
import com.zhgy.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;

@Controller
public class BaseAction {
	
	@Autowired
	private CpuService cpuService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openMain(Model model){
		ArrayList<CpuEntity> list = cpuService.getAll();
		for(int i=0; i<list.size(); i++){
			CpuEntity ce = list.get(i);
			System.out.println(ce.getId()+" "+ce.getBrands());
		}
		return "all_dep";
	}

}
