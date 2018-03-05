package ghc.main;

public class Program {

	public static void main(String[] args) {
		System.out.println("Google Hash Code 2018 - Automation of self-driving cars");
		
		Simulation simulation = new Simulation();
		
		simulation.initialise();
		simulation.runSimulation();
		simulation.formatOutput();
		
		System.out.println("End of Processing.");	
	}
}
