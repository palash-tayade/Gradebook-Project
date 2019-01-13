//DO NOT MODIFY THIS FILE

package doNotModify.reader;

import java.io.*;
import java.util.*;

import toBeCompleted.stage1.Assessment;
import toBeCompleted.stage2.GradebookEntry;
import toBeCompleted.stage3.Gradebook;

public class DataReader {

	public static Gradebook getGradeBook(String filename) throws FileNotFoundException {
		FileReader reader = new FileReader(filename);
		Scanner scanner = new Scanner(reader);
		String line;
		int count = 0;
		String[] tokens = null;
		ArrayList<Assessment> assessments = new ArrayList<Assessment>();
		ArrayList<GradebookEntry> entries = new ArrayList<GradebookEntry>();
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			tokens = line.split(", +");

			if(count == 0) { //header
				for(int i=2; i < tokens.length; i++) {
					String[] a = tokens[i].split(" ");
					String title = a[0];
					a[1] = a[1].replace('(', '\0').replace(')', '\0');
					assessments.add(new Assessment(title, Double.parseDouble(a[1])));
				}			
			}
			else { //data
				String name = tokens[0];
				int id = Integer.parseInt(tokens[1]);
				ArrayList<Double> marks = new ArrayList<Double>();
				for(int i=2; i < tokens.length; i++) {
					marks.add(Double.parseDouble(tokens[i]));
				}
				entries.add(new GradebookEntry(name, id, marks));
			}
			count++;
			//System.out.println(Arrays.toString(tokens));
		}
		scanner.close();
		return new Gradebook(assessments, entries);
	}

}
