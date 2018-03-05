package ghc.bl;

public class Ride {
	
	private static int idCounter = 0;
	
	private int id;
	private int startTime;
	private int endTime;
	private Position startPosition;
	private Position endPosition;
	private Vehicle vehicle;
	private int startedAt;
	private int finishedAt;
	
	public Ride(Position startPosition, Position endPosition, int startTime, int endTime ) {	
		this.id = idCounter++;
		this.startPosition = startPosition;
		this.endPosition   = endPosition;
		this.startTime = startTime;
		this.endTime   = endTime;
	}
	
	private int calculateRideDuration() 
	{
		return (Math.abs(startPosition.getRow() - endPosition.getRow()) + Math.abs(startPosition.getCol() - endPosition.getCol()));
	}
	
	public int calculateTotalDuration(Vehicle vehicle) {
		Position vehiclePosition;
		int distanceToStart;
		
		vehiclePosition = vehicle.getCurrentPos();
		distanceToStart = Math.abs(vehiclePosition.getRow() - startPosition.getRow()) + Math.abs(vehiclePosition.getCol() - startPosition.getCol());
		
		return distanceToStart + calculateRideDuration();
	}
	

	public void assignVehicle(Vehicle vehicle, int startedAt) {
		this.startedAt = startedAt;
		this.vehicle = vehicle;
		this.finishedAt = startedAt + calculateTotalDuration(vehicle);
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getStartedAt() {
		return startedAt;
	}

	public int getFinishedAt() {
		return finishedAt;
	}

	@Override
	public String toString() {
		return "Ride [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", startPosition="
				+ startPosition + ", endPosition=" + endPosition + "]";
	};
	
		
	
}
