import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine();
		String[] num = s.split(" ");
		int min=0;
		int max=0;
		
		num[0] = num[0].replace("6", "5");
		int a = Integer.parseInt(num[0]);
		num[1] = num[1].replace("6", "5");
		int b = Integer.parseInt(num[1]);
		
		num[0] = num[0].replace("5", "6");
		int c = Integer.parseInt(num[0]);
		num[1] = num[1].replace("5", "6");
		int d = Integer.parseInt(num[1]);
		min=a+b;
		max=c+d;
		System.out.println(min+" "+max);
		
	}

}
