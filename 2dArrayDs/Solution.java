import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result;
		int S = 6;
		int CAP = 4;
		int max = Integer.MIN_VALUE;
		int[][] matrix = new int[S][S];

		// load matrix
		for(int i = 0; i < S; ++i) {
			for(int j = 0; j < S; ++j) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < CAP; ++i) {
			for(int j = 0; j < CAP; ++j) {
				result = computeHourglass(i, j, matrix);
				// System.out.println(String.format("i=%d, j=%d and got result=%d", i, j, result));
				max = result > max ? result : max;
			}
		}

		System.out.println(max);
	}

	private static int computeHourglass(int i, int j, int[][] matrix) {
		return matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] +
			   				  matrix[i+1][j+1] +
			   matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
	}
}