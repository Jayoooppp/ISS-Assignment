// Reading from First.txt and writing into Second.txt

package Assignment;

import java.io.*;
import java.util.Scanner;

public class FileReadAndWrite {
	public static void main(String arg[]) throws IOException {
		String text = "";
		
//		Reading content from File First.txt
		try {
				
	      File fileObj1 = new File("D:\\Eclipse-workspace\\Assignment\\src\\Assignment\\First.txt");
	      Scanner myReader = new Scanner(fileObj1);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        text += data;
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
		
		
//		Writing content into File Second.txt
		File fileObj2 = new File("D:\\Eclipse-workspace\\Assignment\\src\\Assignment\\Second.txt");
		if(fileObj2.createNewFile()) {
			// File Created
			  FileWriter myWriter = new FileWriter("D:\\Eclipse-workspace\\Assignment\\src\\Assignment\\Second.txt");
			  myWriter.write(text);
		      myWriter.close();
		}
	}

}
