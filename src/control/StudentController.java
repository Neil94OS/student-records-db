package control;


import model.*;
import model.Module;
import view.*;
import control.*;
import application.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
*Class for a student controller to control user input regarding students 
*/
public class StudentController {
	
	
   private static final String URL = "jdbc:derby:C:\\Users\\nosal\\eclipse-workspace\\OOPFinalProjectY2\\testDB;";
   private static final String USERNAME = "";
   private static final String PASSWORD = "";
   String serializedName = "";
   private StudentList studentList;

   private Connection connection = null; // manages connection
 
   private PreparedStatement addStudentStatement = null; 
   private PreparedStatement selectAllStudents = null; 
   private PreparedStatement removeStudentStatement = null; 
   private PreparedStatement removeModuleStatement = null; 
   private PreparedStatement updateStudentStatement = null; 
   private PreparedStatement showStudentStatement = null; 


	
   /**
	*Constructor for student controller
	*/
	public StudentController(){
		// constructor
		try 
	      {
	         connection = 
	            DriverManager.getConnection( URL, USERNAME, PASSWORD );

	        
	         addStudentStatement = connection.prepareStatement( 
	            "INSERT INTO STUDENTS" + 
	            "( Name, ID, DOB) " + 
	            "VALUES ( ?, ?,?)" );
	         
	         
	         removeStudentStatement = connection.prepareStatement(
		 	            "DELETE FROM STUDENTS WHERE ID =?"  
		 	            );
	         
	         removeModuleStatement = connection.prepareStatement(
		 	            "DELETE FROM MODULESANDGRADES WHERE ID =?"  
		 	            );
	         
	        updateStudentStatement = connection.prepareStatement(
	        		 "UPDATE STUDENTS "+
	                 "SET Name =?, ID =?, DOB =? "+
	        		 "WHERE ID =?"); 
	        		
	        		
	         
	         selectAllStudents = 
	                 connection.prepareStatement( "SELECT * FROM STUDENTS" );
	         
	         
	         showStudentStatement = connection.prepareStatement(
		 	            "SELECT * FROM STUDENTS WHERE ID =?"  
		 	            );
	         
	         
	         
	      }
	      catch ( SQLException sqlException )
	      {
	         sqlException.printStackTrace();
	         System.exit( 1 );
	      }
	}
	
	/**
	*add student to the database
	*@param name student name
	*@param id student id
	*@param dob student dob
	*@return number of lines added in the database
	*@throws java.io.IOException input/output exception 
	*/
	public int addStudentToList(Name name, String id,  DateOfBirth dob) throws IOException {
		int result = 0;
		
		    // set parameters for add student statement
		    try 
		    {
		 
		        
		    	addStudentStatement.setString( 1, name.toString() );
		    	addStudentStatement.setString( 2, id );
		    	addStudentStatement.setString( 3, dob.toString() );
		    	
		 
		       // insert the new student
		       result = addStudentStatement.executeUpdate(); 
		       System.out.println("Student :"+name.toString()+" added succesfully ");
		    } // end try
		    catch ( SQLException sqlException )
		    {
		       sqlException.printStackTrace();
		       close();
		    } // end catch
		    
		    return result;
		}
	
