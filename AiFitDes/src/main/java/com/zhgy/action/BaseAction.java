package com.zhgy.action;

import com.zhgy.entity.CpuEntity;
import com.zhgy.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseAction {
	
	@Autowired
	private CpuService cpuService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openMain(Model model){
		return "index";
	}

}
// 1761 + 2390 + 4091 + 1486 + 549 + 3837 =  14114