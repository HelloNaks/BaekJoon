import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int max=0;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(Math.abs(arr[i])>max) {
				max=Math.abs(arr[i]);
			}
		}
		Arrays.sort(arr);
		
		Queue<Integer> p = new LinkedList<Integer>();
		Queue<Integer> m = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			if(arr[i]<0) {
				m.add(arr[i]);
			}
		}
		for(int i=N-1;i>=0;i--) {
			if(arr[i]>0) {
				p.add(arr[i]);
			}
		}
		while(!p.isEmpty()) {
			int a=p.poll();
			
			for(int i=1;i<K;i++) {
				p.poll();
				if(p.isEmpty()) {
					break;
				}
			}
			answer += 2*a;
		}
		while(!m.isEmpty()) {
			int a=m.poll();
			
			for(int i=1;i<K;i++) {
				m.poll();
				if(m.isEmpty()) {
					break;
				}
			}
			answer += 2*Math.abs(a);
		}
		
		answer-=max;
		System.out.println(answer);
	}
}
