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
	
	public ArrayList<String> ReadFile() {
		FileReader fr;
		BufferedReader br;
		
		ArrayList<String> file = new ArrayList<>();
		String fileLine = null;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while ((fileLine = br.readLine()) != null) {
				file.add(fileLine);
			};
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("I/O Exception");
		}
		return file;
	}
	
	
	
}
