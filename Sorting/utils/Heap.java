/**
 * This file implements several static operations on heap data structure
 * Function heapify() turns a regular array into a heap.
 * siftDown() repairs a disrupted heap.
 * Currently it only support integers.
 */
package utils;

public class Heap
{
    // Create a heap from an array
    public static Array heapify (Array unheapified)
    {
        Array heapified = new Array(unheapified);
        int count = heapified.size();
        int iStart = iParent(count - 1);
        while (iStart >= 0)
        {
            siftDown(heapified, iStart, count - 1);
            --iStart;
        }
        
        return heapified;
    }
    // Repair the heap whose root element is at index 'start', assuming the heaps rooted at its children are valid
    public static void siftDown(Array data, int iStart, int iEnd)
    {
        int iRoot = iStart;
        int iChild, iSwap;
        while (iLeftChild(iRoot) <= iEnd)
        {
            iChild = iLeftChild(iRoot);
            iSwap = iRoot;
            if (data.get(iSwap) < data.get(iChild))
            {
                iSwap = iChild;
            }
            if ((iChild + 1 <= iEnd) && data.get(iSwap) < data.get(iChild + 1))
            {
                iSwap = iChild + 1;
            }
            if (iSwap == iRoot)
            {
                return;
            }
            else
            {
                data.swap(iRoot, iSwap);
                iRoot = iSwap;
            }
        }
    }
    // if i is the index of the current node
    private static int iParent(int i)
    {
        return (i - 1) / 2;
    }
    private static int iLeftChild(int i)
    {
        return 2 * i + 1;
    }
    private static int iRightChild(int i)
    {
        return 2 * i + 2;
    }
}