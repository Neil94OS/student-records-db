package model;


/**
*Class for a date of birth 
*/
public class DateOfBirth {

	private String dob;// date of birth

	/**
	*Constructor for the date of birth 
	* @param d is the date of birth as a string
	*/
   public DateOfBirth (String d){
		
		dob = d;
	}

    /**
    *Default constructor for the date of birth 
    */
	public DateOfBirth(){} 

	/**
	*Returns the Date of birth 
	* @return  the dob of the student 
	*/
	public String getDob() {
		return dob;
	}
	
	/**
	*Sets the Date of birth 
	* @param  d the date of birth 
	*/
	public void setDob(String d ){
		dob= d;
	}
	
	/**
	*Returns the Date of birth as a string
	* @return    the dob of the student 
	*/
	public String toString()
	 {
      String s = dob +" "  ;
	   return s;
	 }
}
