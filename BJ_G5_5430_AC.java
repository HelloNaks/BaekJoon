import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean errorFlag = false;
		boolean isRight = true;

		for (int t = 0; t < T; t++) {
			isRight=true;
			errorFlag = false;
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> deq = new ArrayDeque<>();
			String str = br.readLine();
			if (str.equals("[]")) {
				errorFlag = true;
			} else if (!str.contains(",")) {
				String temp = str.substring(1, str.length() - 1);
				deq.add(Integer.parseInt(temp));

				int size = deq.size();

			} else {
				String[] st = str.split(",");

				for (int i = 0; i < n; i++) {
					if (i == 0) {
						String temp = st[0].substring(1, st[0].length());
						deq.add(Integer.parseInt(temp));
					} else if (i == n - 1) {
						String temp = st[n - 1].substring(0, st[n - 1].length() - 1);
						deq.add(Integer.parseInt(temp));
					} else {
						deq.add(Integer.parseInt(st[i]));
					}
				}
			}
			
			char[] ch = s.toCharArray();
			errorFlag = false;
			for (int i = 0; i < ch.length; i++) {
				switch (ch[i]) {
				case 'R':
					isRight = !isRight;
					break;
				case 'D':
					if (isRight) {
						if (deq.pollFirst() == null) {
							errorFlag = true;
						}
						break;
					} else {
						if (deq.pollLast() == null) {
							errorFlag = true;
						}
						break;
					}
				}
			}
			if (!errorFlag) {
				sb.append("[");
				for (int j = 0; j < deq.size(); j++) {
					if (isRight) {
						sb.append(deq.pollFirst());
						while(!deq.isEmpty()) {
							sb.append(",").append(deq.pollFirst());
						}
					}else {
						sb.append(deq.pollLast());
						while(!deq.isEmpty()) {
							sb.append(",").append(deq.pollLast());
						}
					}
				}
				sb.append("]");
			} else {
				sb.append("error");
			}

			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
