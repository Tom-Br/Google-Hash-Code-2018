package ghc.main;

import java.util.ArrayList;

import ghc.bl.*;
import ghc.io.*;

public class Program {
	
	private static SimulationSettings settings;
	private static VehicleCollection vehicles;
	private static RideCollection rides;

	public static void main(String[] args) {
		System.out.println("Google Hash Code 2018 - Automation of self-driving cars");
		
		// Read Input / Initialise Simulation Variables
		initialise();
		
		// Set Simulation Settings
		// Run Simulation
		// Format Output
		
	}
	
	private static void initialise(){
		ArrayList<int[]> file;
		InputReader ir = new InputReader("input_files/a_example.in");
		
		file = ir.ReadFile();
		
		for (int i = 0; i < file.size(); i++) {
			int[] fileLine = file.get(i);
			
			if(i == 0) {
				settings = new SimulationSettings(new Map(fileLine[0],fileLine[1]), fileLine[2], fileLine[3], fileLine[4], fileLine[5]);
				System.out.println(settings.toString());
				
				for(int c = 0; c < settings.getMaxVehicles(); c++) {
					System.out.println(new Vehicle());
				}
				
			}else {
				System.out.println(new Ride(new Position(fileLine[0],fileLine[1]),new Position(fileLine[2],fileLine[3]),fileLine[4], fileLine[5]));
			};
			
		}
	};
}