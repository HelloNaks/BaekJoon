import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int answer = 0;
	public static void main(String[] args) {
		/**
		 * 1. 현재 위치 청소
		 * 2. 
		 * a. 왼쪽에 청소 안했으면 그방향으로 회전 후 전진
		 * b. 왼쪽에 청소할 곳 없으면 그 방향으로 회전 후 2번으로 돌아감
		 * c. 네 방향 모두 청소 되어있거나 벽이면 한칸 후진 후 2번으로 돌아감
		 * d. 후진까지 못한다면 작동 X
		 * 청소한 칸 청소 X
		 * 0은 청소할공간 1은 벽
		 */
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		int a=scann.nextInt();
		int b=scann.nextInt();
		int c=scann.nextInt();
		Node robot = new Node(a,b,c);
		arr=new int[N][M];
		// 배열 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j]=scann.nextInt();
			}
		}
		
		
		dfs(robot.r,robot.c,robot.dir);
		
		//마지막 출력 값
		System.out.println(answer);
	}
	private static void dfs(int r, int c, int dir) {
		// 2는 청소 된 공간
		// 1 조건
		if(arr[r][c]==0) {
			arr[r][c]=2;
			answer++;
		}
		// 2-a,b
		boolean flag = false;
		int origin = dir;
		for (int d = 0; d < 4; d++) {
			int nd = (dir+3)%4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(isChecked(nr, nc)) {
				if(arr[nr][nc]==0) {
					dfs(nr,nc,nd);
					flag=true;
					break;
				}
			}
			dir = (dir+3)%4;
		}
		// 2-c
		if(!flag) {
			int nd = (origin+2)%4;
			int nr = r+dr[nd];
			int nc = c+dc[nd];
			
			if(isChecked(nr,nc)) {
				if(arr[nr][nc] != 1) {
					dfs(nr,nc,origin);
				}
			}
		}
	}
	private static boolean isChecked(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
	static class Node{
		int r;
		int c;
		int dir;
		public Node(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
}
