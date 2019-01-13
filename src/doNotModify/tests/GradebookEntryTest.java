//DO NOT MODIFY THIS FILE

package doNotModify.tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import toBeCompleted.stage2.GradebookEntry;

public class GradebookEntryTest {		
	@Test
	public void testNumberOfAssessments() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		assertEquals(4, entry.numberOfAssessments());

		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 8.5)));
		assertEquals(2, entry.numberOfAssessments());
	}

	@Test
	public void testGetTotal() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.0, 4.5, 2.5, 8.5)));
		assertEquals(16.5, entry.getTotal(), 0.001);

		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.0, 8.5)));
		assertEquals(9.5, entry.getTotal(), 0.001);

		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>()); //no marks
		assertEquals(0.0, entry.getTotal(), 0.001);
	}

	@Test
	public void testGetAverage() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.0, 4.5, 2.5, 8.5)));
		assertEquals(16.5/4, entry.getAverage(), 0.001);

		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.0, 8.5)));
		assertEquals(9.5/2, entry.getAverage(), 0.001);

		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>()); //no marks
		assertEquals(null, entry.getAverage());
	}

	@Test
	public void testGetMark() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		assertEquals(1.5, entry.getMark(0), 0.0001);
		assertEquals(4.5, entry.getMark(1), 0.0001);
		assertEquals(2.5, entry.getMark(2), 0.0001);
		assertEquals(8.5, entry.getMark(3), 0.0001);
	}

	@Test
	public void testGradebookEntry() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		assertEquals("Joshua Lyman", entry.getName());
		assertEquals(5, entry.getId());
		assertEquals(4, entry.numberOfAssessments());
		assertEquals(1.5, entry.getMark(0), 0.0001);
		assertEquals(4.5, entry.getMark(1), 0.0001);
		assertEquals(2.5, entry.getMark(2), 0.0001);
		assertEquals(8.5, entry.getMark(3), 0.0001);
	}

	@Test
	public void testIsValidAssessmentNumber() {
		GradebookEntry entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		assertTrue(entry.isValidAssessmentNumber(0));
		assertTrue(entry.isValidAssessmentNumber(1));
		assertTrue(entry.isValidAssessmentNumber(2));
		assertTrue(entry.isValidAssessmentNumber(3));

		assertFalse(entry.isValidAssessmentNumber(-1));
		assertFalse(entry.isValidAssessmentNumber(4));
		
		entry = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(2.5, 8.5)));
		assertTrue(entry.isValidAssessmentNumber(0));
		assertTrue(entry.isValidAssessmentNumber(1));

		assertFalse(entry.isValidAssessmentNumber(-1));
		assertFalse(entry.isValidAssessmentNumber(2));

	}

	@Test
	public void testCompareToGradebookEntry() {
		GradebookEntry entry1 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		GradebookEntry entry2 = new GradebookEntry("Tobias Zachary Ziegler", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5)));
		GradebookEntry entry3 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 1.0, 3.5, 2.5, 8.5))); //same total as entry1
		assertEquals(1, entry1.compareTo(entry2));
		assertEquals(-1, entry2.compareTo(entry1));
		assertEquals(0, entry1.compareTo(entry3));		
	}

	@Test
	public void testCompareToGradebookEntryInt() {
		GradebookEntry entry1 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		GradebookEntry entry2 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(5.5, 3.5, 2.5)));
		assertEquals(null, entry1.compareTo(entry2, 3)); //no index 3 in entry2
		assertEquals((Integer)(-1), entry1.compareTo(entry2, 0));
		assertEquals((Integer)(1), entry1.compareTo(entry2, 1));
		assertEquals((Integer)(0), entry1.compareTo(entry2, 2));
		assertEquals(null, entry1.compareTo(entry2, 3)); //no index 3 in entry2
		
	}

	@Test
	public void testSwap() {
		GradebookEntry entry1 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		assertEquals(1.5, entry1.getMark(0), 0.001);
		assertEquals(2.5, entry1.getMark(2), 0.001);
		entry1.swap(0, 2);
		assertEquals(2.5, entry1.getMark(0), 0.001);
		assertEquals(1.5, entry1.getMark(2), 0.001);
		
		entry1.swap(1, 5);
		assertEquals(4.5, entry1.getMark(1), 0.001); //no effect on item at index 1
	}

	@Test
	public void testSetMarks() {
		GradebookEntry entry1 = new GradebookEntry("Joshua Lyman", 5, new ArrayList<Double>(Arrays.asList(1.5, 4.5, 2.5, 8.5)));
		entry1.setMarks(0, 0, 50);
		assertEquals(0, entry1.getMark(0), 0.001);
		entry1.setMarks(0, 50, 50);
		assertEquals(50, entry1.getMark(0), 0.001);
		entry1.setMarks(0, 41.9, 50);
		assertEquals(41.9, entry1.getMark(0), 0.001);
		entry1.setMarks(0, 50.1, 50); //invalid
		assertEquals(41.9, entry1.getMark(0), 0.001); //unchanged
		entry1.setMarks(0, -0.1, 50); //invalid
		assertEquals(41.9, entry1.getMark(0), 0.001); //unchanged
	}

}
