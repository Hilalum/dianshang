package com.zhgy.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseAction {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openMain(Model model){

		return "empty_page";
	}

}
// 1761 + 2390 + 4091 + 1486 + 549 + 3837 =  14114