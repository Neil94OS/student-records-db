package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import model.*;
import model.Module;

import org.junit.jupiter.api.Test;

class JunitTest2 {

	 String n = "Java";	
	 String g = "80";
	 Module module = new Module(n,g);
	   
	   @Test
	   public void testGrade() {	
	      System.out.println("Testing get grade of module");    
	      assertEquals(g, module.getGrade());
	
	   }
	   
	   @Test
	   public void testName() {	
	      System.out.println("Testing get name of module");    
	      assertEquals(n, module.getName());
	
	   }

}
