import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		Room[] rooms = new Room[N];
		for(int i=0;i<N;i++) {
			int start=scann.nextInt();
			int end=scann.nextInt();
			rooms[i]=new Room(start, end);
		}
		
		Arrays.sort(rooms, (r1, r2) -> r1.start == r2.start ? r1.end-r2.end : r1.start-r2.start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(rooms[0].end);
		for(int i=1;i<N;i++) {
			if(pq.peek()<=rooms[i].start) {
				pq.poll();
			}
			pq.offer(rooms[i].end);
		}
		System.out.println(pq.size());
	}
	
	public static class Room{
		int start;
		int end;
		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}
