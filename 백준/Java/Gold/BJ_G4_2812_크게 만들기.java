import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scann.nextInt();
		int K = scann.nextInt();
		int[] arr = new int[N];
		int[] answer = new int[N - K];
		char[] ch = scann.next().toCharArray();
		for (int i = 0; i < N; i++) {
			arr[i] = ch[i] - '0';
		}
		Stack<Integer> st = new Stack<>();
		st.add(arr[0]);
		int minus = 0;
		for (int i = 1; i < N; i++) {
			while (!st.isEmpty()) {
				if (minus == K) {
					break;
				}
				if (st.peek() < arr[i]) {
					st.pop();
					minus++;
				} else if (st.peek() >= arr[i]) {
					break;
				}
			}
			st.add(arr[i]);
		}
		if (minus < K) {
			int left = K - minus;
			for (int i = 0; i < st.size() - left; i++) {
				sb.append(st.get(i));
			}
		} else {
			for (int i = 0; i < st.size(); i++) {
				sb.append(st.get(i));
			}
		}
		System.out.println(sb.toString());
	}
}
