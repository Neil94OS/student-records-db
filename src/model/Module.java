//NeiL O'Sullivan R00206266 SDH2B
package model;

import java.io.Serializable;

/**
*Class for a module with name and grade info
*/
public class Module {
	private String name;  // module name
	private String grade;	// module result
	
	/**
	*Constructor 
	* @param  n name of the module
	* @param g grade of the module 
	*/
	public Module (String n, String g){
		
		name = n;
		grade = g;
	
	}
	
	/**
	*Default constructor for module
	*/
	public Module(){} 
	
	/**
	*Returns the name of a module
	* @return  name of a module
	*/
	public String getName() {
		return name;
	}
	
	/**
	*Sets the grade of a module
	* @param g  grade of a module
	*/
	public void setGrade(String g ){
		grade = g;
	}
	
	/**
	*Returns the grade of a module
	* @return  the grade for a students module 
	*/
	public String getGrade() {
		return grade;
	}
	
	/**
	*Sets the name of a module
	* @param n  name of a module
	*/
	public void setName(String n ){
		name = n;
	}
	
	/**
	*Returns the module grade and name as a string
	* @return  the grade and module name as a string
	*/
	 public String toString()
	 {
       String s = "Module:  " + name + "   Grade:   " +grade+"\n";
	   return s;
	 }

	
}
