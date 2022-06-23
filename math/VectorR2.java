package math;

public class VectorR2 {

	private double x, y, magnitude;

	public VectorR2(double x, double y) {
		this.x = x;
		this.y = y;
		calculateMagnitude();
	}

	public VectorR2(double x1, double y1, double x2, double y2) {
		this.x = x2 - x1;
		this.y = y2 - y1;
		calculateMagnitude();
	}

	private void calculateMagnitude() {
		magnitude = Math.sqrt(x * x + y * y);
	}

	public void normalize() {
		multiplyScalar(1 / magnitude);
		magnitude = Math.round(magnitude);
	}

	public void multiplyScalar(double scalar) {
		x *= scalar;
		y *= scalar;
		calculateMagnitude();
	}

	public double getMagnitude() {
		return magnitude;
	}

	public double dotProduct(VectorR2 vector) {
		return x * vector.getX() + y * vector.getY();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void substract(VectorR2 vector) {
		x += -1 * vector.getX();
		y += -1 * vector.getY();
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	

}
