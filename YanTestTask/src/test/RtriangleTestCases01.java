package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import tut.*;

/**
 * Test cases for rectangular triangle. 
 * First version.
 * Test case based on Pythagoras theorem.
 * 
 * @author Gennady Sikorskiy
 *
 */
public class RtriangleTestCases01 {

	private double[] side = new double[3];
	
	/**
	 * Method prepares data for test case.
	 * It calculates sides lengths of triangle.
	 */
	@Before
	public void setUp() {
		Rtriangle tr = RtriangleProvider.getRtriangle();
		side[0] = calcDistance(tr.getApexX1(), tr.getApexY1(), tr.getApexX2(), tr.getApexY2());
		side[1] = calcDistance(tr.getApexX1(), tr.getApexY1(), tr.getApexX3(), tr.getApexY3());
		side[2] = calcDistance(tr.getApexX2(), tr.getApexY2(), tr.getApexX3(), tr.getApexY3());
		Arrays.sort(side);
	}
	
	/**
	 * First step checks that we have triangle.
	 * Second step checks that triangle satisfies Pythagoras theorem. 
	 */
	@Test
	public void pifagorTest() {
		System.out.print("Pythagoras test... ");
		assertTrue("Sides a+b not bigger then c. This is not triangle.", side[0]+side[1] > side[2]);
		assertTrue("Pythagoras theorem is not satisfied. Triangle is not rectancular.", 
			(Math.pow(side[0], 2)+Math.pow(side[1], 2)==Math.pow(side[2], 2)));
		System.out.println("Passed.");
	}
	
	/**
	 * Calculates distance between two points.
	 * @param x1 - first point coordinate axis X
	 * @param y1 - first point coordinate axis Y
	 * @param x2 - second point coordinate axis X
	 * @param y2 - second point coordinate axis Y
	 * @return distance between points
	 */
	private double calcDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
}
