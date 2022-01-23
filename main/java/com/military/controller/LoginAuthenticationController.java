package com.military.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.military.bean.Department;
import com.military.bean.Family;
import com.military.bean.Medicalcamp;
import com.military.bean.MilitaryStaff;
import com.military.bean.Posting;
import com.military.bean.Rank_Status;
import com.military.repository.MilitaryRepository;
  
 
@RestController
@RequestMapping("/msaction")
public class LoginAuthenticationController {
	 
	@Autowired
	MilitaryRepository mstUserRepository;
    
	@PostMapping("/login")
	public LinkedHashMap<String, Object> login(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		String user = null;
		user = mstUserRepository.login(object.getString("username").toString(),object.get("password").toString());
		response.put("status",user);
		return response;
	}
	
	 @PostMapping(value = "/add_staff",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> addstaff(@RequestBody MilitaryStaff ms) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.addstaff(ms);
			response.put("status",user); 
			return response;
			}
	 
	 @PostMapping(value = "/add_department",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> add_department(@RequestBody Department dep) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.add_department(dep);
			response.put("status",user); 
			return response;
			}
	 
	 
	 @PostMapping(value = "/add_rank_status",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> add_rank_status(@RequestBody Rank_Status rs) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.add_rank_status(rs);
			response.put("status",user); 
			return response;
			}
	 
	 @PostMapping(value = "/add_medical_camp",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> add_medical_camp(@RequestBody Medicalcamp mc) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.add_medical_camp(mc);
			response.put("status",user); 
			return response;
			}
	 
	 @PostMapping(value = "/add_family",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> add_family(@RequestBody Family fm) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.add_family(fm);
			response.put("status",user); 
			return response;
			}
	 
	 
	 @PostMapping(value = "/add_posting",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public LinkedHashMap<String, Object> add_posting(@RequestBody Posting ps) throws JSONException, SQLException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			int user = 0;
			user=mstUserRepository.add_posting(ps);
			response.put("status",user); 
			return response;
			}
	 
	 
}
