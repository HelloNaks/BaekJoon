import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		for(int i=1;i<=N;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			System.out.println("Case #"+i+": "+(a+b));
		}
	}
}
