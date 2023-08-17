package com.apps;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Cricket;
import com.beans.CricketOperations;


//adding new cricketer details
public class CricketApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
		CricketOperations crkoperations = (CricketOperations)app.getBean("CricketObj");
		
		Cricket crk = new Cricket();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Crickter name: ");
		crk.setCrkName(sc.next());
		
		System.out.println("Type of game: (ODI,T20,Test)");
		crk.setTypeofgame(sc.next());
		
		System.out.println("Number of runs: ");
		crk.setRuns(sc.nextInt());
		
		
		int res = crkoperations.AddNewCricketerDetails(crk);

		if(res>=1)
			System.out.println("Crickter details added..... ");
		else 
			System.out.println("Error");
	}
}
