import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 1. x,y와 d1, d2를 정한다.
	 */
	static int N;
	static int[][] map;
	static int[] sum;
	static int min = Integer.MAX_VALUE;
	static int totalNum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		sum = new int[5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalNum+=map[i][j];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (r + d1 + d2 >= N)
							continue;
						if (c - d1 < 0 || c + d2 >= N)
							continue;
						boolean[][] arr = new boolean[N][N];
//						if(d1<1 || d2<1 || r<1 || r>=r+d1+d2 || 1>c-d1 || c-d1>=c || c>=c+d2 || c+d2>N)
						// continue;
						// 5번 선거구
						for (int k = 0; k <= d1; k++) {
							arr[r + k][c - k] = true;
							arr[r + d2 + k][c + d2 - k] = true;
						}
						for (int k = 0; k <= d2; k++) {
							arr[r + k][c + k] = true;
							arr[r + d1 + k][c - d1 + k] = true;
						}
						sum=new int[5];

						for(int i=0;i<r+d1;i++) {
							for(int j=0;j<=c;j++) {
								if(arr[i][j]) break;
								sum[0]+=map[i][j];
							}
						}
						
						for(int i=0;i<=r+d2;i++) {
							for(int j=N-1;j>c;j--) {
								if(arr[i][j]) break;
								sum[1]+=map[i][j];
							}
						}
						
						for(int i=r+d1;i<N;i++) {
							for(int j=0;j<c-d1+d2;j++) {
								if(arr[i][j]) break;
								sum[2]+=map[i][j];
							}
						}
						
						for(int i=r+d2+1;i<N;i++) {
							for(int j=N-1;j>=c-d1+d2;j--) {
								if(arr[i][j]) break;
								sum[3]+=map[i][j];
							}
						}
						
						sum[4]=totalNum;
						
						for(int i=0;i<4;i++) {
							sum[4]-=sum[i];
						}
						
						Arrays.sort(sum);
						min = Math.min(min, sum[4] - sum[0]);
					}
				}
			}
		}
		
		System.out.println(min);
	}
}
