package com.atomicitysystems.Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	private final static Logger LOGGER = Logger.getLogger(RESTController.class.getName());

	@RequestMapping("/register")
	
	public String register(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
		//Logic
		return "true";
	}



	//Change this method to accept Hash directly from UI, to make it more secure
	@RequestMapping("/authenticate")
	public boolean authenticate(@RequestParam(value = "userid", defaultValue = "none") String userid,
			@RequestParam(value = "password", defaultValue = "none") String password) {
		if (hashFromUI.equals(hashFromDB))
			return true;
		else
			return false;
	}

	//Deprecate this method and use getList with param
	@RequestMapping("/commandList")
	public List<Mapping> commandList(@RequestParam(value = "name", defaultValue = "none") String name) {
		return li2;
	}

	@RequestMapping("/getList")
	public List<Mapping> getList(@RequestParam(value = "name", defaultValue = "none") String name) {
		return li2;
	}

	@RequestMapping("/form")
	public List<Mapping> showMessage(@RequestParam(value = "action", required = true) String action,
			@RequestParam(value = "requestor", required = false) String requestor,
			@RequestParam(value = "team", required = false) String team) {
		return li;
	}

	@RequestMapping(value = ("/RequestAnOperation"), method = RequestMethod.GET)
	public String search(@RequestParam Map<String, String> allRequestParams) {
		String txnNumber;
		return "{\"txnNumber\":" + txnNumber + "}";
	}

	@RequestMapping(value = "/serve/{id}")
	@ResponseBody
	public String serve(@PathVariable("id") String id) {
		return sb.toString();
	}

	@RequestMapping("/PerformOperation")
	public String x(@RequestParam Map<String, String> allRequestParams) {
		return "{\"status\":\"" + status + "\"}";
	}
}
