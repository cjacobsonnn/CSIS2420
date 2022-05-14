package CSIS2420FinalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * The MakeFile class uses a main to create new Random which will write to a blank text file called file.txt, followed
 * by uses a FileWrite and PrinterWrite with a for loop to generate 4000 tasks with a date, name, and category which 
 * are written to the Binary Search Tree from the text file of generated tasks. 
 * 
 * @author CJ Jacobson
 * @version 1.0
 *
 */
public class MakeFile {

	public static void main(String[] args) throws IOException {
		Random rand = new Random();
        File file = new File("/Users/cjacobson/eclipse-workspace/2420_Assignments/src/final_project/file.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        for(int i = 0; i<4000; i++) {
        	
        	pw.println("0"+(rand.nextInt(9)+1)+"/"+(rand.nextInt(20)+10)+"/"+(rand.nextInt(80)+10)+",activity"+i+","+rand.nextInt(5));

        }
        pw.close();

	}

}
