package com.beans;

import java.util.List;
import com.beans.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CricketOperations {
	private DataSource dsource; //which stores connection info
	private JdbcTemplate jt; //to perform CURD operations on DB tables
	public DataSource getDsource() {
		return dsource;
	}
	public void setDsource(DataSource dsource) {
		this.dsource = dsource;
		jt = new JdbcTemplate(dsource);
	}
	
	public int AddNewCricketerDetails(Cricket crk) {
		String inscmd = "Insert into Cricket(crkName,typeofgame,runs) values(?,?,?)";
		int result = jt.update(inscmd, new Object[]{crk.getCrkName(),crk.getTypeofgame(),crk.getRuns()});
		return result;
	}
	
	public List<Cricket2> showAll(){
		List<Cricket2> crkAll = jt.query("Select * from Cricket", new BeanPropertyRowMapper(Cricket2.class));
		return crkAll;
		//BeanPropertyRowMapper method is used to convert the rows and columns of a table in db to a list.
	}
	
	public Cricket  SearchCrickterInfo(int cno)
	{
		Cricket cinfo = null;
		
		try
		{
		String sql = "Select * from Cricket where cno=?";
		
		cinfo = jt.queryForObject(sql, new Object[] {cno}, new BeanPropertyRowMapper(Cricket.class));
		}
		catch(Exception ex)
		{
			cinfo = null;
		}
		
		return cinfo;
	}
		
	public int updateCricketDetails(Cricket crk) {
		String uptcmd = "Update Cricket Set crkName=? where cno=?";
		int result = jt.update(uptcmd,new Object[] {crk.getCrkName(),crk.getCno()});
		return result;
	}
	
	public int deleteCricketDetails(int cno) {
		String delcmd = "Delete from Cricket where cno=?";
		int result = jt.update(delcmd,new Object[] {cno});
		return result;
	}
	
	//custom row mapper
	public List<Cricket2> findAll(){
		List<Cricket2> crkAll = jt.query("Select * from Cricket", new CricketRowMapper());
		return crkAll;
		//BeanPropertyRowMapper method is used to convert the rows and columns of a table in db to a list.
	}
}







