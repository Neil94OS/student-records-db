//NeiL O'Sullivan R00206266 SDH2B
package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;

/**
*Class for a student with name, id and date of birth 
*/
public class Student {
	 @Id
	    @Column(name="NAME")
	    private Name name;// name
	 
	    @Column(name="ID")
	    private String id; // student id
	 
	    @Column(name="DOB")
	    private DateOfBirth dob;// date of birth
	    
	    /**
		*Constructor
		* @param n name of type Name
		* @param i id 
		* @param d date of birth of type DateOfBirth
		*/
	public Student (Name n, String i, DateOfBirth d){
		
		name = n;
		id = i;
		dob = d;
	}

	/**
	*Default constructor for name
	*/
	public Student(){} 


	/**
	*Returns the name
	*@return  the name
	*/
	public Name getName() {
		return name;
	}
	
	/**
	*Sets the id
	*@param i id
	*/
	public void setId(String i ){
		id= i;
	}
	
	/**
	*Returns the id
	*@return the id
	*/
	public String getId() {
		return id;
	}
	
	/**
	*Sets the name
	*@param n name
	*/
	public void setName(Name n ){
		name = n;
	}
	
	/**
	*Returns the DOB
	*@return the DOB
	*/
	public DateOfBirth getDOB() {
		return dob;
	}
	
	/**
	*Sets the DOB
	*@param d dob
	*/
	public void setDOB( DateOfBirth d ){
		dob=d;
	}
	
	/**
	*Returns the student name id and dob as a string
	*@return the student name id and dob as a string
	*/
	 public String toString()
	 {
       String s = "Name: " + name + "Student Number:  " +id+ "   D.O.B: "+dob +"\n\n";
	   return s;
	 }
}
