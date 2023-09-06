import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n,s,m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[m+1];
		for(int i=0;i<m+1;i++) {
			arr[i]=-1;
		}
		arr[s]=0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int V=Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();
			
			for(int j=0;j<=m;j++) {
				if(arr[j] == i) {
					int result1=j+V;
					int result2=j-V;
					
					if(0<=result1 && result1<=m) {
						list.add(result1);
					}
					if(0<=result2 && result2<=m) {
						list.add(result2);
					}
				}
			}
			for(int j:list) {
				arr[j]=i+1;
			}
		}
		int max=-1;
		for(int i=0;i<=m;i++) {
			if(arr[i] == n) {
				max=Math.max(max, i);
			}
		}
		System.out.println(max);
	}
}
