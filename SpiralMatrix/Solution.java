import java.io.*;
import java.util.*;

import java.io.*;
public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] nums = input.split(",");

			int rows = Integer.parseInt(nums[0]);
			int columns = Integer.parseInt(nums[1]);
			int[][] matrix = new int[rows][columns];

			// read the matrix
			for(int r = 0; r < rows; ++r) {
				// read int nums for the row
				input = sc.nextLine();
				nums = input.split(",");

				for (int c = 0; c < columns; ++c) {
					matrix[r][c] = Integer.parseInt(nums[c]);
				}
			}

			System.out.println(spiralPrint(matrix, rows, columns));
		}
	}

	private static String spiralPrint(int[][] matrix, int r, int c) {
		StringBuilder sb = new StringBuilder();
		boolean[][] flags = new boolean[r][c];

		int rCounter = 0;
		int cCounter = 0;
		// 0 east, 1 south, 2 west, 3 north
		int direction = 0;
		int x = 0;
		int y = 0;

		while(rCounter < r || cCounter < c) {
			while(x >= 0 && x < c && // check that we are still in bounds for columns
				  y >= 0 && y < r && // check that we are still in bounds for rows
				  !flags[y][x]) // check the current position hasn't been visited 
			{
				flags[y][x] = true;
				sb.append(matrix[y][x]);
				sb.append(",");

				switch(direction) {
					// moving east
					case 0:
						++x;
					break;
					// moving south
					case 1:
						++y;
					break;
					case 2:
						--x;
					break;
					case 3:
						--y;
					break;
				}
			}
						
			// move to the first element in the new direction
			switch(direction) {
					// moving east
					case 0:
						--x;
						++y;
						++rCounter;
					break;
					// moving south
					case 1:
						--y;
						--x;
						++cCounter;
					break;
					// moving west
					case 2:
						++x;
						--y;
						++rCounter;
					break;
					// moving north
					case 3:
						++y;
						++x;
						++cCounter;
					break;
			}
			// actually change direction
			direction = (direction + 1) % 4;
		}

		// delete trailing ',' instead of checking if we should add it at every element
		sb.setLength(sb.length()-1);

		return sb.toString();
	}
}