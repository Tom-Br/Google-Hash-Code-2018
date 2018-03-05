package ghc.main;

import java.util.ArrayList;
import ghc.bl.Map;
import ghc.bl.Position;
import ghc.bl.Ride;
import ghc.bl.SimulationSettings;
import ghc.bl.Vehicle;
import ghc.io.InputReader;
import ghc.io.OutputWriter;

public class Simulation {
	
	private String fileName;
	private SimulationSettings settings;
	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>();
	private ArrayList<Vehicle> occupiedVehicles = new ArrayList<Vehicle>();
	private ArrayList<Ride> availableRides = new ArrayList<Ride>();
	private ArrayList<Ride> inProgressRides = new ArrayList<Ride>();
	private ArrayList<Ride> finishedRides = new ArrayList<Ride>();
	
	public Simulation(String fileName) {
		this.fileName = fileName;
	};

	public void initialise() {
		ArrayList<int[]> file;
		InputReader ir = new InputReader(fileName);
		
		file = ir.readFile();
		
		for (int i = 0; i < file.size(); i++) {
			int[] fileLine = file.get(i);
			
			if(i == 0) {
				settings = new SimulationSettings(new Map(fileLine[0],fileLine[1]), fileLine[2], fileLine[3], fileLine[4], fileLine[5]);
				for(int c = 0; c < settings.getMaxVehicles(); c++) {
					availableVehicles.add(new Vehicle());
				}
			}else {
				availableRides.add( new Ride(new Position(fileLine[0],fileLine[1]),new Position(fileLine[2],fileLine[3]),fileLine[4], fileLine[5]));
			};
			
		}
	}
	
	public void runSimulation() {
		
		// Steps for Simulation
		for(int simDuration = 0; simDuration < settings.getMaxSteps(); simDuration++ ) {
			
			// Check rides in Progress
			for (Ride ride: new ArrayList<Ride>(inProgressRides)) {
				if(simDuration == ride.getFinishedAt()) {					
					finishedRides.add(ride);
					inProgressRides.remove(ride);
					
					Vehicle vehicle = ride.getVehicle();
					vehicle.setCurrentPos(ride.getEndPosition());
					occupiedVehicles.remove(vehicle);
					availableVehicles.add(vehicle);
				}
			}
			
			// Assign Available vehicles to Rides
			for (Ride ride : new ArrayList<Ride>(availableRides)) {

				for (Vehicle vehicle : new ArrayList<Vehicle>(availableVehicles)) {
					
					if(simDuration < ride.getStartTime()) {
						if (ride.calculateTimeToStart(vehicle) <= ride.getStartTime()) {
							ride.assignVehicle(vehicle, simDuration);
							occupiedVehicles.add(vehicle);
							availableVehicles.remove(vehicle);
							inProgressRides.add(ride);
							availableRides.remove(ride);
							break;
						}
						else {
							continue;
						}
					}
					else {
						ride.assignVehicle(vehicle, simDuration);
						occupiedVehicles.add(vehicle);
						availableVehicles.remove(vehicle);
						inProgressRides.add(ride);
						availableRides.remove(ride);
						break;
					}	
				}
			}
			
		}
		
	}
	
	public void formatOutputConsole() {
		System.out.println("Available Rides");
		for(Ride ride : availableRides) {
			System.out.println(ride.toString());
			
		}
		System.out.println();
		System.out.println("Rides in Progress");
		for(Ride ride : inProgressRides) {
			System.out.println(ride.toString() + " Assigned Vehicle: " + ride.getVehicle().toString());
			
		}
		System.out.println();
		System.out.println("Finished Rides");
		for(Ride ride : finishedRides) {
			System.out.println(ride.toString() + " Assigned Vehicle: " + ride.getVehicle().toString());
			
		}
		System.out.println();
	}
	
	public void formatOutputFile() {
		
		ArrayList<ArrayList<Integer>> outputArray = new ArrayList<ArrayList<Integer>>();		
		OutputWriter or = new OutputWriter(fileName);
		
		for(int i = 0; i < settings.getMaxVehicles(); i++) {
			ArrayList<Ride> ridesPerVehicle = new ArrayList<Ride>();
			ArrayList<Integer> outputLineArray = new ArrayList<Integer>();
			// Retrieve Rides per Vehicle
			for (Ride ride : finishedRides) {
				if (ride.getVehicle().getId() == i) {
					ridesPerVehicle.add(ride);
				}
			}
			// Map Rides per Vehicle to Output
			outputLineArray.add(ridesPerVehicle.size());
			for (Ride ride: ridesPerVehicle) {
				outputLineArray.add(ride.getId());
			}
			outputArray.add(outputLineArray);
		}
		
		or.writeFile(outputArray);
	}

}
