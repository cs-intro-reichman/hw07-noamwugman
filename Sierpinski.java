/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-0.05, 1.05);
		StdDraw.setYscale(-0.05, 1.05);
		double[] xVertex = { 0.000, 1.000, 0.500 };
		double[] yVertex = { 0.000, 0.000, 0.866 };
		sierpinski(n, xVertex[0], xVertex[1], xVertex[2], yVertex[0], yVertex[1], yVertex[2]);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x3, y3, x1, y1);
		}
		else {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x3, y3, x1, y1);
			double[] mid12 = {(x1 + x2) / 2, (y1 + y2) / 2};
			double[] mid23 = {(x2 + x3) / 2, (y2 + y3) / 2};
			double[] mid31 = {(x3 + x1) / 2, (y3 + y1) / 2};
			sierpinski(n-1, x1, mid12[0], mid31[0], y1, mid12[1], mid31[1]);
			sierpinski(n-1, x2, mid12[0], mid23[0], y2, mid12[1], mid23[1]);
			sierpinski(n-1, x3, mid23[0], mid31[0], y3, mid23[1], mid31[1]);
		}
	}
}
