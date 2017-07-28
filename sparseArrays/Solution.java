import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String[] strings = new String[n];
		for(int i = 0; i < n; ++i) {
			strings[i] = sc.nextLine();
		}

		int q = sc.nextInt();
		sc.nextLine();
		String query;
		int count;
		for(int i = 0; i < q; ++i) {
			count = 0;
			query = sc.nextLine();

			for (int s = 0; s < n; ++s) {
				if(strings[s].equals(query)) {
					++count;
				}
			}

			System.out.println(count);
		}
	}
}