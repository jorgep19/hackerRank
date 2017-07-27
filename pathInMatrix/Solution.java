import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows;
		int cols;
		int[][] matrix;

		while(sc.hasNext()) {
			rows = sc.nextInt();
			cols = sc.nextInt();
			matrix = new int[rows][];

			for(int r = 0; r < rows; ++r) {
				matrix[r] = new int[cols];
				for(int c = 0; c < cols; ++c) {
					matrix[r][c] = sc.nextInt();
				}
			}

			System.out.println(findPathsCount(matrix));
		}
	}

	private static int findPathsCount(int[][] matrix) {
		return findPathsRecursive(matrix, 0, 0);
	}

	private static Set<String> visited = new HashSet<String>();

	private static int findPathsRecursive(int[][] matrix, int r, int c) {
		int retVal = 0;
		String currentLoc = String.format("%d, %d", r, c);
		String newLoc;
		int newR;
		int newC;

		if(r == (matrix.length-1) && c == (matrix[(matrix.length-1)].length-1)) {
			// System.out.println(String.format("return won cuz it got to %d,%d", r, c));
			return 1;
		}

		// move to the right
		newC = c+1; 
		newLoc = String.format("%d, %d", r, (c+1));
		if(newC < matrix[r].length && matrix[r][newC] == 1) {
			// System.out.println(String.format("Moving right to %d,%d", r, (c+1)));
			visited.add(newLoc);
			retVal += findPathsRecursive(matrix, r, newC);
			visited.remove(newLoc);
		}

		// move down
		newR = r+1;
		newLoc = String.format("%d, %d", (r+1), c);
		if(newR < matrix.length && matrix[newR][c] == 1) {
			// System.out.println(String.format("Moving down to %d,%d", r+1, c));
			visited.add(newLoc);
			retVal += findPathsRecursive(matrix, newR, c);
			visited.remove(newLoc);
		}

		return retVal;
	}

	private static class Coordinates {
		final int R;
		final int C;

		public Coordinates(int r, int c) {
			R = r;
			C = c;
		}
	}

	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[i].length; ++j) {
				System.out.print(String.format("%d ", matrix[i][j]));
			}

			System.out.println();
		}

		System.out.println();
	}
}