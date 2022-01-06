import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr=new int[100001];
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for(int i=0;i<100001;i++) {
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}
