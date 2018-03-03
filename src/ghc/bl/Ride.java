package ghc.bl;

public class Ride {
	
	private static int idCounter = 0;
	
	private int id;
	private int startTime;
	private int endTime;
	private Position startPosition;
	private Position endPosition;
	
	public Ride(int startTime, int endTime, Position startPosition, Position endPosition) {
		
		this.id = ++idCounter;
		this.startTime = startTime;
		this.endTime   = endTime;
		this.startPosition = startPosition;
		this.endPosition   = endPosition;

	}

	public int getId() {
		return id;
	}
	
	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	public Position getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}

	@Override
	public String toString() {
		return "Ride [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", startPosition="
				+ startPosition + ", endPosition=" + endPosition + "]";
	};
	
		
	
}
