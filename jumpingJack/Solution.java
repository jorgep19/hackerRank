import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int k;

		while(sc.hasNext()) {
			n = sc.nextInt();
			k = sc.nextInt();

			System.out.println(maxStep(n, k));
		}

		for (int i = 0; i < seq.length; ++i) {
			System.out.print(seq[i]);
		}
	}

	private static int[] seq = new int[2000];
	private static int max = 0;

	// Improment by adding 
	private static int maxStep(int n, int k) {
		boolean kInSeq = false;
		int sum = 0;

		if(max < n) {
			computeSeq(n);
		}

		// if we were to jump into we can avoid by skipping the first step.
		return isKInSeq(k) ? --seq[n] : seq[n];
	}

	private static void computeSeq(int newMax) {
		int sum = seq[max];

		for(int i = max; i <= newMax; ++i) {
			sum += i;
			seq[i] = sum;
		}

		max = newMax;
	}

	// Bynary search for k in the memoized values
	private static boolean isKInSeq(int k) {
		int bottom = 0;
		int top = seq.length;
		int middle;

		while(bottom <= top) {
			middle = bottom + ((top-bottom)/2);

			if (seq[middle] == k) {
				return true;
			}

			if (seq[middle] < k) {
				top = middle-1;
			} else {
				bottom = middle+1;
			}
		}

		return false;
	}
}


	// private static int maxStep(int n, int k) {
	// 	boolean kInSeq = false;
	// 	int sum = 0;

	// 	for(int i = 1; i <= n; ++i) {
	// 		sum += i;
	// 		kInSeq = sum == k || kInSeq;
	// 	}

	// 	// if we were to jump into we can avoid by skipping the first step.
	// 	return kInSeq ? --sum : sum;
	// }