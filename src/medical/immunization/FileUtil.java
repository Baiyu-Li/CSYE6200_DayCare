/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.immunization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readFile() {

		List<String> ret = new ArrayList<>();
		BufferedReader br = null;

		try {

			File file = new File("src/vaccine.csv");

			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}

			String line = null;

			while ((line = br.readLine()) != null) {
				ret.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return ret;

	}

	public static void writeFile(List<String> lines) {

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter("src/vaccine_output.csv");
			printWriter = new PrintWriter(fileWriter);
		    
			for(String s : lines) {
				printWriter.println(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(printWriter != null) {
				printWriter.close();
			}
			
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    

	}
}
