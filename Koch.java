/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/*curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		double x3 = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
		double y3 = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);
		double x12 = x1 + ((x2 - x1) / 3);
    	double x21 = x2 - ((x2 - x1) / 3);
    	double y12 = y1 + ((y2 - y1) / 3);
    	double y21 = y2 - ((y2 - y1) / 3);
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.line(x12, y12, x21, y21);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(x1, y1, x3, y3);
			StdDraw.line(x3, y3, x2, y2);
		}
		else {
			curve(n - 1, x1, y1, x12, y12);
			curve(n - 1, x12, y12, x3, y3);
			curve(n - 1, x3, y3, x21, y21);
			curve(n - 1, x21, y21, x2, y2);
		}
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setXscale(-0.5, 1.5);
		StdDraw.setYscale(-0.5, 1.5);
		double[] xVertex = { 0.000, 1.000, 0.500 };
		double[] yVertex = { 1.000, 1.000, 1-0.866 };
		curve(n, xVertex[0], yVertex[0], xVertex[1], yVertex[1]);
		curve(n, xVertex[1], yVertex[1], xVertex[2], yVertex[2]);
		curve(n, xVertex[2], yVertex[2], xVertex[0], yVertex[0]);
	}
}
