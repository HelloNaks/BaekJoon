import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, x,y,K;
	static int[][] arr;
	static int[] K_arr;
	static int[] dice = new int[7];
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//첫째 줄 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		K_arr=new int[K];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//마지막 줄 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			K_arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			int nr = x + dr[K_arr[i]-1];
			int nc = y + dc[K_arr[i]-1];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				roll(K_arr[i]);
				if(arr[nr][nc]==0) {
					arr[nr][nc]=dice[6];
				}else {
					dice[6] = arr[nr][nc];
					arr[nr][nc]=0;
				}
				x=nr;
				y=nc;
				sb.append(dice[1]).append("\n");
			}
			
		}
		System.out.println(sb.toString());
	}
	private static void roll(int d) {
		int[] temp = dice.clone();
		if(d==1) {
			dice[3]=temp[1];
			dice[6]=temp[3];
			dice[4]=temp[6];
			dice[1]=temp[4];
		}else if(d==2) {
			dice[4]=temp[1];
			dice[6]=temp[4];
			dice[3]=temp[6];
			dice[1]=temp[3];
		}else if(d==3) {
			dice[2]=temp[1];
			dice[6]=temp[2];
			dice[5]=temp[6];
			dice[1]=temp[5];
		}else{
			dice[5]=temp[1];
			dice[6]=temp[5];
			dice[2]=temp[6];
			dice[1]=temp[2];
		}
	}

}
