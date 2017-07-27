import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[n];
		int[] shftd = new int[n];
		int tmp;

		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}

		for(int i = 0; i < n; ++i) {
			if(i-d < 0) {
				tmp = d-i;
				shftd[n-tmp] = arr[i];
			} else {
				shftd[i-d] = arr[i];
			}
		}

		for(int i = 0; i < n; ++i) {
			System.out.print(shftd[i]);

			if(i != (n-1)) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}