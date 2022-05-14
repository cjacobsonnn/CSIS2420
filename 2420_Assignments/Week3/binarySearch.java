package Week3;

import java.util.Random;

public class binarySearch {
	
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
			int foundAt= binarySearch(dataArray, 15000);
			
			if(foundAt== -1){
	            System.out.println("Not Found");
	        }
	        else {
		            System.out.println("Found at"+foundAt);    
	        }
			
			System.out.print(count);

	}
	
	  static int binarySearch(int searchArray[], int seekValue)
	  {
	    int low = 0;
	    int high = searchArray.length - 1;
	    while (low <= high) {
	    	
	    	int mid = low + (high- low) / 2;
	    	
	    	count++;
	    	
	        if (searchArray[mid] == seekValue)
	            return mid;
	        if (searchArray[mid] < seekValue)
	        	low = mid + 1;
	        else
	        	high = mid - 1;
	    }
		return -1;
	  }

}
