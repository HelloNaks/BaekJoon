import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int answer = 0;
	static int[][] map;
	static int N, M;
	static boolean[] v;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		v = new boolean[N*M];
		map = new int[N][M];
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 1)번 과정
		run(0,0);
		
		System.out.println(answer);
	}
	
	// 백트래킹 함수
	public static void run(int start, int cnt) {
		if(cnt==3) {		//벽을 3개 세웠을 때
			arr = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					arr[i][j]=map[i][j];
				}
			}
			
			// 벽 세우기
			for(int i=0;i<N*M;i++) {
				if(v[i]) {
					int div = i/M;
					int mod = i%M;
					arr[div][mod]=1;
				}
			}
			
			// 2)번 과정
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]==2 && !visited[i][j]) {
						bfs(i,j,visited);
					}
				}
			}
			
			// 3)번 과정
			int count=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]==0) {
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
			return;
		}
		
		for(int i=start;i<N*M;i++) {
			int div = i / M;
			int mod = i % M;
			if(!v[i] && map[div][mod]==0) {
				v[i]=true;
				run(i+1,cnt+1);
				v[i]=false;
			}
		}
	}
	
	public static void bfs(int r, int c, boolean[][] visited) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		visited[r][c]=true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Node temp = q.poll();
				for(int d=0;d<4;d++) {
					int nr=temp.r+dr[d];
					int nc=temp.c+dc[d];
					if(isChecked(nr,nc) && !visited[nr][nc] && arr[nr][nc]==0) {
						arr[nr][nc]=2;
						visited[nr][nc]=true;
						q.add(new Node(nr,nc));
					}
				}
			}
		}
	}
	//행렬 내의 범위일 때 true 값 // 아닐 때 false 값
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
