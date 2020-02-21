package com.javadeveloperzone.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
@Controller
public class EmployeeController {


	@GetMapping("getForm")
	public String getForm() {
		return "employeeFrom";
	}

	@PostMapping("/saveDetails")                     // it only support port method
	public String saveDetails(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeEmail1") String employeeEmail1,
			@RequestParam("employeeEmail2") String employeeEmail2,
			@RequestParam("employeeEmail3") String employeeEmail3,
			@RequestParam("employeeEmail4") String employeeEmail4,
			@RequestParam("employeeEmail5") String employeeEmail5,
			ModelMap modelMap) throws IOException {
		// write your code to save details
		modelMap.put("employeeName",employeeName); 
		modelMap.put("employeeEmail1",employeeEmail1);
		modelMap.put("employeeEmail2",employeeEmail2);
		modelMap.put("employeeEmail3",employeeEmail3);
		modelMap.put("employeeEmail4",employeeEmail4);
		modelMap.put("employeeEmail5",employeeEmail5);
		return "viewDetails";           // welcome is view name. It will call employeeFrom.jsp
	}
	@PostMapping("/secondPage")                     // it only support port method
	public String secondPage(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeEmail1") String employeeEmail1,
			@RequestParam("employeeEmail2") String employeeEmail2,
			@RequestParam("employeeEmail3") String employeeEmail3,
			@RequestParam("employeeEmail4") String employeeEmail4,
			@RequestParam("employeeEmail5") String employeeEmail5,
			ModelMap modelMap) throws IOException {
		// write your code to save details

		modelMap.put("employeeName",employeeName); 
		modelMap.put("employeeEmail1",employeeEmail1);
		modelMap.put("employeeEmail2",employeeEmail2);
		modelMap.put("employeeEmail3",employeeEmail3);
		modelMap.put("employeeEmail4",employeeEmail4);
		modelMap.put("employeeEmail5",employeeEmail5);

		modelMap.put("employeeEmail6",employeeEmail5.replaceAll("\\<.*?\\>", ""));

		return "secondPage";           // welcome is view name. It will call employeeFrom.jsp
	}
}
