
public class Target {
	private int x;
	private int y;
	private int rayon;

	public Target(int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
	}

	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRayon() {
		return rayon;
	}

	public String toString() {
		return "Target (" + x + " ; " + y + ") | r = " + rayon;
	}
}
