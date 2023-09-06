import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int a=scann.nextInt();
		int b=scann.nextInt();
		int c=scann.nextInt();
		int d=scann.nextInt();
		int sum=a+b+c+d;
		int div=sum/60;
		int mod=sum%60;
		System.out.println(div+"\n"+mod);
	}

}
