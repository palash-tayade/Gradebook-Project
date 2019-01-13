//DO NOT MODIFY THIS FILE

package doNotModify.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import toBeCompleted.stage1.Assessment;

public class AssessmentTest {
	@Test
	public void testAssessment() {
		/*
		 * IMPORTANT: Failure of this test could also 
		 * be due to the failure of setWorth(double), 
		 * which cannot be tested since it's private.
		 * So, if this test fails, look at setWorth as well.
		 */
		Assessment a = new Assessment("finals", 40.5);
		assertEquals("FINALS", a.getTitle());
		assertEquals(40.5, a.getWorth(), 0.0001);
		
		a = new Assessment("finals", -1.5);
		assertEquals(0, a.getWorth(), 0.0001);
		
		a = new Assessment("finals", 100.5);
		assertEquals(100, a.getWorth(), 0.0001);
	}

	@Test
	public void testToString() {
		Assessment a = new Assessment("finals", 40.5);
		assertEquals("FINALS (40.5)", a.toString());
	}

	@Test
	public void testCompareTo() {
		Assessment a = new Assessment("finals", 40.5);
		Assessment b = new Assessment("finals", 40.1);
		Assessment c = new Assessment("finals", 40.9);
		Assessment d = new Assessment("finals", 40.5);
		assertEquals(1, a.compareTo(b));
		assertEquals(-1, a.compareTo(c));
		assertEquals(0, a.compareTo(d));
	}
	
	@Test
	public void testIsValidMark() {
		Assessment a = new Assessment("finals", 40.5);
		assertTrue(a.isValidMark(0));
		assertTrue(a.isValidMark(40.5));
		assertTrue(a.isValidMark(27));
		assertFalse(a.isValidMark(40.55));
		assertFalse(a.isValidMark(-0.5));
		
		a = new Assessment("finals", 10);
		assertTrue(a.isValidMark(0));
		assertTrue(a.isValidMark(10));
		assertTrue(a.isValidMark(7));
		assertFalse(a.isValidMark(10.55));
		assertFalse(a.isValidMark(-0.5));		
	}

}
