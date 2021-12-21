import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static long answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=1;i<=N;i++) {
			answer += Math.abs(arr[i]-i);
		}
		System.out.println(answer);
	}
}
