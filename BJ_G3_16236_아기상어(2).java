import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dist;
	static int[][] map;
	static int N, cnt = 0;
	static Shark shark = new Shark();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int pr, pc, min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean first = false;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					first = true;
				}
				if(map[i][j]==9) {
					shark = new Shark();
					shark.r=i;
					shark.c=j;
					map[i][j]=0;
				}
			}
		}
		
		// 1이 하나도 없을 경우
		if(!first) {
			System.out.println(0);
			return;
		}
		
		// 1이 하나라도 있을 경우
		while(true) {
			pr=Integer.MAX_VALUE;
			pc=Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			dist = new int[N][N];
			
			bfs(shark.r,shark.c);
			if(pr!=Integer.MAX_VALUE && pc != Integer.MAX_VALUE) {
				map[pr][pc]=0;
				shark.r=pr;
				shark.c=pc;
				shark.ate++;
				cnt += min;
				
				
				if(shark.ate==shark.size) {
					shark.ate=0;
					shark.size++;
				}
			}else {
				break;
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int r, int c) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Node temp = q.poll();
				for(int d=0;d<4;d++) {
					int nr = temp.r+dr[d];
					int nc = temp.c+dc[d];
					if(isChecked(nr,nc) && dist[nr][nc] == 0 && map[nr][nc]<=shark.size) {
						dist[nr][nc] = dist[temp.r][temp.c] + 1;
						q.add(new Node(nr, nc));
						if(map[nr][nc]<shark.size && map[nr][nc]!=0) {
							if(dist[nr][nc]<min) {
								min=dist[nr][nc];
								pr=nr;
								pc=nc;
							}else if(dist[nr][nc]==min) {
								if(pr==nr) {
									if(pc>nc) {
										pc=nc;
										pr=nr;
									}
								} else if(pr>nr) {
									pr=nr;
									pc=nc;
								}
							}
						}
					}
				}
			}
		}
	}

	private static boolean isChecked(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	public static class Shark{
		int r;
		int c;
		int size;
		int ate;
		
		public Shark() {
			super();
			this.size=2;
			this.ate=0;
		}
		
	}
	public static class Node{
		int r;
		int c;
		int dir;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Node(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
}
