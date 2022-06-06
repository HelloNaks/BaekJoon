import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		long answer=0;
		int N=scann.nextInt();
		long[] roads = new long[N-1];
		long[] cities = new long[N];
		for(int i=0;i<N-1;i++) {
			roads[i]=scann.nextLong();
		}
		for(int i=0;i<N;i++) {
			cities[i]=scann.nextLong();
		}
		for(int i=0;i<N-1;i++) {
			if(cities[i]<cities[i+1]) {
				cities[i+1]=cities[i];
			}
		}
		for(int i=0;i<N-1;i++) {
			answer+=cities[i]*roads[i];
		}
		System.out.println(answer);
	}
}
