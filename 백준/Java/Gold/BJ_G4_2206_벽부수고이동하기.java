import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, min;
	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = scann.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
				visited[i][j]=Integer.MAX_VALUE;
			}
		}
		bfs();
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}

	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, 0));
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.r == N - 1 && temp.c == M - 1) {
				min = temp.len;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				int len = temp.len + 1;
				if (!isChecked(nr, nc))
					continue;
				if (visited[nr][nc] <= temp.go) continue;

				if(map[nr][nc] == 0) {
					visited[nr][nc] = temp.go;
					q.add(new Node(nr,nc,len,temp.go));
				}else {
					if(temp.go == 0) {
						visited[nr][nc]= temp.go+1;
						q.add(new Node(nr,nc,len,temp.go+1));
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
		int len;
		int go;

		public Node(int r, int c, int len, int go) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
			this.go = go;
		}

	}

}
