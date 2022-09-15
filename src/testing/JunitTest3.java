package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;



import model.*;
import model.Module;

import org.junit.jupiter.api.Test;

class JunitTest3 {

	String fN = "Bob";	
	 String i = "A";
	 String lN = "Kelly";
	 Name name = new Name(fN,i,lN);
	 
	 String id ="1";
	 DateOfBirth dob = new DateOfBirth ("28/07/1994");
	 
	 Student student = new Student(name,id,dob);
	   
	   @Test
	   public void testName() {	
	      System.out.println("Testing get name of student");    
	      assertEquals(name, student.getName());
	
	   }
	   
	   @Test
	   public void testID() {	
	      System.out.println("Testing get id of student");    
	      assertEquals(id, student.getId());
	
	   }
	   
	   @Test
	   public void testDOB() {	
	      System.out.println("Testing get dob of student");    
	      assertEquals(dob, student.getDOB());
	
	   }

}
