package com.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CricketRowMapper implements RowMapper<Cricket2>{

	public Cricket2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cricket2 crkinfo = new Cricket2();
		crkinfo.setCrkno(rs.getInt("cno"));
		crkinfo.setCrkName(rs.getString("crkName"));
		crkinfo.setGame(rs.getString("typeofgame"));
		crkinfo.setRuns(rs.getInt("runs"));
		return crkinfo;
	}
 
}
