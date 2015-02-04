package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tut.*;

/**
 * Test cases for rectangular triangle. 
 * Second version.
 * This version checks triangle by using properties of 
 * scalar multiplication of vectors:
 * AB*BC = |AB|*|BC|*cos(ABC);
 * 
 * @author Gennady Sikorskiy
 *
 */
public class RtriangleTestCase02 {

	private Vector[] side = new Vector[3]; // Vector is internal class, described bottom.
	
	/**
	 * Prepares data for the test.
	 * We consider each side of triangle as mathematical vector.
	 */
	@Before
	public void setUp() {
		Rtriangle tr = RtriangleProvider.getRtriangle();
		side[0] = new Vector(tr.getApexX1(), tr.getApexY1(), tr.getApexX2(), tr.getApexY2());
		side[1] = new Vector(tr.getApexX1(), tr.getApexY1(), tr.getApexX3(), tr.getApexY3());
		side[2] = new Vector(tr.getApexX2(), tr.getApexY2(), tr.getApexX3(), tr.getApexY3());
	}
	
	/**
	 * Test case based on property of scalar multiplication of vectors:
	 * If scalar multiplication of two vectors is 0, but modules is not 0, 
	 * then cos of angle between vectors is 0, and angle between vectors is 90 degrees
	 */
	@Test
	public void cosinusTest() {		
		System.out.print("Cosinus test... ");
		assertTrue("Some side looks like point. This is not triangle.", 
				(side[0].module() > 0) && 
				(side[1].module() > 0) && 
				(side[2].module() > 0));
		assertTrue("Triangle is not rectancular.", 
				(side[0].scalarMultiplWith(side[1]) == 0)||
				(side[0].scalarMultiplWith(side[2]) == 0)||
				(side[1].scalarMultiplWith(side[2]) == 0));
		System.out.print("Passed.");
	}
	
	/**
	 * It can be part of test framework, if we often works with mathematical vectors.
	 * But for this task it is inner class
	 * 
	 * @author Gennady Sikorskiy
	 *
	 */
	private class Vector {
		
		private int x;
		private int y;
		
		/**
		 * Calculates coordinates of vector between two points
		 * @param x1 - first point coordinate axis X
		 * @param y1 - first point coordinate axis Y
		 * @param x2 - second point coordinate axis X
		 * @param y2 - second point coordinate axis Y
		 */
		public Vector(int x1, int y1, int x2, int y2){
			this.x = x2 - x1;
			this.y = y2 - y1;
		}
		
		/**
		 * Getter for first coordinate of vector
		 * @return start of vector
		 */
		public int getX() {
			return x;
		}
		
		/**
		 * Getter for second coordinate of vector
		 * @return end of vector
		 */
		public int getY() {
			return y;
		}
		
		/**
		 * Calculates module of vector
		 * @return module of vector
		 */
		public double module() {
			return Math.sqrt(x * x + y * y);
		}
		
		/**
		 * Calculates scalar multiplication with another vector
		 * @return scalar multiplication of two vectors
		 */
		public double scalarMultiplWith(Vector vect) {
			return x * vect.getX() + y * vect.getY();
		}		
	}
}
