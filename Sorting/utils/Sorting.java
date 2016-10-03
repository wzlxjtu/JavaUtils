/**
 * This file implments several sorting algorithms
 * Bubble sort
 * Heap sort
 * Quick sort
 * The input is an unsorted array, and the output is a new sorted array
 */
package utils;

public class Sorting
{
	public static Array bubbleSort(Array unsorted)
	{
		Array sorted = new Array(unsorted);
		boolean swapped = true;
		int n = sorted.size();
		int n_last_swap; // the index of the last element being swapped. elements after that are already sorted
		while (n != 0)
		{
			n_last_swap = 0;
			for (int i = 1; i < n; ++i)
			{
				if (sorted.get(i-1) > sorted.get(i))
				{
					sorted.swap(i-1, i);
					n_last_swap = i;
				}
			}
			n = n_last_swap;
		}
		return sorted;
	}
	public static Array heapSort(Array unsorted)
	{
		Array heapified = Heap.heapify(unsorted);
		int iEnd = heapified.size() - 1;
		while (iEnd > 0)
		{
			heapified.swap(0, iEnd);
			--iEnd;
			Heap.siftDown(heapified, 0, iEnd);
		}
		return heapified;
	}
	// the public quickSort create a duplicate array,
	// and then call the private quicksort algorithm recursively to perform on the duplicated array
	public static Array quickSort(Array unsorted)
	{
		Array sorted = new Array(unsorted);
		quickSort(sorted, 0, sorted.size() - 1);
		return sorted;
	}
	// the actual recursive sorting algorithm
	private static void quickSort(Array A, int iStart, int iEnd)
	{
		if (iStart == iEnd)
		{
			return;
		}
		int pivot = Rand.randInt(iStart, iEnd);
		pivot = partition(A, iStart, iEnd, pivot);
		if (pivot > iStart)
		{
			quickSort(A, iStart, pivot - 1);
		}
		if (pivot < iEnd)
		{
			quickSort(A, pivot + 1, iEnd);
		}
	}
	// partition method for quickSort algorithm
	private static int partition(Array A, int iStart, int iEnd, int pivot)
	{
		A.swap(iStart, pivot);
		int p = A.get(iStart); // the value of the pivot element
		int i = iStart + 1;
		for (int j = iStart + 1; j <= iEnd; ++j)
		{
			if (A.get(j) < p)
			{
				A.swap(i,j);
				++i;
			}
		}
		A.swap(iStart, i - 1);
		return i - 1; // return the final position of the pivot
	}
}