import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		Queue<Integer> q = new PriorityQueue<>();
		int num=0;
		for(int i=0;i<N;i++) {
			q.add(scann.nextInt());
		}
		while(q.size()>=2) {
			int a=q.poll();
			int b=q.poll();
			q.add(a+b);
			num+=a+b;
		}
		System.out.println(num);
	}
}
