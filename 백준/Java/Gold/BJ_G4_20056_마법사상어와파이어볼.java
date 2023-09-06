import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, answer = 0;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static ArrayList<Fire>[][] list;
	static ArrayList<Fire> li = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		/**
		 * 1. 모든 파이어볼 이동 (겹칠 수 있다. List형태로 여러개 저장)
		 * 2. 한 칸에 2개이상 있다면
		 *  1) 하나로 합쳐진다.
		 *  2) 4개로 나누어진다.
		 *  3) 질량 : 질량합/5
		 *  4) 속력 : 속력합/파이어볼개수
		 *  5) 파이어볼 방향 : 모두 홀 or 짝이면 짝수 / 아니면 홀수 방향
		 *  6) 질량 0이면 소멸
		 * 3. K번 반복 후 전체 파이어볼 질량의 합
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		list=new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				list[i][j]=new ArrayList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;	//행
			int c = Integer.parseInt(st.nextToken())-1;	//열
			int m = Integer.parseInt(st.nextToken());	//질량
			int s = Integer.parseInt(st.nextToken());	//속력
			int d = Integer.parseInt(st.nextToken());	//방향
			li.add(new Fire(r,c,m,s,d));
		}
		
		for(int k=0;k<K;k++) {
			move();
			run();
		}
		
		System.out.println(sum());
	}
	
	private static void run() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(list[i][j].size()==1) list[i][j].clear();
				if(list[i][j].size()<2) continue;
				int mSum=0;
				int sSum=0;
				boolean even = list[i][j].get(0).d%2==0?true:false;
				boolean odd = list[i][j].get(0).d%2==1?true:false;
				for(Fire f : list[i][j]) {
					mSum+=f.m;
					sSum+=f.s;
					even = even & f.d%2==0?true : false;
					odd = odd & f.d%2==1?true : false;
					li.remove(f);
				}
				int nMass = mSum/5;
				int size = list[i][j].size();
				list[i][j].clear();
				int nSpeed = sSum/size;
				if(nMass == 0) {
					continue;
				}
				 
				if(even | odd) {
					for(int k=0;k<8;k+=2) {
						li.add(new Fire(i,j,nMass,nSpeed, k));
					}
				}else {
					for(int k=1;k<8;k+=2) {
						li.add(new Fire(i,j,nMass,nSpeed,k));
					}
				}
			}
		}
	}

	private static void move() {
		
		for(Fire f : li) {
			int nr = (f.r + N + dr[f.d] * (f.s%N))%N;
			int nc = (f.c + N + dc[f.d] * (f.s%N))%N;
			f.r=nr;
			f.c=nc;
			list[nr][nc].add(f);
		}
	}

	private static int sum() {
		for(Fire f : li) {
			answer+=f.m;
		}
		return answer;
	}

	public static class Fire{
		int r;
		int c;
		int m;
		int s;
		int d;
		
		public Fire(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
}
