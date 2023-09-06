import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int a=scann.nextInt();
		int b=scann.nextInt();
		int c=scann.nextInt();
		
		int [] ans= new int[10];
		long result = a*b*c;
		String s = Long.toString(result);
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++) {
			ans[ch[i]-'0']++;
		}
		for(int i=0;i<10;i++) {
			System.out.println(ans[i]);
		}
	}
}
