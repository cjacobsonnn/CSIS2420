package Week2_JavaReview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class week2part2 {

	public static void main(String[] args) throws FileNotFoundException {
		float total = 0;
		int numberOfRows = 0;
		
		File text = new File("/Users/cjacobson/eclipse-workspace/2420_Assignments/week2part2.txt");
		Scanner reader = new Scanner(text);
		
		while(reader.hasNextLine()) {
			
			total = total+Float.valueOf(reader.nextLine());
			numberOfRows = numberOfRows + 1;
		}
		
		reader.close();
		
		System.out.printf("Rows = %,d Sum of Numbers Equals: %,.2f Average = %,.2f", numberOfRows,total,total/numberOfRows);
	}

}
