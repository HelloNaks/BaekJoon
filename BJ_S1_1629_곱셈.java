import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static long C;
	
	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		long A=scann.nextLong();
		long B=scann.nextLong();
		C=scann.nextLong();
		
		System.out.println(pow(A, B));
	}

	private static long pow(long a, long b) {
		if(b == 1) {
			return a%C;
		}
		long temp = pow(a, b/2);
		if(b%2==1) {
			return ((temp * temp % C) * a % C);
		}
		return temp * temp % C;
	}

}
