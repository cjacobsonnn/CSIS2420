package Week3;

import java.util.Arrays;
import java.util.Random;

public class linearSearch {
	
	static int count = 0;

	public static void main(String[] args) {
		
		int min = 10000;
		int max = 99999;
		int numElements = 10000000;
		Random rand = new Random();
		int dataArray[] = new int[numElements];
		for (int i = 0; i < dataArray.length; i++)
		{
		    dataArray[i] = (rand.nextInt((max - min) + 1) + min);
		}
		
		int memoryConsumption = (4 * dataArray.length) + 24 + 8;
		int foundAt= linearSearch(dataArray, 15000);
		
		if(foundAt== -1){
            System.out.println("Not Found");
        }
        else {
	            System.out.println("Found at"+foundAt);    
        }
		
		System.out.print(count);
	}
	
	 static int linearSearch(int searchArray[], int seekValue)
	  {	 
	      for (int i = 0; i < searchArray.length; i++)
	      {
	    	  count++;
	    	  
	          if (searchArray[i] == seekValue)
	              return i;
	      }
	      return -1;
	  }

}
 