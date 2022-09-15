package model;

/**
*Class for a name with first name, middle initial and surnam
*/
public class Name {
	private String fName; //first name
	private String lName; // last name
	private String mInit; // middle name initial
	
	/**
	*Constructor
	* @param f firstname
	* @param m middle initial
	* @param l surname
	*/
	public Name (String f, String m, String l){
		
		fName = f;
		mInit = m;
	    lName = l;
	}

	/**
	*Default constructor for name
	*/
	public Name(){} 

	/**
	*Returns the first name of name
	* @return  the first name of name
	*/
	public String getfName() { 
		return fName;
	}
	
	/**
	*Sets the last name of name
	* @param l the last name of name
	*/
	public void setlName(String l ){
		lName= l;
	}
	
	/**
	*Returns the last name of name
	* @return  the last name of name
	*/
	public String getlName() {
		return lName;
	}
	
	/**
	*Sets the first name of name
	* @param n the first name of name
	*/
	public void setfName(String n ){
		fName = n;
	}
	
	/**
	*Returns the middle initial of name
	* @return  the middle initial of name
	*/
	public String getmInit() {
		return mInit;
	}
	
	/**
	*Sets the middle initial of name
	* @param m  the middle initial of name
	*/
	public void setInit(String m ){
		mInit=m;
	}
	
	/**
	*Returns the first name middle initial and surname as a string
	* @return  the first name middle initial and surname as a string
	*/
	 public String toString()
	 {
       String s = fName + "  " +mInit+".  "+lName+"  ";
	   return s;
	 }


}
