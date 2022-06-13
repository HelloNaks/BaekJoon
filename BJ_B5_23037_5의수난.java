import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.next();
		int answer=0;
		for(int i=0;i<5;i++) {
			answer += Math.pow((s.charAt(i)-'0'),5);
		}
		System.out.println(answer);
	}
}
