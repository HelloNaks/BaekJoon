import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] arr;
	static int N, M;
	static int cnt = 0;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		arr = new int[N][M];
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = scann.nextInt();
			}
		}
		while (true) {
			temp = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			int num=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && arr[r][c] != 0) {
						bfs(r, c, visited);
						num++;
					}
				}
			}
			if(num==0) {
				System.out.println(0);
				break;
			}else if(num >=2) {
				System.out.println(cnt);
				break;
			}

			++cnt;

			//boolean flag = false;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int cnt0=0;
					if (arr[r][c] != 0) {
						//flag = true;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (isChecked(nr, nc) && arr[nr][nc] == 0) {
								cnt0++;
							}
						}
						temp[r][c] = arr[r][c] - cnt0;
						if (temp[r][c] < 0) {
							temp[r][c] = 0;
						}
					}
				}
			}
			arr = temp;
		}
	}

	private static void bfs(int r, int c, boolean[][] visited) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					if (isChecked(nr, nc) && !visited[nr][nc] && arr[nr][nc] != 0) {
						visited[nr][nc] = true;
						q.add(new Node(nr,nc));
					}
				}
			}
		}
	}

	private static boolean isChecked(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
