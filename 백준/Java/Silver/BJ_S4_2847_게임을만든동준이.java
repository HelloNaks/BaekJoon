import java.util.Scanner;

public class Main {

	static int N, end, answer=0;
	static int[] lv;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		lv=new int[N];
		for (int i = 0; i < N; i++) {
			lv[i]=scann.nextInt();
		}
		end = lv[N-1];
		for (int i = N-2; i >= 0; i--) {
			if(end <= lv[i]) {
				answer += lv[i] - end + 1;
				lv[i]=end-1;
			}
			end = lv[i];
		}
		System.out.println(answer);
	}

}
