package control;

import java.io.IOException;

import model.*;
import model.Module;
import view.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
*Class for a module controller to control user input regarding modules
*/
public class ModuleController {

	 private static final String URL = "jdbc:derby:C:\\Users\\nosal\\eclipse-workspace\\OOPFinalProjectY2\\testDB;";
	   private static final String USERNAME = "";
	   private static final String PASSWORD = "";
	   String serializedName = "";
	   private StudentList studentList;


	   private Connection connection = null; // manages connection
	 
	   private PreparedStatement addModuleStatement = null; 
	   private PreparedStatement showStudentModulesStatement = null; 
	   private PreparedStatement showStudentModulesFirstClassStatement = null;
	
		
	   /**
		*Constructor for module controller
		*/
		public ModuleController(){
			// constructor
			try 
		      {
		         connection = 
		            DriverManager.getConnection( URL, USERNAME, PASSWORD );

		        
		         addModuleStatement = connection.prepareStatement( 
		            "INSERT INTO MODULESANDGRADES" + 
		            "(ID, NAME, GRADE) " + 
		            "VALUES ( ?, ?,?)" );
		         
		         showStudentModulesStatement = connection.prepareStatement(
			 	            "SELECT NAME, GRADE FROM MODULESANDGRADES WHERE ID =?"
			 	            );
		         
		         showStudentModulesFirstClassStatement = connection.prepareStatement(
			 	            "SELECT NAME, GRADE FROM MODULESANDGRADES WHERE ID =? AND GRADE >69"
			 	            );
		         
		 
		         
		         
		      }
		      catch ( SQLException sqlException )
		      {
		         sqlException.printStackTrace();
		         System.exit( 1 );
		      }
		}
		
		
		/**
		*add module to the database
	    *@param id student id
	    *@param name module name
	    *@param grade module grade
		*@return number of lines added in the database
		*/
		public int addModuleToList(String id, String name,  String grade) throws IOException {
			int result = 0;
			
			    // set parameters to add module statement
			    try 
			    {
			 
			        
			    	addModuleStatement.setString( 1, id );
			    	addModuleStatement.setString( 2, name);
			    	addModuleStatement.setString( 3, grade );
			    	
			 
			       // add new module
			       result = addModuleStatement.executeUpdate();                                                      
			       System.out.println("Module :"+name.toUpperCase()+ " added succesfully for Student ID: "+id);
			    } // end try
			    catch ( SQLException sqlException )
			    {
			       sqlException.printStackTrace();
			       close();
			    } // end catch
			    
			    return result;
			}		
		
		
		/**
		*Get list of a students modules
		*@param id student id
		*@return string of students modules
		*/
		public String getListModule(String id)
		{
			List<Module> ml = getAllModules(id);
			String allModules="\0";
			for (int i = 0;i<ml.size();i++)
			{
				allModules = allModules+ml.get(i);	
			}	
			return allModules;
		}
		
		
		/**
		*Get list of a students modules
		*@param id student id
		*@return List<Module> of a students modules
		*/
		public List<Module> getAllModules(String id)
		   {
		      List< Module > results = null;
		      ResultSet resultSet = null;
		      
		      try 
		      {
		    	  //set parameters for get modules statement
		    	  showStudentModulesStatement.setString( 1, id );
		         // executeQuery returns ResultSet containing matching entries
		         resultSet = showStudentModulesStatement.executeQuery(); 
		         System.out.println("Student :"+id+" records showing ");
		         results = new ArrayList< Module >();
		         
		         while ( resultSet.next() )
		         {
		            results.add( new Module(
		               resultSet.getString( "NAME" ),
		               resultSet.getString( "GRADE" ))
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
		*Get list of a students modules where the received first class honors
		*@param id student id
		*@return list of modules of students modules
		*/
		public List<Module> getAllModulesFirstClass(String id)
		   {
		      List< Module > results = null;
		      ResultSet resultSet = null;
		      
		      try 
		      {
		    	  //Set parameters for get all modules first class statement
		    	  showStudentModulesFirstClassStatement.setString( 1, id );
		         // executeQuery returns ResultSet containing matching entries
		         resultSet = showStudentModulesFirstClassStatement.executeQuery(); 
		         System.out.println("Student :"+id+" records showing ");
		         results = new ArrayList< Module >();
		         
		         while ( resultSet.next() )
		         {
		            results.add( new Module(
		               resultSet.getString( "NAME" ),
		               resultSet.getString( "GRADE" ))
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
