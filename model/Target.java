package model;

public class Target {
	private int x;
	private int y;
	private int diamaeter;

	public Target(int x, int y, int diamaeter) {
		this.x = x;
		this.y = y;
		this.diamaeter = diamaeter;
	}

	// Getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getDiameter() {
		return this.diamaeter;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDiameter(int diamaeter) {
		this.diamaeter = diamaeter;
	}
	
	public String toString() {
		return "Target (" + x + " ; " + y + ") | r = " + this.diamaeter;
	}
}
