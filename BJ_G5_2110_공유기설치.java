import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n, c;
	static int start, end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		start=1;
		end = arr[n-1] - arr[0] + 1;
		
		while(start<end) {
			int mid = (start+end)/2;
			if(count(mid) < c) {
				end=mid;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(start - 1);
	}

	private static int count(int mid) {
		int count = 1;
		int idx = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			int now = arr[i];
			
			if(now - idx >= mid) {
				count++;
				idx = now;
			}
		}
		return count;
	}
}
