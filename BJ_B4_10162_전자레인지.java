import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T=scann.nextInt();
		int a=300;
		int b=60;
		int c=10;
		int a_num=0;
		int b_num=0;
		int c_num=0;
		while(true) {
			if(T>=a) {
				a_num++;
				T-=a;
			}else if(T>=b) {
				b_num++;
				T-=b;
			}else if(T>=c) {
				c_num++;
				T-=c;
			}else if(T==0) {
				System.out.println(a_num+" "+b_num+" "+c_num);
				break;
			}else if(T<c){
				System.out.println(-1);
				break;
			}
		}
	}
}
