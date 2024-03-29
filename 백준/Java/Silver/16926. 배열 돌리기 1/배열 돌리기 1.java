import java.util.Scanner;

public class Main {

	static int N, M, R;
	static int[][] A;
	static int[][] v;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static int K;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		R=scann.nextInt();
		// N과 M중 작은 것의 절반만큼 반복하게 된다.
		K= N>M?M/2:N/2;
		A=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j]=scann.nextInt();
			}
		}	
		for(int rot=0;rot<R;rot++) {
			for(int boundary=0;boundary<K;boundary++) {
				int r=boundary;
				int c =boundary;
				int d=0;
				int temp=A[r][c];
				while(d<4){
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(nr>=boundary && nr<N-boundary
							&& nc>=boundary && nc<M-boundary) {
						A[r][c]=A[nr][nc];
						r=nr;
						c=nc;
					}else {
						d++;
					}
				}
				A[boundary+1][boundary]=temp;
			}
		}

		print();
		
	}


	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

}
