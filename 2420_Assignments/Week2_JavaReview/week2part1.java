package Week2_JavaReview;

import java.util.Scanner;

public class week2part1 {
	
	public static void main(String[] args) {
		int min;
		int max;
		int total = 0;
		int highScore = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the min value: ");
		min = input.nextInt();
		
		System.out.println("Enter the max value: ");
		max = input.nextInt();
		 
		for (int i=min; i<=max; i++) {
			total += i;	
		}
		
		System.out.printf("The total of the min value to the max value is the total = %,d%n%n%n", total);
		
		System.out.println("Total Scores");
		
		int [][] gameScores = {
				{44, 63, 45, 23, 76, 45},
				{76, 23, 56, 98, 33, 24},
				{23, 71, 92, 39, 45, 44},
				{70, 20, 46, 64, 77, 29},
				{83, 45, 99, 20, 10, 21},
				{86, 34, 92, 34, 88, 11}
		};
		
		for (int i = 0; i< gameScores.length;  i++){
			
			int scores = 0;
			for (int j = 0; j< gameScores.length;  j++){

				scores = scores + gameScores[i][j];	
						
			}
			
			System.out.printf("Row %d: = %d%n", i+1,scores);
				if(highScore < scores) {
					highScore = scores;
			}
		
		}
		
		System.out.println("Highscore: " +highScore);
			
	}
	
}
