import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] arr = new long[n+1];
		
		int a, b, k;
		long max = 0;
		long x = 0;

		for(int i = 0; i < m; ++i) {
			a = sc.nextInt();
			b = sc.nextInt();
			k = sc.nextInt();

			arr[a] += k;

			if(b+1 <= n) {
				arr[b+1] -= k;
			}
		}

		for(int i = 0; i <= n; ++i) {
			x += arr[i];
			max = (max < x) ? x : max;
		}


		System.out.println(max);
	}
}