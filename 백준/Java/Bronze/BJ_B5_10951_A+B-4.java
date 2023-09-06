import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		while(scann.hasNextInt()) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			System.out.println(a+b);
		}
	}

}
