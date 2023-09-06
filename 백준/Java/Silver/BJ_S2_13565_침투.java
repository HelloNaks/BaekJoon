import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m, n;
	static boolean[][] v;
	static int [][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		map=new int[m][n];
		v = new boolean[m][n];
		for(int i=0;i<m;i++) {
			char[] ch=br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j]=ch[j]-'0';
			}
		}
		for(int i=0;i<n;i++) {
			if(map[0][i]==0) {
				bfs(i);
			}
		}
		for(int i=0;i<n;i++) {
			if(v[m-1][i]) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
		return;
	}
	private static void bfs(int c) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,c));
		v[0][c]=true;
		while(!q.isEmpty()) {
			Node temp = q.poll();
			for(int d=0;d<4;d++) {
				int nr = temp.r+dr[d];
				int nc = temp.c+dc[d];
				if(isChecked(nr,nc) && !v[nr][nc] && map[nr][nc]==0) {
					q.add(new Node(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
	}
	
	private static boolean isChecked(int nr, int nc) {
		return nr>=0 && nr<m && nc>=0 && nc<n;
	}

	private static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
