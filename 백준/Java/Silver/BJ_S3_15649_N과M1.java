import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] path=new int[9];
	static boolean[] v=new boolean[9];
	public static void main(String[] args) {
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
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		run(0);
	}
	private static void run(int lev) {
		if(lev==M) {
			print();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(v[i]) continue;
			v[i]=true;
			path[lev]=i;
			run(lev+1);
			v[i]=false;
		}
	}
	private static void print() {
		for (int i = 0; i < M; i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
}
