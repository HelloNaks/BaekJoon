import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T=scann.nextInt();
		for(int t=0;t<T;t++) {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			int K=scann.nextInt();
			for(int i=0;i<K;i++) {
				pq.add(scann.nextLong());
			}
			long sum=0;
			while(pq.size()>1) {
				long a=pq.poll();
				long b=pq.poll();
				sum+=a+b;
				pq.add(a+b);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
