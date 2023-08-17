package com.apps;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Cricket;
import com.beans.CricketOperations;

public class UpdateCrickInfo {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
		CricketOperations crkoperations = (CricketOperations)app.getBean("CricketObj");
		
		Cricket crk = new Cricket();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the cricketrer number: ");
		int cno = sc.nextInt();
		
		crk = crkoperations.SearchCrickterInfo(cno);
		if(crk!=null) {
			System.out.println("Present name: "+crk.getCrkName());
			System.out.println("Enter the new name for the cricketer ");
			crk.setCrkName(sc.next());
			int res = crkoperations.updateCricketDetails(crk);
			if(res>=1)
				System.out.println("Cricketer details are added");
			else
				System.out.println("Error");
		}else 
			System.out.println("Not found");
	}
}
