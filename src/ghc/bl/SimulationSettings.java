package ghc.bl;

public class SimulationSettings {
	
	private Map map;
	private int maxVehicles;
	private int maxRides;
	private int onTimeBonus;
	private int maxSteps;
	
	public SimulationSettings(Map map, int maxVehicles, int maxRides, int onTimeBonus, int maxSteps) {
		super();
		this.map = map;
		this.maxVehicles = maxVehicles;
		this.maxRides = maxRides;
		this.onTimeBonus = onTimeBonus;
		this.maxSteps = maxSteps;
	}

	public Map getMap() {
		return map;
	}

	public int getMaxVehicles() {
		return maxVehicles;
	}

	public int getMaxRides() {
		return maxRides;
	}

	public int getOnTimeBonus() {
		return onTimeBonus;
	}

	public int getMaxSteps() {
		return maxSteps;
	}

	@Override
	public String toString() {
		return "SimulationSettings [map=" + map.toString() + ", maxVehicles=" + maxVehicles + ", maxRides=" + maxRides
				+ ", onTimeBonus=" + onTimeBonus + ", maxSteps=" + maxSteps + "]";
	}
	
}
