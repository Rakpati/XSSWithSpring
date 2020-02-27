package com.javadeveloperzone.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class RestEmployeeController 
{
	@Autowired
	private StudentForm studentDao;

    @Autowired
    private UserService userService;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}

	@RequestMapping("/Student/get")
	public StudentForm getStudent(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
		studentDao.setName(name);
		return studentDao;
	}

	@RequestMapping(value="/Student/update", method=RequestMethod.POST, consumes = "application/json")
	public StudentForm updatePerson(@RequestBody StudentForm p) {
		studentDao.setName(p.getName());
		return studentDao;
	}
	
	 @PostMapping("/all")
	    public ApiResponse<User> saveUser(@RequestBody UserDto user){
	        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
	    }

	    @GetMapping("/all")
	    public ApiResponse<List<User>> listUser(){
	        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
	    }

	    @GetMapping("/all/{id}")
	    public ApiResponse<User> getOne(@PathVariable int id){
	        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
	    }

	    @PutMapping("/all/{id}")
	    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
	        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
	    }

	    @DeleteMapping("/all/{id}")
	    public ApiResponse<Void> delete(@PathVariable int id) {
	        userService.delete(id);
	        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
	    }
	
	@RequestMapping(value = "/thirdPage")
	public ModelMap thirdPage(@RequestParam(name="name", required=false, defaultValue="Unknown") String name, 
			@RequestParam(name="address", required=false, defaultValue="Unknown") String address,
			ModelMap model) throws ParseException, JsonProcessingException {
		studentDao.setName(name);
		studentDao.setAddress(address);
		List<String> jsonList = new LinkedList<String>();
		ObjectMapper mapper = new ObjectMapper	();
		JSONParser parse = new JSONParser();
		String json = mapper.writeValueAsString(studentDao);
		JSONObject jsonObject = (JSONObject)parse.parse(json);
		System.out.println(jsonObject);
		
		System.out.println(jsonObject.get("name"));
		System.out.println(jsonObject.get("address"));
		jsonList.add((String) jsonObject.get("name"));
		jsonList.add((String) jsonObject.get("address"));
		model.put("info", jsonList);
		model.put("info2", StringEscapeUtils.escapeHtml(jsonObject.toString()));
		return model;
			// write your code to save details

		/*
		 * modelMap.put("employeeName",employeeName);
		 * modelMap.put("employeeEmail1",employeeEmail1);
		 * modelMap.put("employeeEmail2",employeeEmail2);
		 * modelMap.put("employeeEmail3",employeeEmail3);
		 * modelMap.put("employeeEmail4",employeeEmail4);
		 * modelMap.put("employeeEmail5",employeeEmail5);
		 */
		/*
		 * modelMap.put("employeeEmail6",employeeEmail5.replaceAll("\\<.*?\\>", ""));
		 * return modelMap;
		 */	}
	@RequestMapping(value="fourthPage", method=RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String fourthPage(HttpServletResponse response, @RequestParam("employeeName") String employeeName,
			@RequestParam("employeeEmail1") String employeeEmail1,
			@RequestParam("employeeEmail2") String employeeEmail2,
			@RequestParam("employeeEmail3") String employeeEmail3,
			@RequestParam("employeeEmail4") String employeeEmail4,
			@RequestParam("employeeEmail5") String employeeEmail5,
			ModelMap modelMap) throws IOException {
		// write your code to save details

		Gson gson = new Gson();
		modelMap.put("employeeName",employeeName); 
		modelMap.put("employeeEmail1",employeeEmail1);
		modelMap.put("employeeEmail2",employeeEmail2);
		modelMap.put("employeeEmail3",employeeEmail3);
		modelMap.put("employeeEmail4",employeeEmail4);
		modelMap.put("employeeEmail5",employeeEmail5);

		modelMap.put("employeeEmail6",employeeEmail5.replaceAll("\\<.*?\\>", ""));
		
		String jsonString = gson.toJson(modelMap);
		return jsonString;
	}

}