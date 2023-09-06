import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int M=scann.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		int start=0;
		int end=0;
		int temp=0;
		int answer=0;
		while(true) {
			if(temp>=M) {
				temp -= arr[start++];
			}else if(end>=N) {
				break;
			}else {
				temp+= arr[end++];
			}
			if(temp==M) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
