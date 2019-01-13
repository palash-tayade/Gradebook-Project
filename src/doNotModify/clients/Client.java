//DO NOT MODIFY THIS FILE
package doNotModify.clients;

import java.io.FileNotFoundException;

import doNotModify.reader.DataReader;
import toBeCompleted.stage3.Gradebook;

public class Client {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Gradebook gradebook = DataReader.getGradeBook("data.csv");
		System.out.println("Original\n"+gradebook);
		gradebook.sortRecords();
		System.out.println("---");
		System.out.println("Sorted on basis of totals\n"+gradebook);
		gradebook.sortAssessments();
		System.out.println("---");
		System.out.println("Sorted on basis of assessment weights\n"+gradebook);
		gradebook.scale("A1", 0.95);
		System.out.println("---");
		System.out.println("A1 marks scaled down by 5%\n"+gradebook);
		gradebook.scale("A1", 1.5);
		System.out.println("---");
		System.out.println("A1 marks scaled up by 50%\n"+gradebook);
		gradebook.setMarks("Nina Ivanova", "PE2", 14.9);
		System.out.println("---");
		System.out.println("Changed Nina's PE2 (worth "+gradebook.getWorth("PE2")+") marks to 14.9\n"+gradebook);
		gradebook.setMarks("Nina Ivanova", "PE2", 15.1);
		System.out.println("---");
		System.out.println("After trying to change Nina's PE2 (worth "+gradebook.getWorth("PE2")+") marks to 15.1\n"+gradebook);
	}

}
