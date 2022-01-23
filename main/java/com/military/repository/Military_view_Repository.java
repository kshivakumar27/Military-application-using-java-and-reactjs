package com.military.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
@Repository
public class Military_view_Repository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	 
	@SuppressWarnings("rawtypes")
	public JSONArray get_military_list()
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT MS_ID,MS_ID FROM military_database.tbl_miltary_staff;" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  
				  ADD=new net.sf.json.JSONObject();
				  ADD.put("TYPE",row.get("MS_ID"));
				  ADD.put("NAME",row.get("MS_ID"));
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}

	
	@SuppressWarnings("rawtypes")
	public JSONArray get_department(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME,IFNULL(DE.FORCE_NAME,'') as FORCE_NAME, IFNULL(DE.FORCE_ID,'') as FORCE_ID,IFNULL(DE.BATALLION_NAME,'') as BATALLION_NAME,IFNULL(BATALLION_ID,'') as BATALLION_ID, IFNULL(De.DATEOFJOIN,'') as DATEOFJOIN,IFNULL(DEPT_ID,'') as DEPT_ID FROM military_database.tbl_miltary_staff st left join  military_database.tbl_department de on de.ms_id=st.ms_id where st.ms_id='"+MS_ID+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("FORCE_NAME",row.get("FORCE_NAME"));
				  ADD.put("FORCE_ID",row.get("FORCE_ID"));
				  ADD.put("BATALLION_NAME",row.get("BATALLION_NAME"));
				  ADD.put("BATALLION_ID",row.get("BATALLION_ID"));
				  ADD.put("DATEOFJOIN",row.get("DATEOFJOIN"));
				  ADD.put("DEPT_ID",row.get("DEPT_ID"));
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	@SuppressWarnings("rawtypes")
	public JSONArray get_family(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME, IFNULL(fm.NOMINEE_ID,'') as NOMINEE_ID, IFNULL(fm.NOMINEE,'') NOMINEE, IFNULL(fm.HOUSE_NO,'') HOUSE_NO, IFNULL(fm.STREET,'') as STREET, IFNULL(fm.CITY,'') CITY,  IFNULL(fm.PHONE_NO,'') PHONE_NO, IFNULL(fm.LOCATION,'') LOCATION  FROM military_database.tbl_miltary_staff st left join  military_database.tbl_family fm on fm.ms_id=st.ms_id where st.ms_id='"+MS_ID+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("NOMINEE_ID",row.get("NOMINEE_ID"));
				  ADD.put("NOMINEE",row.get("NOMINEE"));
				  ADD.put("HOUSE_NO",row.get("HOUSE_NO"));
				  ADD.put("STREET",row.get("STREET"));
				  ADD.put("CITY",row.get("CITY"));
				  ADD.put("PHONE_NO",row.get("PHONE_NO"));
				  ADD.put("LOCATION",row.get("LOCATION"));
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	
	@SuppressWarnings("rawtypes")
	public JSONArray get_medical(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME, IFNULL(cm.PATIENT_ID,'') as PATIENT_ID, IFNULL(cm.AREA,'') as AREA, IFNULL(cm.CAMP_NAME,'') as CAMP_NAME, IFNULL(cm.HEALTH_CONDITION,'') as HEALTH_CONDITION FROM military_database.tbl_miltary_staff st left join military_database.tbl_medical_camp cm on cm.ms_id=st.ms_id where st.ms_id='"+MS_ID+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  //STAFFNAME, PATIENT_ID, AREA, CAMP_NAME, HEALTH_CONDITION
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("PATIENT_ID",row.get("PATIENT_ID"));
				  ADD.put("AREA",row.get("AREA"));
				  ADD.put("CAMP_NAME",row.get("CAMP_NAME"));
				  ADD.put("HEALTH_CONDITION",row.get("HEALTH_CONDITION"));
				 
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	
	@SuppressWarnings("rawtypes")
	public JSONArray get_rank_status(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			 
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME,IFNULL(rs.RANK_NAME,'') RANK_NAME, IFNULL(rs.STATUS,'') STATUS,IFNULL(rs.SALARY_MONTH,'') SALARY_MONTH FROM military_database.tbl_miltary_staff st left join military_database.tbl_rank_status rs on rs.ms_id=st.ms_id where st.ms_id='"+MS_ID+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  //STAFFNAME, PATIENT_ID, AREA, CAMP_NAME, HEALTH_CONDITION
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("RANK_NAME",row.get("RANK_NAME"));
				  ADD.put("STATUS",row.get("STATUS"));
				  ADD.put("SALARY_MONTH",row.get("SALARY_MONTH"));
				  
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	@SuppressWarnings("rawtypes")
	public JSONArray get_rank_Status(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME, IFNULL(cm.RANK_NAME,'') as RANK_NAME, IFNULL(cm.STATUS,'') as STATUS, IFNULL(cm.SALARY_MONTH,'') as SALARY_MONTH  FROM military_database.tbl_miltary_staff st left join military_database.tbl_rank_status cm on cm.ms_id=st.ms_id where st.ms_id='12';SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME,  POSTING_ID, PERIOD_OF_WORK, AREA, CAMP_NAME, DATEOF_DUTY, IFNULL(cm.POSTING_ID,'') as POSTING_ID, IFNULL(cm.PERIOD_OF_WORK,'') as PERIOD_OF_WORK, IFNULL(cm.AREA,'') as AREA, IFNULL(cm.CAMP_NAME,'') as CAMP_NAME  FROM military_database.tbl_posting st left join military_military_database.tbl_posting ps on ps.ms_id=st.ms_id where st.ms_id='"+MS_ID+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("RANK_NAME",row.get("RANK_NAME"));
				  ADD.put("STATUS",row.get("STATUS"));
				  ADD.put("CAMP_NAME",row.get("CAMP_NAME"));
				  ADD.put("SALARY_MONTH",row.get("SALARY_MONTH"));
				  
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	
	@SuppressWarnings("rawtypes")
	public JSONArray get_posting(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT CONCAT(ST.FRISTNAME,' ',ST.LASTNAME) as STAFFNAME, 	IFNULL(tp.POSTING_ID,'') as POSTING_ID, 	 IFNULL(tp.PERIOD_OF_WORK,'') as PERIOD_OF_WORK, IFNULL(AREA,'') as AREA, 	IFNULL(CAMP_NAME,'') CAMP_NAME,IFNULL(DATEOF_DUTY,'') DATEOF_DUTY 	   FROM 	 military_database.tbl_miltary_staff st left join military_database.tbl_posting tp 	on tp.ms_id=st.ms_id where st.ms_id='"+MS_ID+"';" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			 
			 
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  ADD.put("STAFFNAME",row.get("STAFFNAME"));
				  ADD.put("POSTING_ID",row.get("POSTING_ID"));
				  ADD.put("PERIOD_OF_WORK",row.get("PERIOD_OF_WORK"));
				  ADD.put("AREA",row.get("AREA"));
				  ADD.put("CAMP_NAME",row.get("CAMP_NAME"));
				  ADD.put("DATEOF_DUTY",row.get("DATEOF_DUTY"));
				  
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	
	@SuppressWarnings("rawtypes")
	public JSONArray getview(String MS_ID)
	{
		JSONArray data= new JSONArray();
		net.sf.json.JSONObject ADD=new net.sf.json.JSONObject();
		try {
			String EMPINFO="SELECT ST.MS_ID STAFF_MS_ID, ST.FRISTNAME STAFF_FRISTNAME, ST.LASTNAME STAFF_LASTNAME, ST.GENDER GENDER, IFNULL(ST.DOB,'') STAFF_DOB, ST.HOUSE_NUMBER STAFF_HOUSE_NUMBER, ST.STREET STAFF_STREET, ST.CITY STAFF_CITY,ST.LOCATION STAFF_LOCATION, ST.PHONE_NUMBER STAFF_PHONE_NUMBER, IFNULL(DE.FORCE_NAME,'') as FORCE_NAME, IFNULL(DE.FORCE_ID,'') as FORCE_ID,IFNULL(DE.BATALLION_NAME,'') as BATALLION_NAME,IFNULL(BATALLION_ID,'') as BATALLION_ID, IFNULL(De.DATEOFJOIN,'0000-00-00') as DATEOFJOIN, IFNULL(DEPT_ID,'') as DEPT_ID, IFNULL(rs.RANK_NAME,'') RANK_NAME, IFNULL(rs.STATUS,'') RANK_STATUS, IFNULL(rs.SALARY_MONTH,'') SALARY_MONTH, IFNULL(cm.PATIENT_ID,'') as PATIENT_ID, IFNULL(cm.AREA,'') as AREA, IFNULL(cm.CAMP_NAME,'') as CAMP_NAME, IFNULL(cm.HEALTH_CONDITION,'') as HEALTH_CONDITION, IFNULL(fm.NOMINEE_ID,'') as NOMINEE_ID, IFNULL(fm.NOMINEE,'') NOMINEE, IFNULL(fm.HOUSE_NO,'') HOUSE_NO, IFNULL(fm.STREET,'') as STREET, IFNULL(fm.CITY,'') CITY, IFNULL(fm.PHONE_NO,'') PHONE_NO, IFNULL(fm.LOCATION,'') LOCATION, IFNULL(tp.POSTING_ID,'') as POSTING_ID, 	 IFNULL(tp.PERIOD_OF_WORK,'') as PERIOD_OF_WORK, IFNULL(tp.AREA,'') as AREA, 	 IFNULL(tp.CAMP_NAME,'') CAMP_NAME,IFNULL(DATEOF_DUTY,'') DATEOF_DUTY    FROM  military_database.tbl_miltary_staff st left join military_database.tbl_department de on de.ms_id=st.ms_id left join military_database.tbl_rank_status rs on rs.ms_id=st.ms_id left join military_database.tbl_medical_camp  cm on cm.ms_id=st.ms_id left join military_database.tbl_family  fm on fm.ms_id=st.ms_id left join military_database.tbl_posting tp on tp.ms_id=st.ms_id where st.ms_id='"+MS_ID+"';" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			  
			  for (@SuppressWarnings("rawtypes") Map row : rows) {
				  ADD=new net.sf.json.JSONObject();
				  
				  // Staff
				  
				  ADD.put("STAFF_MS_ID",row.get("STAFF_MS_ID"));
				  ADD.put("STAFF_FRISTNAME",row.get("STAFF_FRISTNAME"));
				  ADD.put("STAFF_LASTNAME",row.get("STAFF_LASTNAME"));
				  ADD.put("GENDER",row.get("GENDER"));
				  ADD.put("DOB",row.get("STAFF_DOB"));
				  ADD.put("STAFF_HOUSE_NUMBER",row.get("STAFF_HOUSE_NUMBER"));
				  ADD.put("STAFF_STREET",row.get("STAFF_STREET"));
				  ADD.put("STAFF_CITY",row.get("STAFF_CITY"));
				  ADD.put("STAFF_LOCATION",row.get("STAFF_LOCATION"));
				  ADD.put("STAFF_PHONE_NUMBER",row.get("STAFF_PHONE_NUMBER"));
				  
				  
				  /// Department 
				 
				  ADD.put("FORCE_NAME",row.get("FORCE_NAME"));
				  ADD.put("FORCE_ID",row.get("FORCE_ID"));
				  ADD.put("BATALLION_NAME",row.get("BATALLION_NAME"));
				  ADD.put("BATALLION_ID",row.get("BATALLION_ID"));
				  ADD.put("DATEOFJOIN",row.get("DATEOFJOIN"));
				  ADD.put("DEPT_ID",row.get("DEPT_ID"));
				  
				  // family
				  
				 
				  ADD.put("NOMINEE_ID",row.get("NOMINEE_ID"));
				  ADD.put("NOMINEE",row.get("NOMINEE"));
				  ADD.put("HOUSE_NO",row.get("HOUSE_NO"));
				  ADD.put("STREET",row.get("STREET"));
				  ADD.put("CITY",row.get("CITY"));
				  ADD.put("PHONE_NO",row.get("PHONE_NO"));
				  ADD.put("LOCATION",row.get("LOCATION"));
				  
				  // Medical
				  
				 
				  ADD.put("PATIENT_ID",row.get("PATIENT_ID"));
				  ADD.put("AREA",row.get("AREA"));
				  ADD.put("CAMP_NAME",row.get("CAMP_NAME"));
				  ADD.put("HEALTH_CONDITION",row.get("HEALTH_CONDITION"));
				  
				  
				  ///Rank
				  
				  
				  ADD.put("RANK_NAME",row.get("RANK_NAME"));
				  ADD.put("RANK_STATUS",row.get("RANK_STATUS"));
				  ADD.put("SALARY_MONTH",row.get("SALARY_MONTH"));
				  
				  // Posting
				  
				 
				  ADD.put("POSTING_ID",row.get("POSTING_ID"));
				  ADD.put("PERIOD_OF_WORK",row.get("PERIOD_OF_WORK"));
				  ADD.put("AREA",row.get("AREA"));
				  ADD.put("CAMP_NAME",row.get("CAMP_NAME"));
				  ADD.put("DATEOF_DUTY",row.get("DATEOF_DUTY"));
				  
				  
				  
				  data.add(ADD);
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return data;
	}
	
	//
	}
