import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, Q, length;
	static int[][] arr;
	static int[] len;
	static int max_length = Integer.MIN_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		length = (int) Math.pow(2, N);
		arr = new int[length][length];
		len = new int[Q];
		for (int i = 0; i < length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			len[i] = Integer.parseInt(st.nextToken());
			len[i] = 1 << len[i];
		}
		
		for (int i = 0; i < Q; i++) {
			arr = tornado(len[i]);
			melt();
		}
		
		// 얼음 남은 개수
		int ice_left = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (arr[i][j] >= 0) {
					ice_left += arr[i][j];
				}
			}
		}

		largest();
		
		System.out.println(ice_left+"\n"+max_length);
	}

	private static void largest() {
		boolean[][] visited= new boolean[length][length];
		for(int r=0;r<length;r++) {
			for(int c=0;c<length;c++) {
				if(visited[r][c]) continue;
				int cnt=0;
				Queue<Node> q = new LinkedList<>();
				q.add(new Node(r,c));
				while(!q.isEmpty()) {
					Node temp = q.poll();
					for(int d=0;d<4;d++) {
						int nr=temp.r+dr[d];
						int nc=temp.c+dc[d];
						if(nr<0 || nr>=length || nc<0 || nc>=length) continue;
						if(visited[nr][nc] || arr[nr][nc]<=0) continue;
						visited[nr][nc]=true;
						cnt++;
						q.add(new Node(nr,nc));
					}
					max_length=Math.max(max_length, cnt);
				}
			}
		}
	}
	
	private static void melt() {
		boolean[][] visited = new boolean[length][length];
		
		for(int r=0;r<length;r++) {
			for(int c=0;c<length;c++) {
				int cnt=0;
				if(arr[r][c]==0) continue;
				for(int d=0;d<4;d++) {
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(nr<0 || nr>=length || nc<0 || nc>=length) continue;
					if(arr[nr][nc]<=0) continue;
					cnt++;
				}
				if(cnt<3) visited[r][c]=true;
			}
		}
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(visited[i][j]) arr[i][j]--;
			}
		}
	}

	public static int[][] tornado(int distance) {

		int[][] result = new int[length][length];

		for (int startRow = 0; startRow < length; startRow += distance) {
			for (int startCol = 0; startCol < length; startCol += distance) {
				for (int i = 0; i < distance; i++) {
					for (int j = 0; j < distance; j++) {
						result[startCol + i][startRow + j] = arr[startCol + distance - 1 - j][startRow + i];
					}
				}
			}
		}

		return result;
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
