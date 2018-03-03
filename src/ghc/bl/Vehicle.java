package ghc.bl;

public class Vehicle {
	
	private static int idCounter = 0;
	
	private int id;
	private Position currentPos;
	private boolean available;
	
	public Vehicle() {
		this.id = ++idCounter;
		this.currentPos = new Position(0, 0);
		this.available = true;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", currentPos=" + currentPos + "]";
	}
	
	
	
}
