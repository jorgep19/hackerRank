import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();
		int op;
		int x;
		int y;

		// TODO check if this should be lists
		int lastAnswer = 0;
		List<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(N);
		for(int i = 0; i < N; ++i) {
			seqList.add(new ArrayList<Integer>());
		}
		ArrayList<Integer> seq;
		
		for(int i = 0; i < Q; ++i) {
			op = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			switch (op) {
				case 1:
					// query 1 x y
					// lists[(x^lastAnswer)%N]
					// append y to the list above
					x = (x^lastAnswer)%N;
					seqList.get(x).add(y);
				break;
				case 2:
					// query 2 x y
					// seq = lists[(x^lastAnswer)%N]
					// lastAnswer = seq[y%seq.size()]
					// print lastAnswer
					x = (x^lastAnswer)%N;
					seq = seqList.get(x);
					lastAnswer = seq.get(y%seq.size());
					System.out.println(lastAnswer);
				break;	
			}
		}
	}
}