import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MAX=Integer.MIN_VALUE;
	static int MIN=Integer.MAX_VALUE;
	static int N;
	static int[] arr, calc;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr= new int[N];
		calc= new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			calc[i]=Integer.parseInt(st.nextToken());
		}
		
		nCr(1,arr[0]);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	private static void nCr(int cnt, int num) {
		if(cnt==N) {
			MAX = Math.max(num, MAX);
			MIN = Math.min(num, MIN);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(calc[i]>0) {
				calc[i]--;
				switch(i) {
				case 0: nCr(cnt+1, num + arr[cnt]);	break;
				case 1: nCr(cnt+1, num - arr[cnt]);	break;
				case 2: nCr(cnt+1, num * arr[cnt]);	break;
				case 3: nCr(cnt+1, num / arr[cnt]);	break;
				}
				calc[i]++;
			}
		}
	}
}
