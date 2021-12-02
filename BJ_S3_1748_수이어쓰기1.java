import java.util.Scanner;

public class Main {

	static int answer = 0;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int digit = 1;
		int count = 0;
		
		while(N>=digit) {
			answer = answer + (digit-digit/10)*count;
			digit *= 10;
			count++;
		}
		N -= digit/10-1;
		answer += N*count;
		
		System.out.println(answer);
	}
}
