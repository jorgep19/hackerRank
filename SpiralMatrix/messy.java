import java.io.*;
import java.util.*;

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

		// 1 east, 2 south, 3 west, 4 north - This could be an enum 
		// for code clarity
		int direction = 1;
		int x = 0;
		int y = 0;
		int rCounter = 0;
		int cCounter = 0;
		
		while(rCounter < r || cCounter < c) {
			switch(direction) {
				case 1: 
					sb.append(String.format("Moving East from %d, %d\n", y , x));
					for(; x <= (c-rCounter) && x < c; ++x) {
						sb.append(String.format("%d,\n", matrix[y][x]));
					}

					// turn south 
					direction = 2;
					// move to adjecent cell moving south
					++y;
					--x; // due to the for loop we actully move out of bounds in the last interation
					// mark the row as printed
					++rCounter;
				break;
				case 2: 
					sb.append(String.format("Moving South from %d, %d\n", y , x));
					for(; y <= (r-cCounter) && y < r; ++y) {
						sb.append(String.format("%d,\n", matrix[y][x]));
					}

					// turn west
					direction = 3;
					// move to the adjecent cell moving west
					--x;
					--y; // due to the for loop we actully move out of bounds in the last interation
					// mark the column as printed
					++cCounter;
				break;
				case 3:
					sb.append(String.format("Moving West from %d, %d.. rCounter at %d.\n", y , x, rCounter));
					for(; x >= (rCounter-1); --x) {
						sb.append(String.format("%d,\n", matrix[y][x]));
					}

					// turn north
					direction = 4;
					// move to the adjecent cell moving north
					--y;
					++x; // due to the for loop we actully move out of bounds in the last interation
					// mark the row as printed
					++rCounter;
				break;
				case 4: 
					sb.append(String.format("Moving North from %d, %d.. cCounter at %d\n", y , x, cCounter));
					for(; y >= (cCounter-1); --y) {
						sb.append(String.format("%d,\n", matrix[y][x]));
					}

					// turn east 
					direction = 1;
					// move to the adjecent cell moving east
					++x;
					++y; // due to the for loop we actully move out of bounds in the last interation
					// mark the column as printed
					++cCounter;
				break;
			}
		}

		// remove the trailing ','. This felt cleaner than check all the time if this was the last 
		// number to print
		sb.setLength(sb.length()-1);

		return sb.toString();
	}
}