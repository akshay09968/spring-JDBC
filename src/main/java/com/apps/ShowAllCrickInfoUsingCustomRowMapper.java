package com.apps;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Cricket;
import com.beans.Cricket2;
import com.beans.CricketOperations;
// adding new cricketer details
public class ShowAllCrickInfoUsingCustomRowMapper {

	public static void main(String[] args) {
		ApplicationContext  app = new ClassPathXmlApplicationContext("config.xml");
		CricketOperations crkoperations = (CricketOperations)app.getBean("CricketObj");
		
		List<Cricket2>  call = crkoperations.showAll();
		
		for(Cricket2 c : call)
		{
			System.out.println(c.getCrkno() + "\t" + c.getCrkName() + "\t" + c.getGame() + "\t" + c.getRuns());
		}
	}
} 