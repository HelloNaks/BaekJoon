import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt();
		C = scann.nextInt();
		int result = 0;
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String s = scann.next();
			char[] ch = s.toCharArray();
			for(int j=0;j<C;j++) {
				map[i][j]=ch[j];
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='L') {
					visited=new boolean[R][C];
					int value = bfs(i,j);
					result = Math.max(value, result);
				}
			}
		}
		System.out.println(result);
	}

	private static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		int len = 0;
		visited[r][c]=true;
		q.add(new Point(r,c,0));
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int d=0;d<4;d++) {
				int nr=temp.r+dr[d];
				int nc=temp.c+dc[d];
				if(isChecked(nr,nc) && !visited[nr][nc] && map[nr][nc]=='L') {
					visited[nr][nc]=true;
					q.add(new Point(nr,nc, temp.cnt+1));
					len = Math.max(len, temp.cnt+1);
				}
			}
		}
		return len;
	}

	private static boolean isChecked(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

	private static class Point{
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
