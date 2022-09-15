//NeiL O'Sullivan R00206266 SDH2B
package view;

import model.*;
import control.*;
import view.*;
import application.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
*Class for a student list
*/
public class StudentList {
	
	 private ArrayList <Student> students; // array list of students
	 
	 /**
		*Constructor for the studentlist
		*/
	 public StudentList (){ 
		
		 students = new ArrayList <Student> ();
	 }
	 
	 /**
		*Returns the array list students
		* @return   the list of students
		*/
	 public ArrayList<Student> getList (){
	     return students;
	 }
	 
	 /**
		*Adds student to list
		* @param s student
		*/
	public void addStudent(Student s)
	{
		students.add(s);
	}
	
	 /**
	*Get a student 
	* @param i integer for student position in array
	* @return student at i
	*/
	public Student getStudent(int i)
	{
		if ((i>-1) && (i < students.size()))
			
     		return students.get (i);
		return null;
	}
	
	/**
	*Returns the size of students list
	* @return   size of list of students
	*/
	public int getSize (){
		return students.size();
	}
	
	
}