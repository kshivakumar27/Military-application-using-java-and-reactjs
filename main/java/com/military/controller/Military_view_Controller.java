package com.military.controller;

import java.util.LinkedHashMap;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.military.repository.Military_view_Repository;

import net.sf.json.JSONArray;


@RestController
@RequestMapping("/view_military")
public class Military_view_Controller {
	
	@Autowired
	Military_view_Repository viewRepository;
	 
	@PostMapping("staff_list")
	public LinkedHashMap<String, Object> get_military_list(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		 JSONArray Values = new JSONArray();
		 Values=viewRepository.get_military_list();
		 response.put("staff", Values);
		return response;
	}
	
	@PostMapping("department_list")
	public LinkedHashMap<String, Object> department_list(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		 JSONArray Values = new JSONArray();
		 Values=viewRepository.get_department(object.getString("ms_id"));
		 response.put("department", Values);
		return response;
	}
	
	@PostMapping("family_list")
	public LinkedHashMap<String, Object> family_list(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		 JSONArray Values = new JSONArray();
		 Values=viewRepository.get_family(object.getString("ms_id"));
		 response.put("family", Values);
		return response;
	}
	
	@PostMapping("medical_list")
	public LinkedHashMap<String, Object> medical_list(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		 JSONArray Values = new JSONArray();
		 Values=viewRepository.get_medical(object.getString("ms_id"));
		 response.put("medical", Values);
		return response;
	}
	
	@PostMapping("rank_status")
	public LinkedHashMap<String, Object> rank_status(@RequestBody String login) throws JSONException {
		LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
		org.json.JSONObject object = new org.json.JSONObject(login);
		 JSONArray Values = new JSONArray();
		 Values=viewRepository.get_rank_status(object.getString("ms_id"));
		 response.put("rank_status", Values);
		return response;
		
	}
		@PostMapping("posting")
		public LinkedHashMap<String, Object> Posting(@RequestBody String login) throws JSONException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			org.json.JSONObject object = new org.json.JSONObject(login);
			 JSONArray Values = new JSONArray();
			 Values=viewRepository.get_posting(object.getString("ms_id"));
			 response.put("posting", Values);
			return response;
		
		
	}
		
		@PostMapping("view")
		public LinkedHashMap<String, Object> view(@RequestBody String login) throws JSONException {
			LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
			org.json.JSONObject object = new org.json.JSONObject(login);
			 JSONArray Values = new JSONArray();
			 Values=viewRepository.getview(object.getString("ms_id"));
			 response.put("view", Values);
			return response;
		
		
	}	

}
