
package test;

public final class Point {

	public final float x;
	public final float y;


	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}


	public Point subtract(Point p) {
		return new Point(x - p.x, y - p.y);
	}


	public double distance(Point p) {
		return Math.hypot(x - p.x, y - p.y);
	}


	// Signed area / determinant thing
	public double cross(Point p) {
		return x * p.y - y * p.x;
	}


	public String toString() {
		return String.format("Point(%g, %g)", x, y);
	}

}