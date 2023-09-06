import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, cnt = 0, max=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		v=new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		run(0);
		System.out.println(max);
	}
	private static void run(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					run(cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	private static void bfs() {
		int[][] newmap=new int[N][M];
		Queue<Node> q = new LinkedList<Node>();
		int count=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newmap[i][j]=map[i][j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newmap[i][j]==2) {
					q.add(new Node(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Node temp=q.poll();
				for (int d = 0; d < 4; d++) {
					int nr=temp.r+dr[d];
					int nc=temp.c+dc[d];
					if(isChecked(nr,nc) && newmap[nr][nc]==0) {
						newmap[nr][nc]=2;
						q.add(new Node(nr,nc));
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newmap[i][j]==0) {
					count++;
				}
			}
		}
		if(count>max) {
			max=count;
		}
		return;
	}

	private static boolean isChecked(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

	public static class Node{
		int r; 
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
