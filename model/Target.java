package model;

public class Target {
	private int x;
	private int y;
	private int radius;

	public Target(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// Getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getRadius() {
		return this.radius;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Target (" + x + " ; " + y + ") | r = " + this.radius;
	}
}
