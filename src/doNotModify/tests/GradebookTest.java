//DO NOT MODIFY THIS FILE

package doNotModify.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import doNotModify.reader.DataReader;
import toBeCompleted.stage2.GradebookEntry;
import toBeCompleted.stage3.Gradebook;

public class GradebookTest {
	private Gradebook book;

	@Before
	public void setup() throws FileNotFoundException {
		book = DataReader.getGradeBook("data.csv");
	}

	@Test
	public void testGradebook() {
		assertEquals(7, book.numberOfRecords());
		assertEquals(6, book.numberOfAssessments());
	}

	@Test
	public void testNumberOfRecords() {
		assertEquals(7, book.numberOfRecords());
	}

	@Test
	public void testNumberOfAssessments() {
		assertEquals(6, book.numberOfAssessments());
	}

	@Test
	public void testIsValidRecordNumber() {
		assertTrue(book.isValidRecordNumber(0));
		assertTrue(book.isValidRecordNumber(6));
		assertFalse(book.isValidRecordNumber(-1));
		assertFalse(book.isValidRecordNumber(7));
	}

	@Test
	public void testIsValidAssessmentNumber() {
		assertTrue(book.isValidAssessmentNumber(0));
		assertTrue(book.isValidAssessmentNumber(5));
		assertFalse(book.isValidAssessmentNumber(-1));
		assertFalse(book.isValidAssessmentNumber(6));	
	}

	@Test
	public void testGetWorth() {
		assertEquals(15, book.getWorth("PE2"), 0.001);
		assertEquals(25.1, book.getWorth("PE3"), 0.001);
		assertEquals(null, book.getWorth("PE5"));
	}

	@Test
	public void testSortRecords() {
		book.sortRecords();
		for(int i=1; i < book.numberOfRecords(); i++) {
			assertTrue(book.getRecord(i).getTotal() <= book.getRecord(i-1).getTotal());
		}
		//sorted based on averages
	}

	@Test
	public void testScale() {
		assertEquals(10.0, book.getRecord(0).getMark(4), 0.001);
		assertEquals(3, book.getRecord(1).getMark(4), 0.001);
		assertEquals(7, book.getRecord(2).getMark(4), 0.001);
		assertEquals(0, book.getRecord(3).getMark(4), 0.001);
		assertEquals(9, book.getRecord(4).getMark(4), 0.001);
		assertEquals(7.5, book.getRecord(5).getMark(4), 0.001);
		assertEquals(0, book.getRecord(6).getMark(4), 0.001);
		book.scale("A2", 1.2);
		assertEquals(10.0, book.getRecord(0).getMark(4), 0.001); //should not change. already max
		assertEquals(3.6, book.getRecord(1).getMark(4), 0.001); //should have become 3.6 from 3
		assertEquals(8.4, book.getRecord(2).getMark(4), 0.001);
		assertEquals(0, book.getRecord(3).getMark(4), 0.001);
		assertEquals(10, book.getRecord(4).getMark(4), 0.001);
		assertEquals(9, book.getRecord(5).getMark(4), 0.001);
		assertEquals(0, book.getRecord(6).getMark(4), 0.001);
	}

	@Test
	public void testSortAssessments() {
		book.sortAssessments();
		for(int i=1; i < book.numberOfAssessments(); i++) {
			assertTrue(book.getAssessment(i).getWorth() >= book.getAssessment(i-1).getWorth());
		}
	}
	
	@Test
	public void testGetRecord() {
		GradebookEntry record = book.getRecord("Joey Tribiani");
		assertNull(record);
		
		record = book.getRecord("Angelo Provolone");
		assertEquals(9, record.getId());
	}

	@Test
	public void testSetMarks() {
		assertEquals(0, book.getMark("Angelo Provolone", "PE4"), 0.001);
		book.setMarks("Angelo Provolone", "PE4", 13.14);
		assertEquals(13.14, book.getMark("Angelo Provolone", "PE4"), 0.001);
	}

}
