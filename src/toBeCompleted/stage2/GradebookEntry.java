/**
 * Name: Palash Vijay Tayade
 * Student Id: 44498632
 */
package toBeCompleted.stage2;

import java.util.*;

public class GradebookEntry {
	private String name;
	private int id;
	private ArrayList<Double> marks;

	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = name+" (ID "+id+")\t";
		for(int i=0; i < marks.size(); i++) {
			/**
			 * display every mark rounded off to two digits.
			 * adding the 0.00001 to compensate for any rounding-off errors.
			 */
			double displayMark = (int)((marks.get(i)+0.00001)*100)/100.0;
			result+=displayMark+"\t";
		}
		double displayTotal = (int)(getTotal()*100)/100.0;
		return result.substring(0, result.length()-1)+"\t(Total "+displayTotal+")\n";
	}

	/**
	 * DO NOT MODIFY
	 * @return name of the student
	 */
	public String getName() {
		return name;
	}

	/**
	 * DO NOT MODIFY
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * DO NOT MODIFY
	 * @return number of assessments
	 */
	public int numberOfAssessments() {
		return marks.size();
	}

	/**
	 * set the instance variable id to the parameter provided.
	 * if i is less than 1, id should become 1.
	 * otherwise, id should become i.
	 * @param i
	 */
	private void setId(int i) {
		if(i<1)
			this.id=i;				//setting id to 1 if i is less than one
		this.id=i;
	}

	/**
	 * set instance variables name, id and marks to corresponding parameter provided.
	 * use the setter to set the id.
	 * you should make a deep copy for marks, NOT A SHALLOW COPY
	 * @param name
	 * @param id
	 * @param marks
	 */
	public GradebookEntry(String name, int id, ArrayList<Double> marks) {
		this.setId(id);
		this.name=name;
		this.marks =new ArrayList<Double>();		//instantiating the arraylist  'marks'
		for (Double element : marks)				//creating a deep copy of of the formal parameter 'marks'
			this.marks.add(element);
	}

	/**
	 * 
	 * @return total marks (0 if 0 assessments)
	 */
	public double getTotal() {
		double total=0;
		for (Double element : marks) {			//computing the sum of all the elements in arraylist 'marks'
			total+=element;
		}
		return total; 
	}

	/**
	 * 
	 * @return average marks (null if 0 assessments)
	 */
	public Double getAverage() {
		if(this.marks.size()<1)				//check if the arraylist is empty
			return null; 
		else
			return this.getTotal()/this.marks.size();	//computing and returning the average of the elements in the arraylist 'marks'
	}

	/**
	 * 
	 * @param assessmentNumber
	 * @return true if assessmentNumber is valid, false otherwise.
	 * For example if there were 5 assessments, the valid assessment numbers are from 0 to 4 (including 0 and 4).
	 */
	public boolean isValidAssessmentNumber(int assessmentNumber) {
		if(assessmentNumber>=0&&assessmentNumber<this.marks.size())		//checking if the assessmentNumber is valid
			return true;
		return false; 
	}

	/**
	 * 
	 * @param assessmentNumber
	 * @return mark in assessment with given index
	 * return null if no such assessment exists
	 */
	public Double getMark(int assessmentNumber) {
		if(this.marks.size()<=assessmentNumber)					//checking for invalid assessmentNumber 
			return null;
		return this.marks.get(assessmentNumber); 				//returning marks for the specified assessmentNumber
	}

	/**
	 * 
	 * @param other
	 * @return 1 if calling object's total is more than parameter's total
	 * @return -1 if calling object's total is less than parameter's total
	 * @return 0 if calling object's total is equal to parameter's total
	 */
	public int compareTo(GradebookEntry other) {
		if(this.getTotal()>other.getTotal())		//checking if value of current object's total is greater than the comparing object
			return 1;
		else if(this.getTotal()<other.getTotal())	//checking if value of current object's total is less than the comparing object
			return -1;
		return 0; 									//return zero if value of current object's total is as that of the comparing object
	}

	/**
	 * 
	 * @param other
	 * @param assessmentBasis: index of assessment on the basis of which comparison is being made 
	 * @return null if assessmentBasis is an invalid index (for calling object or parameter object)
	 * @return 1 if calling object's mark in the concerned assessment is more than parameter's mark in the concerned assessment
	 * @return -1 if calling object's mark in the concerned assessment is less than parameter's mark in the concerned assessment
	 * @return 0 if calling object's mark in the concerned assessment is equal to parameter's mark in the concerned assessment
	 */
	public Integer compareTo(GradebookEntry other, int assessmentBasis) {
		if(this.marks.size()<=assessmentBasis||other.marks.size()<=assessmentBasis)	//checking if the given assessment number is valid
			return null;
		else if(this.marks.get(assessmentBasis)>other.getMark(assessmentBasis))		//checking if value of current object's marks in the required assessment is greater than the comparing object
			return 1;
		else if(this.marks.get(assessmentBasis)<other.getMark(assessmentBasis))		//checking if value of current object's marks in the required assessment is less than the comparing object
			return -1;
		else
			return 0;																//return 0 if value of current object's marks in the required assessment is same as that of the comparing object
	}

	/**
	 * swap marks of the assessments at the two given indices.
	 * return without doing anything if either index is invalid
	 * @param idx1
	 * @param idx2
	 */
	public void swap(int idx1, int idx2) {
		if(isValidAssessmentNumber(idx1)&&isValidAssessmentNumber(idx2)) {			//checking if the given indices number are valid
			double temp=0;
			temp=this.marks.get(idx1);												//swapping the required indices
			this.marks.set(idx1, this.marks.get(idx2));
			this.marks.set(idx2, temp);
		}
	}

	/**
	 * if the assessment number is a valid index, and the mark is in the range [0, maxMark],
	 * set the mark of the given assessment number to the mark supplied
	 * @param assessmentNumber
	 * @param mark
	 * @param maxMark
	 */
	public void setMarks(int assessmentNumber, double mark, double maxMark) { 
		if(mark>=0&&mark<=maxMark)						//checking if the given mark is valid
			this.marks.set(assessmentNumber, mark);		//setting the given mark to the required assessment
	}
}
