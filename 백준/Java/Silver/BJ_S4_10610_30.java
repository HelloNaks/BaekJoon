import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String N=scann.next();
		StringBuilder sb = new StringBuilder();
		if(!N.contains("0")) {
			System.out.println(-1);
			return;
		}else {
			int sum=0;
			for(int i=0;i<N.length();i++) {
				sum+=(int)N.charAt(i)-'0';
			}
			if(sum%3!=0) {
				System.out.println(-1);
				return;
			}
			char[] ch = N.toCharArray();
			Arrays.sort(ch);
			
			for(int i=0;i<N.length();i++) {
				sb.append(ch[N.length()-i-1]);
			}
		}
		System.out.println(sb);
	}

}
