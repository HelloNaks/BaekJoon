import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static int a, b, c;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		arr=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=scann.nextInt();
		}
		for (int i = 0; i < M; i++) {
			a=scann.nextInt();
			b=scann.nextInt();
			c=scann.nextInt();
			calc(a, b, c);
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static void calc(int x, int y, int z) {
		switch(x) {
		case 1:
			arr[y-1]=z;
			break;
		case 2:
			for(int i=y-1;i<z;i++) {
				if(arr[i]==1)
					arr[i]=0;
				else
					arr[i]=1;
			}
			break;
		case 3:
			for(int i=y-1;i<z;i++) {
				arr[i]=0;
			}
			break;
		case 4:
			for(int i=y-1;i<z;i++) {
				arr[i]=1;
			}
			break;
		}
	}
}
