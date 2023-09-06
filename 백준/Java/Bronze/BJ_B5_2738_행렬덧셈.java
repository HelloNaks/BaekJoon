import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int M=scann.nextInt();
		int[][] A=new int[N][M];
		int[][] B=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				A[i][j]=scann.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				B[i][j]=scann.nextInt();
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				A[i][j]+=B[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

}
