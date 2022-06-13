import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n=0;
		int N=scann.nextInt();
		int[] arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		int num=scann.nextInt();
		for(int i=0;i<N;i++) {
			if(arr[i]==num) {
				n++;
			}
		}
		System.out.println(n);
	}
}
