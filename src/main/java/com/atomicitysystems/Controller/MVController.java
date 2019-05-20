package com.atomicitysystems.Controller;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVController {
	private final static Logger LOGGER = Logger.getLogger(MVController.class.getName());

	//Another operation
	@RequestMapping("/Action1")
	public String showMessage1(@RequestParam(value = "txnNumber") String txnNumber, Model model) {
		return "perform";
	}

	@RequestMapping("/Action2")
	public ModelAndView showMessage2(@RequestParam(value = "txnNumber") String txnNumber) {
		ModelAndView mv = new ModelAndView("reject");
		return mv;
	}

	@RequestMapping("/verifyEmail")
	public ModelAndView verifyEmail(@RequestParam(value = "key") String key,
			@RequestParam(value = "email") String email) {
		ModelAndView mv;
		return mv;
	}

}
