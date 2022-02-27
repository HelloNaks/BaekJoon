import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, left=0, right=0;
	static int[] arr;
	static int add_all=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		arr=new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<W-1;i++) {
			left=0;
			right=0;
			for(int j=0;j<i;j++) {
				left=Math.max(arr[j], left);
			}
			for(int j=i+1;j<W;j++) {
				right=Math.max(arr[j], right);
			}
			if(arr[i]<left && arr[i]<right) {
				int less_max=right>left?left:right;
				add_all+=less_max-arr[i];
			}
		}
		System.out.println(add_all);
	}
}
