/**
 * Name: Palash Vijay Tayade
 * Student Id: 44498632
 */
package toBeCompleted.stage3;

import java.util.*;

import toBeCompleted.stage1.Assessment;
import toBeCompleted.stage2.GradebookEntry;

public class Gradebook {
	private ArrayList<Assessment> assessments;
	private ArrayList<GradebookEntry> records;

	/**
	 * DO NOT MODIFY
	 * @return number of records
	 */
	public int numberOfRecords() {
		return records.size();
	}

	/**
	 * DO NOT MODIFY
	 * @return number of assessments
	 */
	public int numberOfAssessments() {
		return assessments.size();
	}


	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String header1 = "Asssessment title: \t";
		String header2 = "Asssessment worth: \t";
		double totalWorth = 0;
		for(Assessment a: assessments) {
			header1 = header1 + a.getTitle() + "\t"; 
			header2 = header2 + "(" + a.getWorth() + ")\t"; 
			totalWorth += a.getWorth();
		}
		header2 = header2 + "(Total "+totalWorth+")";
		String data = records.toString();
		data = data.replace("[", "");
		data = data.replace("]", "");
		data = data.replaceAll(", ", "");
		return header1+"\n"+header2+"\n"+data;
	}

	/**
	 * make a deep copy of the parameters into the instance variables
	 * @param c
	 * @param r
	 */
	public Gradebook(ArrayList<Assessment> c, ArrayList<GradebookEntry> r) {
		this.assessments=new ArrayList<Assessment>();			//instantiating the arraylist  'assessments'
		for (Assessment assesment : c) {						//creating a deep copy of of the formal parameter 'c'
			this.assessments.add(assesment);
		}
		this.records=new ArrayList<GradebookEntry>();			//instantiating the arraylist  'records'
		for (GradebookEntry gradebookEntry : r) {				//creating a deep copy of of the formal parameter 'r'
			this.records.add(gradebookEntry);
		}
	}

	/**
	 * 
	 * @param recordNumber
	 * @return true if the given record number is valid.
	 * For example, if there are 9 records, valid record numbers
	 * are from 0 to 8 (including 0 and 8)  
	 */
	public boolean isValidRecordNumber(int recordNumber) {
		if(this.records.size()>recordNumber&&recordNumber>=0)	//checking if the given recordNumber is valid
			return true;
		return false; 
	}

	/**
	 * 
	 * @param assessmentNumber
	 * @return true if assessmentNumber is valid, false otherwise
	 */
	public boolean isValidAssessmentNumber(int assessmentNumber) {
		if(this.assessments.size()>assessmentNumber&&assessmentNumber>=0)		//checking if the given assessmentNumber is valid
			return true;
		return false;
	}

	/**
	 * 
	 * @param assessmentTitle
	 * @return how much is the assessment worth. return null if assessment not found 
	 */
	public Double getWorth(String assessmentTitle) {
		for (Assessment assessment : assessments) {
			if(assessment.getTitle().equals(assessmentTitle))			//checking if the given assessmentTitle exist
				return assessment.getWorth();						    //if it exists; return its worth
		}
		return null; 
	}

	/**
	 * sort the records in descending order of totals. 
	 * hint: you can use the method compareTo from class GradebookEntry
	 */
	public void sortRecords() {
		for(int index1=0;index1<this.records.size();index1++) {
			for(int index2=index1;index2<this.records.size();index2++) {
				if((this.records.get(index1)).compareTo(this.records.get(index2))==-1){		//using Bubble sort to sort the records in descending order of totals. 
					GradebookEntry temp=this.records.get(index1);
					this.records.set(index1,this.records.get(index2));
					this.records.set(index2, temp);
				}
			}	
		}
	}

	/**
	 * 
	 * @param title
	 * @return index of assessment with given title. return -1 if no such title exists
	 */
	public int getAssessmentIndex(String title) {
		for (Assessment assessment : assessments) {
			if(assessment.getTitle().equals(title))				//checking if the given assessmentTitle exist
				return assessments.indexOf(assessment);			//if it exists; return its index
		}
		return 0;
	}

	/**
	 * scale marks of a particular assessment, whose title is provided
	 * by the given factor (1.2 means increase by 20%, 0.75 means decrease by 25%).
	 * note that marks should have an upper bound of what that particular assessment is worth,
	 * and a lower bound of 0. Thus, a mark of 4 out of 5, with a factor of 0.5, should become 5 (and not 6).
	 * Similarly, a mark of 2 out of 5, with a factor = -1.5, should become 0 (and not -1).
	 * do nothing if there is no assessment with the given title
	 * @param title
	 * @param factor
	 */
	public void scale(String title, double factor) {
		for (Assessment assessment : assessments) {
			if(assessment.getTitle().equals(title)) {
				int index=assessments.indexOf(assessment);
				for (GradebookEntry record : records) {
					if(record.getMark(index)*factor<assessment.getWorth()) {				//checking if the scaled marks are less than the worth; if so, replace the old marks with scaled marks
						setMarks(record.getName(), title, record.getMark(index)*factor);
					}
					else if(record.getMark(index)*factor>assessment.getWorth()) {			//checking if the scaled marks are greater than the worth; if so, replace the old marks with assessment's worth
						setMarks(record.getName(), title, assessment.getWorth());
					}
					else if(record.getMark(index)*factor<0) {								//checking if the scaled marks are less than the zero; if so, replace the old marks with zero marks
						setMarks(record.getName(), title, 0);
					}
				}

			}
		}
	}

	/**
	 * D/HD
	 * sort the assessments in ascending order of how much they are worth. 
	 * Note that each record should be updated as well. 
	 */
	public void sortAssessments() {
		for(int index1=0;index1<this.assessments.size();index1++) {
			for(int index2=index1;index2<this.assessments.size();index2++) {
				if((this.assessments.get(index1)).compareTo(this.assessments.get(index2))==1){
					Assessment temp1=this.assessments.get(index1);				//sorting the objects in the arraylist 'assessments' using bubble sort
					this.assessments.set(index1,this.assessments.get(index2));
					this.assessments.set(index2, temp1);
					GradebookEntry temp2=this.records.get(index1);				//sorting the objects in the arraylist 'records' using bubble sort
					this.records.set(index1,this.records.get(index2));
					this.records.set(index2, temp2);
				}
			}	
		}
	}

	/**
	 * D/HD
	 * set the marks of student with the given name in the assessment with the 
	 * title of assessmentTitle to given marks
	 * @param name: name of student
	 * @param assessmentTitle: title of assessment
	 * @param marks: marks to be set for the given student and assignment
	 */
	public void setMarks(String name, String assessmentTitle, double marks) {
		for (GradebookEntry record : records) {
			if(record.getName().equals(name)) {									//check if the given student name exists
				for (Assessment assessment : assessments) {
					if(assessment.getTitle().equals(assessmentTitle)) {			//check if the given assessment title exists
						int index=assessments.indexOf(assessment);
						record.setMarks(index, marks, assessment.getWorth());	//setting the required marks for the given student name for the given assessment title
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param idx
	 * @return GradebookEntry at given index if index is valid, return null otherwise
	 */
	public GradebookEntry getRecord(int idx) {
		if(this.records.size()>idx&&idx>=0)			//checking if the given Gradebook entry exist
			return records.get(idx);
		return null; 
	}

	/**
	 * 
	 * @param idx
	 * @return Assessment at given index if index is valid, return null otherwise
	 */
	public Assessment getAssessment(int idx) {
		if(idx>=0&&idx<assessments.size())		//checking if the given assessment index is valid; if yes return the assessment object
			return assessments.get(idx);
		return null; 
	}

	/**
	 * 
	 * @param name
	 * @param title
	 * @return mark of student with given name in an assessment with given title.
	 * return null if no such record exists.
	 */
	public Double getMark(String name, String title) {
		for (GradebookEntry record : records) {
			if(record.getName().equals(name)) {							//check if the given student name exists
				for (Assessment assessment : assessments) {
					if(assessment.getTitle().equals(title)) {			//check if the given assessment title exists
						int index = assessments.indexOf(assessment);
						return record.getMark(index);					//returning marks of student with given name in an assessment with given title
					}
				}
			}
		}
		return null; 
	}

	/**
	 * 
	 * @param name
	 * @return record for student with given name. return null if no such record exists
	 */
	public GradebookEntry getRecord(String name) {
		for(GradebookEntry record : records) {
			if(record.getName().equals(name))				//check if the given student name exists; if yes return its record
				return record;
		}
		return null; 
	}
}
