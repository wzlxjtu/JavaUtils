/**
 * This file implements an array that scales itself automatically.
 * Function add(value) to add elements.
 * get(index) to return elements.
 * set(index, value) to change elements
 * swap(index1, index2) to swap two values
 * flip() to flip the array
 * max(), min() to return maximum and minimum
 * readFile(filename) to read integers from file into an array.
 * Currently it only support integers.
 */
package utils;

import java.util.Scanner;
import java.io.File;

public class Array
{
	private int[] array;
	private int size;
	
	public Array()
	{
		array = new int[100];
		size = 0;
	}
	public Array(int[] src)
	{
		array = src;
		size = src.length;
	}
	public Array(Array src)
	{
		// the copy constructor
		array = new int[100];
		size = 0;
		for (int i = 0; i < src.size(); ++i)
		{
			add(src.get(i));
		}
	}
	public Array(String filename)
	{
		// initialize the array from a file
		array = new int[100];
		size = 0;
		readfile(filename);
	}
	public int size()
	{
		return size;
	}
	public void add(int x)
	{
		if (array.length == size)
		{
			resize(size * 2);
		}
		array[size] = x;
		size++;
	}
	public int get(int i)
	{
		if (i >= size)
		{
			System.out.println("Failed: access an item that is beyond the range!");
		}
		return array[i];
	}
	public void set(int i, int value)
	{
		array[i] = value;
	}
	public void swap(int i, int j)
	{
		int temp = get(i);
		set(i, get(j));
		set(j, temp);
	}
	public void flip()
	{
		int[] temp = new int[size];
		for (int i = 0; i < size; ++i)
		{
			temp[i] = array[size - i - 1];
		}
		array = temp;
	}
	public int max()
	{
		int maximum = get(0);
		for (int i = 0; i < size; ++i)
		{
			if (get(i) > maximum)
				maximum = get(i);
		}
		return maximum;
	}
	public int min()
	{
		int minimum = get(0);
		for (int i = 0; i < size; ++i)
		{
			if (get(i) < minimum)
				minimum = get(i);
		}
		return minimum;
	}
	public void print()
	{
		for (int i = 0; i < size; ++i)
		{
			System.out.println(array[i]);
		}
	}
	public int find(int item) // return the index of an interested item. -1 for no such item
	{
		int index = -1;
		for (int i = 0; i < size; i++)
		{
			if (get(i) == item)
			{
				index = i;
			}
		}
		return index;
	}
	private void readfile(String filename)
	{
		Scanner src = null;
		try
		{
			src = new Scanner(new File(filename));
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.exit(0);
		}
		while (src.hasNext())
		{
			add(src.nextInt());
		}
	}
	private void resize(int new_size)
	{
		int[] temp = new int[new_size];
		System.arraycopy(array, 0, temp, 0, size);
		array = temp;
	}
}