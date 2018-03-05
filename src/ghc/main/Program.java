package ghc.main;

public class Program {

	public static void main(String[] args) {
		System.out.println("Google Hash Code 2018 - Automation of self-driving cars");
		
		Simulation simulation = new Simulation("a_example");
		
		simulation.initialise();
		simulation.runSimulation();
		simulation.formatOutputConsole();
		simulation.formatOutputFile();
		
		System.out.println("End of Processing.");	
	}
}
