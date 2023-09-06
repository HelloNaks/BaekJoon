import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static int answer=0;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		run(0);
		System.out.println(answer);
	}
	private static void run(int cnt) {
		if(cnt==N) {
			answer++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			arr[cnt]=i;
			if(isChecked(cnt)) {
				run(cnt+1);
			}
		}
	}
	private static boolean isChecked(int cnt) {
		for(int i=0;i<cnt;i++) {
			if(arr[cnt] == arr[i]) {
				return false;
			}
			else if(Math.abs(cnt-i)==Math.abs(arr[cnt] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
