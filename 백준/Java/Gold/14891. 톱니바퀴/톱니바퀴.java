import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		arr = new int[4][8];
		int answer=0;
		for(int i=0;i<4;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<8;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0])-1;
			int dir = Integer.parseInt(s[1]);
			run(num,dir);
		}
		for(int j=0;j<4;j++) {
			if(arr[j][0]==1) {
				answer += Math.pow(2, j);
			}
		}
		System.out.println(answer);
		
	}
	private static void run(int num, int dir) {
		left(num-1,-dir);
		right(num+1,-dir);
		rotate(num,dir);
	}
	private static void rotate(int num, int dir) {
		if(dir==1) {
			int temp = arr[num][7];
			for(int i=7;i>0;i--) {
				arr[num][i]=arr[num][i-1];
			}
			arr[num][0]=temp;
		}else {
			int temp = arr[num][0];
			for(int i=0;i<7;i++) {
				arr[num][i]=arr[num][i+1];
			}
			arr[num][7]=temp;
		}
	}
	private static void right(int num, int dir) {
		if(num>3) return;
		if(arr[num][6]==arr[num-1][2]) return;
		right(num+1,-dir);
		rotate(num,dir);
	}
	private static void left(int num, int dir) {
		if(num<0) return;
		if(arr[num][2]==arr[num+1][6]) return;
		left(num-1,-dir);
		rotate(num,dir);
	}
}
