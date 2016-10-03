/**
 * This file contains the main function that launches the sorting algorithm
 */

import utils.Sorting;
import utils.Array;

public class SortingLauncher
{
    public static void main(String[] args)
	{
// 		Array data = new Array(new int[]{4,7,5,3,1,6,8});
        
		Array data = new Array("data/IntegerArray.txt");
		
// 		data = Sorting.bubbleSort(data);
// 		data = Sorting.heapSort(data);
        // data = Sorting.quickSort(data);
// 		data.print();
        long startTime, endTime, totalTime;
        startTime = System.currentTimeMillis();
		data = Sorting.quickSort(data);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
        System.out.println(totalTime);
// 		data.print();
		
// 		System.out.println();

	}
}
