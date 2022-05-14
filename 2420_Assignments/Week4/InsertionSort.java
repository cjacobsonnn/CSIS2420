package Week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort 
{

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Insertion Sort");

		String dataFile = "AccountNumbers.csv";
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		int numLines = 0;
		BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        // Count the number of lines in the data file
        System.out.print("Counting lines in the data file ... ");
		while (reader.readLine() != null) numLines++;
		reader.close();
		System.out.println(numLines);
		int[] accounts = new int[numLines];

    	// Get data set from file and load array with values
    	System.out.println("Building array from the data file ...");
        br = new BufferedReader(new FileReader(dataFile));
    	for (int i = 0; i < numLines; i++)
    	{
    		line = br.readLine();
			String[] account = line.split(csvSplitBy);
    		accounts[i] = Integer.valueOf(account[0]);
    	}

    	// Conduct sort
    	if (numLines <= 25)
    	{
            System.out.println("\nArray Before Sort:");  
            for(int account : accounts)
            {  
                System.out.print(account + " ");  
            }  
            System.out.println();  
    	}
    	else
    	{
            System.out.println("\nStarting Sort ...");  
    	}

    	long start = System.nanoTime();

        insertionSort(accounts); 
        
        long stop = System.nanoTime();
        
        long totalTime = (stop-start)/1000000;
        
        System.out.println(totalTime + "ms");

        
    	if (numLines <= 25)
    	{
            System.out.println("\nArray After Sort:");  
            for(int account : accounts)
            {  
                System.out.print(account + " ");  
            }  
    	}
    	else
    	{
    		System.out.println("\n... Sort Complete.");  
    	}

        // Clean up
        br.close();
		accounts = null;

	}
	
/*
 * The method insertionSort uses an algorithm which takes array2Sort and int currentElement
 * to create an array that inserts the incoming int currentElement into a sorted list until
 * the entire array is sorted. To create an Insertion Sort.
 */
private static void insertionSort(int[] array2Sort) 
{
	for (int i = 1; i < array2Sort.length; i++) 
	{
		int currentElement = array2Sort[i];
		int k;
		for (k = i - 1; k >= 0 && array2Sort[k] > currentElement; k--) 
		{
			array2Sort[k + 1] = array2Sort[k];
		}
		array2Sort[k + 1] = currentElement;
	}
}

}