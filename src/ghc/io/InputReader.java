package ghc.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {
	
	private String fileName;
	
	public InputReader(String fileName) {
		this.fileName = fileName;
	}
	
	public ArrayList<int[]> ReadFile() {
		FileReader fr;
		BufferedReader br;
		
		String fileLine = null;
		String[] fileArray = null;
		
		ArrayList<int[]> file = new ArrayList<>();
		int[] outputArray;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while ((fileLine = br.readLine()) != null) {
				outputArray = new int[6];
				fileArray = fileLine.split(" ");
				for(int i = 0; i < fileArray.length; i++) {
					outputArray[i] = Integer.parseInt(fileArray[i]);
				}
				file.add(outputArray);
			};
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}
		
		return file;
	}
	
	
	
}
