import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		arr=new long[N];
		int K=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(arr[K-1]);
	}
}
