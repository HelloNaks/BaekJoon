import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int a=scann.nextInt();
		int b=scann.nextInt();
		int c=scann.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(a);
		pq.add(b);
		pq.add(c);
		pq.poll();
		System.out.println(pq.poll());
	}
}
