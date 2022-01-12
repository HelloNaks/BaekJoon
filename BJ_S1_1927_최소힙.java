import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int n = scann.nextInt();
		int val=0;
		for(int i=0;i<n;i++) {
			val=scann.nextInt();
			if(val!=0) {
				q.add(val);
			} else if(q.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.println(q.poll());
			}
		}
	}
}
