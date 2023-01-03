import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			int M = sc.nextInt();
			int P = sc.nextInt();

			int[] indegree = new int[M + 1];
			ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
			int[] max = new int[M + 1];
			int[] num = new int[M + 1];

			for (int i = 0; i < M + 1; i++) {
				lists.add(new ArrayList<>());
			}

			for (int p = 0; p < P; p++) {
				int before = sc.nextInt();
				int after = sc.nextInt();
				lists.get(before).add(after);
				indegree[after]++;
			}
			int answer = topological_sort(lists, indegree, max, num);
			System.out.println(K + " " + answer);
		}
	}

	private static int topological_sort(ArrayList<ArrayList<Integer>> lists, int[] indegree, int[] max, int[] num) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				max[i] = 1;
				num[i] = 1;
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : lists.get(now)) {
				indegree[next]--;

				if (max[next] == max[now]) {
					num[next]++;
				} else {
					if(max[next]<max[now]) {
						num[next] = 1;
						max[next] = Math.max(max[now], max[next]);
					}
				}

				if (indegree[next] == 0) {
					q.add(next);

					if (num[next] != 1) {
						max[next] = Math.max(max[now], max[next]) + 1;
					} else {
						max[next] = Math.max(max[now], max[next]);
					}
				}
			}
		}

		int answer = 0;
		for (int i = 1; i < max.length; i++) {
			answer = Math.max(answer, max[i]);
		}
		return answer;
	}

}
