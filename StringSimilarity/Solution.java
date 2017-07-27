import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;

		while(sc.hasNext()) {
			input = sc.nextLine();
			System.out.println(checkSimilarities(input));
		}
	}

	private static int checkSimilarity(String s) {
		int k;
		char[] strArr = s.toCharArray();
		// similarity of the string with itself (the longest suffix) 
		// will be equal to the length of the string
		int similarity = strArr.length;

		// start from 1 since we know the similarity of the longest suffix
		for(int i = 1; i < strArr.length; ++i) {
			k = 0;

			for(int j = i; j < strArr.length; ++j) {
				if(strArr[j] != strArr[k]) {
					break;
				}

				++similarity;
				++k;
			}
		}

		return similarity;
	}
}