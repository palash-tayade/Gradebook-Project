/**
 * Name: Palash Vijay Tayade
 * Student Id: 44498632
 */
package toBeCompleted.stage1;

public class Assessment {
	private String title;
	private double worth;

	/**
	 * DO NOT MODIFY
	 * @return worth
	 */
	public double getWorth() {
		return worth;
	}

	/**
	 * DO NOT MODIFY
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * IMPORTANT setWorth is set to be a private method as
	 * we don't want its value to change after instantiation.
	 * set the instance variable worth to the parameter provided.
	 * if w is less than 0, worth should become 0.
	 * if w is more than 100, worth should become 100.
	 * if w is in the range [0, 100], worth should become w.
	 * @param w
	 */
	private void setWorth(double w) {
		if(w<0)
			this.worth=0;		//setting worth to zero if w is less than zero
		else if(w>100)
			this.worth=100;		//setting worth to 100 if w is greater than zero
		else
			this.worth=w;
	}

	/**
	 * set title to upper case version of t,
	 * set worth to w using the setter
	 * @param t
	 * @param w
	 */
	public Assessment(String t, double w) {
		setWorth(w);
		this.title=t.toUpperCase();				//setting title in upper-case format
	}

	/**
	 * return String representation of the object.
	 * format example: if title is "A1" and worth is 25, 
	 * method should return "A1 (25.0)"
	 */
	public String toString() {
		return this.getTitle()+" "+"("+this.getWorth()+")"; 	//displaying title and worth for assessment
	}

	/**
	 * 
	 * @param other
	 * @return 1 if calling object is worth more than parameter object
	 * @return -1 if calling object is worth less than parameter object
	 * @return 0 if calling object is worth the same as parameter object
	 */
	public int compareTo(Assessment other) {
		if(this.getWorth()>other.getWorth())		//checking if value of current object's worth is greater than the comparing object
			return 1;								
		else if(this.getWorth()<other.getWorth())	//checking if value of current object's worth is less than the comparing object
			return -1;								
		return 0; 									//return zero if value of current object's worth is same as that of the comparing object
	}

	/**
	 * 
	 * @param marks
	 * @return true if the parameter is a valid mark for the assessment, false otherwise
	 */
	public boolean isValidMark(double marks) {
		if(this.getWorth()<marks||marks<0)			//checking if the given marks are valid
			return false; 
		return true;
	}
}
