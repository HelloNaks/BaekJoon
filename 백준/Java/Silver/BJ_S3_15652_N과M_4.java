import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] path=new int[9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		/*
		 * 1. 아이디어
		 * 백트래킹 재귀함수 안에서, for 돌면서 숫자 선택(이때 방문여부 확인)
		 * 재귀함수에서 M개를 선택할경우 print
		 * 2. 시간복잡도
		 * N! -> 가능
		 * 3. 자료구조
		 * 결과값 저장 int[]
		 * 방문여부 체크 bool[]
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		run(0, 1);
		System.out.println(sb);
	}
	private static void run(int lev, int start) {
		if(lev==M) {
			print();
			return;
		}
		for (int i = start; i <= N; i++) {
			path[lev]=i;
			run(lev+1, i);
		}
	}
	private static void print() {
		for (int i = 0; i < M; i++) {
			sb.append(path[i]).append(" ");
		}
		sb.append("\n");
	}
	
	
}
