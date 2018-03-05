package ghc.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class OutputWriter {

	private String fileName;
	
	public OutputWriter(String fileName) {
		this.fileName = "output_files/" + fileName + ".out";
	}
	
	public void writeFile(ArrayList<ArrayList<Integer>> output) {
		
		try {
			FileOutputStream fsw = new FileOutputStream(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(fsw, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (ArrayList<Integer> outputLine : output) {
				String outputString = "";
				for (int i : outputLine) {
					outputString += i + " ";
				}
				bw.write(outputString);
				bw.newLine();
			}
			
			bw.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
