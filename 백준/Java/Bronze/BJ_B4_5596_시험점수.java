import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int[] minguk=new int[4];
		int minguk_total=0;
		int[] manse=new int[4];
		int manse_total=0;
		for(int i=0;i<4;i++) {
			minguk[i]=scann.nextInt();
			minguk_total+=minguk[i];
		}
		for(int i=0;i<4;i++) {
			manse[i]=scann.nextInt();
			manse_total+=manse[i];
		}
		System.out.println(minguk_total>manse_total?minguk_total:manse_total);
	}
}
