package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.studentDao;
import com.spring.orm.entities.student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    ApplicationContext context=	new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
    studentDao sd = context.getBean("studentDao",studentDao.class);
    
	/*
	 * student s = new student(2323,"appa", "china");
	 * 
	 * int r =sd.insert(s); 
	 * System.out.println("done"+r);
	 */
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Boolean go = true;
    
   while(go) {
	    System.out.println("Press 1 : Add New student");
	    System.out.println("Press 2 : Display All student");
	    System.out.println("Press 3 : Get details of single student");
	    System.out.println("Press 4 : Delete student");
	    System.out.println("Press 5 : Update student");
	    System.out.println("Press 6 : Exit");
	    
	   
	    try {
	    	int input = Integer.parseInt(br.readLine());
			/*
			 * if(input==1) { //Add New student }else if(input==2) { //Display All student }
			 */
	    	
	    	
	    	switch(input){
	    	case 1:
	    		//Add New student
	    		//Tacking input from user
	    		System.out.println("Enter user id :");
	    		int uId = Integer.parseInt(br.readLine());
	    		
	    		System.out.println("Enter user Name :");
	    		String uName = br.readLine();
	    		
	    		System.out.println("Enter user City :");
	    		String uCity = br.readLine();
	    		//creating student object and setting values
	    		student s = new student();
	    		s.setStudentId(uId);
	    		s.setName(uName);
	    		s.setCity(uCity);
	    		
	    		//saving student object to database by calling insert of student dao
	    		int r = sd.insert(s);
	    		System.out.println(r+" student added");
	    		System.out.println("****************************************************************");
	    		
	    		break;
	    	case 2:
	    		// Display All student
	    		System.out.println("****************************************************************");
	    		List<student> allStudents =sd.getAllStudent();
	    		for(student sp:allStudents) {
	    			System.out.println("Id :"+sp.getStudentId());
	    			System.out.println("Name :"+sp.getName());
	    			System.out.println("City:"+sp.getCity());
	    			System.out.println("______________________________________________________________");
	    		}
	    		
	    		System.out.println("****************************************************************");
	    		
	    		break;
	    	case 3:
	    		 //Get details of single student
	    		System.out.println("****************************************************************");
	    		System.out.println("Enter user Id :");
	    		int userId = Integer.parseInt(br.readLine());
	    		student st =sd.setStudent(userId);
	    		System.out.println("Id :"+st.getStudentId());
    			System.out.println("Name :"+st.getName());
    			System.out.println("City:"+st.getCity());
    			System.out.println("______________________________________________________________");
    			System.out.println("****************************************************************");
	    		break;
	    	case 4:
	    		//Delete student
	    		System.out.println("****************************************************************");
	    		System.out.println("Enter user Id :");
	    		int Id = Integer.parseInt(br.readLine());
	    		sd.deleteStudent(Id);
	    		System.out.println("______________________________________________________________");
	    		System.out.println("Student Deleted.........");
	    		System.out.println("______________________________________________________________");
    			System.out.println("****************************************************************");

    			break;	
	    	case 5:
	    		//Update student
	    		System.out.println("****************************************************************");
	    		System.out.println("Enter user Id :");
	    		int id = Integer.parseInt(br.readLine());
	    		
	    		student s1 = new student();
	    		
	    		System.out.println("Enter New user Name :");
	    		String Name = br.readLine();
	    		
	    		System.out.println("Enter New user City :");
	    		String City = br.readLine();
	    		
	    		s1.setStudentId(id);
	    		s1.setName(Name);
	    		s1.setCity(City);
	    		sd.updateStudent(s1);
	    		System.out.println("______________________________________________________________");
	    		System.out.println(" +++++++++++++++++Updated student .......++++++++++++++++++");
	    		System.out.println("****************************************************************");
	    		
	    		break;
	    	case 6:
	    		//Exit
	    		go=false;
	    		break;
	    	
	    	}
	    	
		} catch (Exception e) {
			System.out.println("Invalid Input Try with another!!!!");
			System.out.println(e.getMessage());
		}
   }
       System.out.println("Thank u for using our application");
       System.out.println("See u soon");

    
    }
}
