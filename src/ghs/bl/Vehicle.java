package ghs.bl;

public class Vehicle {
	
	private static int idCounter = 0;
	
	private int id;
	private Position currentPos;
	
	public Vehicle() {
		this.id = ++idCounter;
		this.currentPos = new Position(0, 0);
	}

	public Position getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

	public int getId() {
		return id;
	}
	
	
}
