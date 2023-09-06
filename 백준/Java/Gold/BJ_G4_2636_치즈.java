import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int R, C;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt();
		C = scann.nextInt();
		map = new int[R][C];
		visited = new boolean[R][C];
		int prev=0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				map[r][c] = scann.nextInt();
				if(map[r][c]==1) {
					prev++;
				}
			}
		}
		int cnt = 0;
		int num = 0;
		while (true) {
			visited = new boolean[R][C];
			num++;
			cnt=0;
			bfs();
			dfs();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						cnt++;
					}
				}
			}
      
			if (cnt == 0) {
				break;
			}
			prev=cnt;
		}
		System.out.println(num);
		System.out.println(prev);
	}

	private static void dfs() {
		int[][] tempArr = new int[R][C];
		tempArr = map;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (isChecked(nr, nc) && map[nr][nc] == -1) {
							tempArr[r][c] = 0;
							break;
						}
					}
				}
			}
		}

		map = tempArr;
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		map[0][0] = -1;
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = temp.r + dr[d];
					int nc = temp.c + dc[d];
					if (isChecked(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
						visited[nr][nc] = true;
						map[nr][nc] = -1;
						q.add(new Node(nr, nc));
					}
				}
			}
		}
	}

	private static boolean isChecked(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
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
