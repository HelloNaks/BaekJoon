import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, L, answer=1, st;
	static int[] tape;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		L=scann.nextInt();
		tape=new int[N];
		for (int i = 0; i < N; i++) {
			tape[i]=scann.nextInt();
		}
		Arrays.sort(tape);
		
		st=tape[0];
		for (int i = 1; i < N; i++) {
			if(st+L-1 < tape[i]) {
				st=tape[i];
				answer++;
			}
		}
		System.out.println(answer);
	}

}