	/**
	*remove student from the database
	*@param id student id
    *@return number of lines removed in the database
    *@throws java.io.IOException input/output exception 
	*/
	public int removeStudent(String id) throws IOException {
		int result = 0;
		
		// set parameters for remove student statement and remove modules
		    try 
		    {
		 

		    	removeStudentStatement.setString( 1, id );
		    	removeModuleStatement.setString( 1, id );
		    	
		       
		       result = removeStudentStatement.executeUpdate(); // remove students
		       removeModuleStatement.executeUpdate(); //remove modules information aswell
		       System.out.println("Student ID: "+id+" deleted succesfully");
		    } // end try
		    catch ( SQLException sqlException )
		    {
		       sqlException.printStackTrace();
		       close();
		    } // end catch
		    
		    return result;
		}
	
	
	/**
	*update student in the database
	*@param name student name
	*@param id student id
	*@param dob student dob
	*@return number of lines changed in the database
	*@throws java.io.IOException input/output exception 
	*/
	public int updateStudent(Name name, String id,  DateOfBirth dob) throws IOException {
		int result = 0;
		
		//set parameters for update student
		    try 
		    {
		 
		        
		    	updateStudentStatement.setString( 1, name.toString() );
		    	updateStudentStatement.setString( 2, id );
		    	updateStudentStatement.setString( 3, dob.toString() );
		    	updateStudentStatement.setString( 4, id );
		 
		      
		       result = updateStudentStatement.executeUpdate(); //update student
		       System.out.println("Student :"+name.toString()+" updated succesfully ");
		    } // end try
		    catch ( SQLException sqlException )
		    {
		       sqlException.printStackTrace();
		       close();
		    } // end catch
		    
		    return result;
		}
	
	
	/**
	*Get list of a students 
	*@return string of students 
	*/
		public String getListStudent()
		{
			List<Student> students = getAllStudents();
			String allStudent="\0";
			for (int i = 0;i<students.size();i++)
			{
			    allStudent = allStudent+students.get(i);	
			}	
			return allStudent;
		}
		
		/**
		*Get list of a students 
		*@return List of students 
		*/
		public List<Student> getAllStudents()
		   {
		      List< Student > results = null;
		      ResultSet resultSet = null;
		      String fName="";
		      String init="";
		      String lName="";
		      
		      try 
		      {
		         // executeQuery returns ResultSet containing matching entries
		         resultSet = selectAllStudents.executeQuery(); 
		         results = new ArrayList< Student >();
		         
		         while ( resultSet.next() )
		         {
		        	
//Split string name into 3 to fit constructor to add new student 
		            		 String str = resultSet.getString("Name");
		            		 String[] arrSplit = str.split("\\s ");
		            		 
		            		 for (int i=0; i < arrSplit.length; i++){
		            		    	   fName= arrSplit[0];
		            		    	   init= arrSplit[1];
		            		    	   lName= arrSplit[i];
		            		      
		            		    }
		            
							Name n = new Name(fName,init, lName );
							
							//Create DOB object from string
							String str1=resultSet.getString("DOB");
							DateOfBirth d = new DateOfBirth (str1);
							
							
		            results.add( new Student(
		               n,
		               resultSet.getString("ID"),
		               d)
		            		);

		         } // end while
		      } // end try
		      
		      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace(); 
		         close();/////
		      } // end catch
		     
		      return results;
		   }
		
		/**
		*Get list of a students with student id
		*@param id student id
		*@return List of students 
		*/	
		public List<Student> showStudentInfo(String id)
		   {
		      List< Student > results = null;
		      ResultSet resultSet = null;
		      String fName="";
		      String init="";
		      String lName="";
		      
		      try 
		      {
		    	  
		    	  showStudentStatement.setString( 1, id );
		         // executeQuery returns ResultSet containing matching entries
		         resultSet = showStudentStatement.executeQuery();
		         results = new ArrayList< Student >();
		         
		         while ( resultSet.next() )
		         {
		        	
		        	//Split string name into 3 to fit constructor to add new student 
		            		 String str = resultSet.getString("Name");
		            		 String[] arrSplit = str.split("\\s ");
		            		 
		            		 for (int i=0; i < arrSplit.length; i++){
		            		    	   fName= arrSplit[0];
		            		    	   init= arrSplit[1];
		            		    	   lName= arrSplit[i];
		            		      
		            		    }
		            
		            		
							Name n = new Name(fName,init, lName );
							
							//Create DOB object from string
							String str1=resultSet.getString("DOB");
							DateOfBirth d = new DateOfBirth (str1);
							
		            results.add( new Student(
		               n,
		               resultSet.getString("ID"),
		               d)
		            		);

		         } // end while
		      } // end try
		      
		      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace();  
		         close();/////
		      } // end catch
		  
		      return results;
		   }
			
	
		/**
		*Close DB connection
		*/
	   public void close()
	   {
	      try 
	      {
	         connection.close();
	      } // end try
	      catch ( SQLException sqlException )
	      {
	         sqlException.printStackTrace();
	      } // end catch
	   } // end method close
	   
	 
}
