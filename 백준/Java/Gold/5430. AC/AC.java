import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			Deque<Integer> deq = new ArrayDeque<>();
			boolean isRight = true;
			boolean isError = false;
			String command = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			nums = nums.substring(1, nums.length() - 1);
			if (!nums.equals("")) {
				String[] numbers = nums.split(",");
				for (int i = 0; i < numbers.length; i++) {
					deq.addLast(Integer.parseInt(numbers[i]));
				}
			}
			for (int i = 0; i < command.length(); i++) {
				switch (command.charAt(i)) {
				case 'R':
					int size = deq.size();
					isRight = !isRight;
					break;
				case 'D':
					if (isRight) {
						if (deq.pollFirst() == null) {
							isError = true;
							sb.append("error\n");
						}
						break;
					} else {
						if (deq.pollLast() == null) {
							isError = true;
							sb.append("error\n");
						}
						break;
					}
				}

				if(isError) {
					break;
				}
			}
			if (!isError) {
				sb.append("[");
				for (int j = 0; j < deq.size(); j++) {
					if (isRight) {
						sb.append(deq.pollFirst());
						while (!deq.isEmpty()) {
							sb.append(",").append(deq.pollFirst());
						}
					} else {
						sb.append(deq.pollLast());
						while (!deq.isEmpty()) {
							sb.append(",").append(deq.pollLast());
						}
					}
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb);
	}
}
