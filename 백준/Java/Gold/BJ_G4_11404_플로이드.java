import java.util.Scanner;

public class Main {

	static final int INF = 99999999;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int n=scann.nextInt();
		int m=scann.nextInt();
		int[][] dist=new int[n+1][n+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i != j && dist[i][j]==0) {
					dist[i][j]=INF;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			int a=scann.nextInt();
			int b=scann.nextInt();
			int c=scann.nextInt();
			dist[a][b] = Math.min(c, dist[a][b]);
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(k==i) {
					continue;
				}
				for(int j=1;j<=n;j++) {
					if(k==j || i==j) continue;
					if(dist[i][j]>dist[i][k] + dist[k][j]) {
						dist[i][j]=dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(dist[i][j]==INF) dist[i][j]=0;
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}

}
