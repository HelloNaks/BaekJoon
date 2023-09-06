import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		String[][] s = new String[N][5];
		for(int i=0;i<N;i++) {
			for(int j=0;j<5;j++) {
				s[i][j]=sc.nextLine();
			}
		}
		int[][] dif = new int[N][N];
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=0;k<5;k++) {
					for(int l=0;l<7;l++) {
						if(s[i][k].charAt(l)!=s[j][k].charAt(l)) {
							dif[i][j]++;
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int front = 0;
		int back = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(min>dif[i][j]) {
					min=dif[i][j];
					front = i;
					back = j;
				}
			}
		}
		System.out.println((front+1)+" "+(back+1));
	}
}
