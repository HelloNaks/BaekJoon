import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] diff;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		arr=new int[N];
		diff=new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N-1; i++) {
			diff[i]=arr[i+1]-arr[i];
		}
		Arrays.sort(diff);

		int answer=0;
		for(int i=0;i<N-K;i++) {
			answer+=diff[i];
		}
		System.out.println(answer);
	}
}
