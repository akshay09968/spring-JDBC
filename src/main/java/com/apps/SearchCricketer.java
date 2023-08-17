package com.apps;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Cricket;
import com.beans.CricketOperations;
// adding new cricketer details
public class SearchCricketer {

	public static void main(String[] args) {
		ApplicationContext  app = new ClassPathXmlApplicationContext("config.xml");
		CricketOperations crkoperations = (CricketOperations)app.getBean("CricketObj");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Cricket Number : ");
		int cno = sc.nextInt();
		
		Cricket c = crkoperations.SearchCrickterInfo(cno);
		
		if(c!=null)
		{
			System.out.println(c.getCno() + "\t" + c.getCrkName() + "\t" + c.getTypeofgame() + "\t" + c.getRuns());
		}
		else
			System.out.println("Not Found");
	}
}