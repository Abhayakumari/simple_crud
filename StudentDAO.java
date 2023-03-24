package com.crud.Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentDAO {
	
	
	
	public static void createStudent(Student s, ArrayList<Student> list) {
		Random r = new Random();
		s.id= r.nextInt(10) + r.nextInt(100);
		list.add(s);
		System.out.println("User added successfully.");
	}
	
	public static void deleteStudentById(int id, ArrayList<Student> list) {
		int index =-1;
	    for(Student s:list) {
		 if(s.id==id) {
		   index = list.indexOf(s);
		   break;
		 }
		 
	 }
	  if(index==-1) {
	   System.out.println("User not found."); 
	 }else {
	 list.remove(index);
	 System.out.println("User deleted");
	 }
	}
	
	
	public static void getAllStudent(ArrayList<Student> list) {
		System.out.println(list);	
	}
	
	public static void getStudent(String id, ArrayList<Student> list) {
		System.out.println("inside getstuddent");
		  int intId=0;
		  String name=null;
		  String regex = "[0-9]+";
		  Pattern p = Pattern.compile(regex);
	      Matcher m = p.matcher(id);
	     if(m.matches()) {
	    	 System.out.println("inside matcher");
	    	intId=Integer.parseInt(id);
	     }else {
	    	name= id;
	     }
		for(Student st: list) {
			if(intId==st.id) {
				System.out.println(list.get(list.indexOf(st)));
			}else if(null!=name && name.equals(st.name)) {
				System.out.println(list.get(list.indexOf(st)));
			}
		}	
	}
	
	public static boolean updateStudentById(int id, String newName,String newAddress,ArrayList<Student> list) {
		for(Student s:list) {
			 if(s.id==id) {
			   s.setName(newName);
			   s.setAddress(newAddress);
			   return true;
			 }
		 }
		 return false;
	}

	
	public static void main(String arg[]) {
		try {
		ArrayList<Student> list = new ArrayList<Student>();
		System.out.println("Do crud operation(Y/N)");
		Scanner sc = new Scanner(System.in);
		String doCrud =sc.next();
		
		while(doCrud.equals("Y")) {
		System.out.println("Insert Student Details:0");
		System.out.println("Display all Students:1");
		System.out.println("Delete Student Record:2");
		System.out.println("Update Student Record:3");	
		System.out.println("Display Student:4");
		int userInput=sc.nextInt();
		switch(userInput) {
		case 0:{
			System.out.println("Enter Student name:");
			String name = sc.next();
			System.out.println("Student Address:");
			String address = sc.next();
			Student s = new Student(name, address);
			createStudent(s, list);
			break;
		} case 1:{
			getAllStudent(list);
			break;
		} case 2:{
			 System.out.println("Insert Student id to delete");
			 int id =sc.nextInt();
		     deleteStudentById(id, list);
		     break;
		} case 3:{
			 System.out.println("Insert Student id to update");
			 int id =sc.nextInt();
			 System.out.println("Insert Student new Name");
			 String newName =sc.next();
			 System.out.println("Insert Student new Address");
			 String newAddress =sc.next(); 
			if(updateStudentById(id,newName, newAddress, list))
				 System.out.println("User updated successfully.");
			else
				 System.out.println("User not found.");
			 break;
		} 
		case 4:{
			 System.out.println("Insert Student id/name");
			 String id =sc.next();
			getStudent(id, list);
			break;
		} default:{
			 System.out.println("Inserted number not in (0,1,2,3)");
		}
		
	  }
		System.out.println("Do crud operation(Y/N)");
		doCrud =sc.next();
		}
		}catch(Exception e) {
			System.out.println("Type Mismatch");
			e.printStackTrace();
		}
	}
}
