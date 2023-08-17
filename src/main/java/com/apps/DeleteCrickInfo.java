package com.apps;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Cricket;
import com.beans.CricketOperations;

public class DeleteCrickInfo {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
		CricketOperations crkoperations = (CricketOperations)app.getBean("CricketObj");
		
		Cricket crk = new Cricket();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Cricket Number : ");
		int cno = sc.nextInt();
		
		Cricket c = crkoperations.SearchCrickterInfo(cno);
		
		if(crk!=null) {
			int res=crkoperations.deleteCricketDetails(cno);
			if(res>=1) 
				System.out.println("Cricketer details are deleted");
			else
				System.out.println("Error");
			
		}
	}
}
