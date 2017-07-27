import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];

        // get input
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        // Merge sort is an overkill. for just 5 elements insertion sort might be enough.
        // Did merge sort to practice implementing it.
        mergeSort(arr);

        // printArr(arr, 0, arr.length);

        System.out.println(String.format("%d %d", sumElements(arr, 0, 4), sumElements(arr, 1, 5)));
    }

    public static long sumElements(int[] arr, int start, int end) {
    	long sum = 0;

    	for (int i = start; i < end; ++i) {
    		sum += arr[i];
    	}

    	return sum;
    }

    public static void mergeSort(int[] arr) {
    	// copy all elements into a temp array
    	int[] dup = new int[arr.length];
    	recusivelyMergeSort(arr, 0, arr.length, dup);
    }

    private static void recusivelyMergeSort(int[] arr, int start, int end, int[] dup) {
    	// any array or sub-array with length 1 or 0 is considered sorted
    	if((end - start) < 2) {
    		return;
    	}

    	int half = start + ((end - start)/2);

    	// recursive call for the left 
    	recusivelyMergeSort(arr, start, half, dup);
    	// recursive call for the right
    	recusivelyMergeSort(arr, half, end, dup);

    	// merge the current array or sub-array 
    	merge(arr, start, half, end, dup);
    }

    private static void merge(int[] arr, int start, int half, int end, int[] dup) {
    	// copy both sections into the helper 
    	for(int i = start; i < end; ++i) {
    		dup[i] = arr[i];
    	}

    	int i = start;
    	int j = half;

    	// iterate from start to end to go over the two sub-array mergin them
    	for(int k = start; k < end; ++k) {
    		// if start elements on the left and either there are no elements 
    		// in the right or element on the left is smaller than the one 
    		// in the right

    		if (i < half && // top the iteration of the left side on at the half
    			(j >= end || // top the iteration of the right side at the end
				dup[i] <= dup[j])) // or the case when the left element is less than the right element
    		{
				arr[k] = dup[i];
    			++i;
    		} else {
    			arr[k] = dup[j];
    			++j;
    		}
    	}
    }

    public static void printArr(int[] arr, int start, int end) {
    	for(int i = start; i < end; ++i) {
    		System.out.print(arr[i]); 
    		System.out.print(" ");
    	}

    	System.out.println();
    }
}
