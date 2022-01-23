package com.military.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.military.bean.Department;
import com.military.bean.Family;
import com.military.bean.Medicalcamp;
import com.military.bean.MilitaryStaff;
import com.military.bean.Posting;
import com.military.bean.Rank_Status;
@Repository
public class MilitaryRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
 	 
	@SuppressWarnings("rawtypes")
	public String login(String userid,String password)
	{
		 String COUNT="";
		try {
			String EMPINFO="SELECT COUNT(*) COUNT FROM military_database.tbl_admin_login where userid='"+userid+"' and password='"+password+"'" ;
			 List<Map<String, Object>>  rows = jdbcTemplate.queryForList(EMPINFO.toString());
			   for (Map row : rows) {
				  COUNT= row.get("COUNT").toString();
	        }
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return COUNT;
	}
	
	 
 
	public int addstaff(MilitaryStaff ms)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_miltary_staff (MS_ID, FRISTNAME, LASTNAME, GENDER, DOB, HOUSE_NUMBER, STREET, CITY, LOCATION, PHONE_NUMBER) SELECT '"+ms.getMs_id()+"', '"+ms.getFristname()+"', '"+ms.getLastname()+"','"+ms.getGender()+"', '"+ms.getDob()+"', '"+ms.getHouse_number()+"', '"+ms.getStreet()+"','"+ms.getCity()+"','"+ms.getLocation()+"','"+ms.getPhone_number()+"' FROM dual ";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
	
	public int add_department(Department dep)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_department (MS_ID, FORCE_NAME, FORCE_ID, BATALLION_NAME, BATALLION_ID, DATEOFJOIN, DEPT_ID) VALUES('"+dep.getMs_id()+"','"+dep.getForce_name()+"', '"+dep.getFore_id()+"','"+dep.getBatallion_name()+"','"+dep.getBatallion_id()+"','"+dep.getDateofjoin()+"','"+dep.getDept_id()+"') ON DUPLICATE KEY UPDATE FORCE_NAME='"+dep.getForce_name()+"', FORCE_ID='"+dep.getFore_id()+"', BATALLION_NAME='"+dep.getBatallion_name()+"', BATALLION_ID='"+dep.getBatallion_id()+"',DATEOFJOIN='"+dep.getDateofjoin()+"', DEPT_ID='"+dep.getDept_id()+"'";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
	
	public int add_rank_status(Rank_Status rs)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_rank_status (MS_ID, RANK_NAME, STATUS, SALARY_MONTH) VALUES('"+rs.getMs_id()+"','"+rs.getRank_name()+"','"+rs.getStatus()+"','"+rs.getSalary_month()+"') ON DUPLICATE KEY UPDATE RANK_NAME='"+rs.getRank_name()+"', STATUS='"+rs.getStatus()+"', SALARY_MONTH='"+rs.getSalary_month()+"' ";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
	
	public int add_medical_camp(Medicalcamp mc)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_medical_camp (MS_ID, PATIENT_ID, AREA, CAMP_NAME, HEALTH_CONDITION) VALUES('"+mc.getMs_id()+"','"+mc.getPatient_id()+"','"+mc.getArea()+"','"+mc.getCamp_name()+"','"+mc.getHealth_condition()+"') ON DUPLICATE KEY UPDATE PATIENT_ID='"+mc.getPatient_id()+"', AREA='"+mc.getArea()+"', CAMP_NAME='"+mc.getCamp_name()+"', HEALTH_CONDITION='"+mc.getHealth_condition()+"'";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
	
	
	public int add_family(Family fm)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_family (MS_ID, NOMINEE_ID, NOMINEE, HOUSE_NO, STREET, CITY, PHONE_NO, LOCATION) VALUES('"+fm.getMs_id()+"','"+fm.getNominee_id()+"','"+fm.getNominee()+"','"+fm.getHouse_no()+"','"+fm.getStreet()+"','"+fm.getCity()+"','"+fm.getPhone_no()+"','"+fm.getLocation()+"') ON DUPLICATE KEY UPDATE NOMINEE_ID='"+fm.getNominee_id()+"', NOMINEE='"+fm.getNominee()+"', HOUSE_NO='"+fm.getHouse_no()+"',STREET='"+fm.getStreet()+"', CITY='"+fm.getCity()+"', PHONE_NO='"+fm.getPhone_no()+"', LOCATION='"+fm.getLocation()+"' ";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
	
	public int add_posting(Posting ps)
	{
		 int count=0;
		try {
			 String sql = "INSERT INTO military_database.tbl_posting (MS_ID, POSTING_ID, PERIOD_OF_WORK, AREA, CAMP_NAME, DATEOF_DUTY) VALUES('"+ps.getMs_id()+"','"+ps.getPosting_id()+"','"+ps.getPeriod_of_work()+"','"+ps.getArea()+"','"+ps.getCamp_name()+"','"+ps.getDateof_work()+"') ON DUPLICATE KEY UPDATE POSTING_ID='"+ps.getPosting_id()+"', PERIOD_OF_WORK='"+ps.getPeriod_of_work()+"', AREA='"+ps.getArea()+"', CAMP_NAME='"+ps.getCamp_name()+"', DATEOF_DUTY='"+ps.getDateof_work()+"';";
			 System.out.println(sql);
			 count=jdbcTemplate.update(sql);
			}catch(Exception err){
				System.out.println("Exception at reverse" +err);
			}
		return count;
	}
}
	            
 
