import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	/** N 도시 개수
	 *  M 도로 개수
	 *  K 거리 정보
	 *  X 출발 도시 번호
	*/
	static int N, M, K, X;
	static ArrayList<Integer>[] al;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		K=scann.nextInt();
		X=scann.nextInt();
		
		al=new ArrayList[N+1];
		for (int i = 0; i < al.length; i++) {
			al[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			al[scann.nextInt()].add(scann.nextInt());
		}
		
		for(int i=0;i<al.length;i++) {
			System.out.println(al[i]);
		}
		
		bfs(X);
	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		int[] check = new int[N+1];
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for (int i = 0; i < al[temp].size(); i++) {
				if(check[al[temp].get(i)]==0) {
					check[al[temp].get(i)] = check[temp]+1;
					q.add(al[temp].get(i));
				}
			}
		}
		
		boolean flag = false;
		for (int i = 1; i < check.length; i++) {
			if(check[i] == K && i != X) {
				flag = true;
				System.out.println(i);
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
		
	}

}
