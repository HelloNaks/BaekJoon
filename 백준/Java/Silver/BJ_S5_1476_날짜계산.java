import java.util.Scanner;

public class Main {

	static int E = 15;
	static int S = 28;
	static int M = 19;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int e=scann.nextInt();
		int s=scann.nextInt();
		int m=scann.nextInt();
		int ee = 1;
		int ss = 1;
		int mm = 1;
		int count=1;
		while(true) {
			if(ee==e && ss==s && mm==m) {
				System.out.println(count);
				return;
			}
			ee++;
			ss++;
			mm++;
			count++;
			if(ee>15) {
				ee=1;
			}
			if(ss>28) {
				ss=1;
			}
			if(mm>19) {
				mm=1;
			}
		}
	}

}
