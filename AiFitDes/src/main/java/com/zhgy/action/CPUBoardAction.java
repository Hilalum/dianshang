package com.zhgy.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/cpuhtml", method = RequestMethod.GET)
public class CPUBoardAction {

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public String openHTML(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return name.toString();
    }
}
