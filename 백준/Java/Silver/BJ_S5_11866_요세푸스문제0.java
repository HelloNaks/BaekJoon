import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int K=scann.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		int num=0;
		int cnt=0;
		boolean[] visited=new boolean[N+1];
		System.out.print("<");
		while(!q.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				int val = q.poll();
				q.offer(val);
			}
			if(cnt==0) {
				System.out.print(q.poll());
			}else {
				System.out.print(", "+q.poll());
			}
			cnt++;
		}
		System.out.print(">");
	}

}
