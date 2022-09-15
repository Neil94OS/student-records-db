package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import org.junit.jupiter.api.Test;
import model.*;

class JunitTest {

	 String fN = "Bob";	
	 String i = "A";
	 String lN = "Kelly";
	 Name name = new Name(fN,i,lN);
	   
	   @Test
	   public void testfName() {	
	      System.out.println("Testing get first name of name");    
	      assertEquals(fN, name.getfName());
	
	   }
	   
	   @Test
	   public void testLName() {	
	      System.out.println("Testing get last name of name");    
	      assertEquals(lN, name.getlName());
	
	   }
	   
	   @Test
	   public void testInitial() {	
	      System.out.println("Testing get middle initial of name");    
	      assertEquals(i, name.getmInit());
	
	   }

}
