//NeiL O'Sullivan R00206266 SDH2B
package view;

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import control.*;

/**
*Class for a a list of modules
*/
public class ModuleList {
	
	 private ArrayList <Module> modules; //array list of modules

	 /**
		*Constructor for the modulelist
		*/
	 public ModuleList (){ 
		
		 modules = new ArrayList <Module> ();
	 }
	 
	 /**
		*Returns the array list modules
		* @return   the list of modules
		*/
	 public ArrayList<Module> getModuleList (){
	     return modules;
	 }
	 
	 /**
		*Adds module to list
		* @param m module
		*/ 
	public void addModule(Module m)
	{
		modules.add(m);
	}
	
	/**
	*Returns the record 
	*@param i array index of record
	* @return   record
	*/
	public Module getRecord(int i)
	{
		if ((i>-1) && (i < modules.size()))
			
     		return modules.get (i);
		return null;
	}
	
	/**
	*Returns the size of modules list
	* @return   size of list of modules
	*/
	public int getSize (){
		return modules.size();
	}
	


	
}
