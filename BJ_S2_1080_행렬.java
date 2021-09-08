import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer=0;
	static int[][] A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		A=new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] ch = s.toCharArray();
			for (int j = 0; j < M; j++) {
				A[i][j]=ch[j]-'0';
			}
		}
		B=new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] ch = s.toCharArray();
			for (int j = 0; j < M; j++) {
				B[i][j]=ch[j]-'0';
			}
		}
		
		Solution();
		if(!isSame(A,B)) {
			answer= -1;
		}
		System.out.println(answer);
		
	}
	private static void Solution() {
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if(A[i][j]!= B[i][j]) {
					Change(i,j);
					answer++;
				}
			}
		}
	}
	private static void Change(int i, int j) {
		for (int i2 = i; i2 < i+3; i2++) {
			for (int j2 = j; j2 < j+3; j2++) {
				if(A[i2][j2]==0) {
					A[i2][j2]=1;
				}else {
					A[i2][j2]=0;
				}
			}
		}
	}
	
	private static boolean isSame(int[][] a2, int[][] b2) {
		for(int i=0;i<N;i++) {
			for (int j = 0; j < M; j++) {
				if(a2[i][j]!=b2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
