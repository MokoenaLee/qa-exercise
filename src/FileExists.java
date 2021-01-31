/**
 * @author lee-annmokoena
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FileExists {
	
	public static void main(String[] args) throws IOException {
		
		/*fileCheck is the reference variable with it's type as FileExist class*/
		
		FileExists fileCheck = new FileExists();
		
		
		/*Specify file Path**/
		
		String path = "./../CodingExercises/src/words.txt";
		
		boolean fileExists = fileCheck.doesFileExist(path);
		
	

		if(fileExists) {
			System.out.println("FILE EXISTS");
		}
		else {
			System.out.println("FILE DOES NOT EXIST");
		}
		
		printWords(path);
		
	}
	
boolean doesFileExist(String path) throws FileNotFoundException {
		
		File directory = new File(path);
		
		boolean exists = directory.exists();
		
		if(exists)
			return true;
		return false;
	}
	
	

	public static void printWords(String path) throws IOException {
		
		File file = new File(path);
		
		
		BufferedReader reader; 
		
		try {
			
			reader = new BufferedReader(new FileReader(file));
			
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				

			
				
				String word_line  = line;
				String word = "";
				String meaning = "";
				
				/** verify data format is word - meaning 
				 * to avoid potential Out of Bounds Error(s)*/
				
				if(word_line.indexOf('-') > -1) {
					
					String[] split_line = word_line.split("\\-");
					
					
					word = split_line[0];
					
					meaning = split_line[1];
					
					/**checking for multiple definitions*/
					
					if(meaning.indexOf(',') > -1) {
						
						String[] definitions = meaning.split(",");
						
						System.out.println(word);
						
						for(int index=0; index< definitions.length;index++) {
							System.out.println(definitions[index]);
						}
						
					}else {
						System.out.println(word + "\n" + meaning);
					}
					
				}else {
					System.out.println("\n");
					System.out.println("Ensure that data in file follow format word - meaning1, meaning2");
				}

			}
			
			/**free up resources**/
			reader.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	


}
