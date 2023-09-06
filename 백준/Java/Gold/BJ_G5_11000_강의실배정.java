import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N=Integer.parseInt(br.readLine());
		Class[] cl = new Class[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			cl[i]=new Class(start, end);
		}
		
		Arrays.sort(cl, new Comparator<Class>() {
			@Override
			public int compare(Class c1, Class c2) {
				if(c1.start==c2.start) return c1.end-c2.end;
				return c1.start-c2.start;
			}
		});
		
		q.offer(cl[0].end);
		
		for(int i=1;i<N;i++) {
			if(q.peek()<=cl[i].start) {
				q.poll();
			}
			q.offer(cl[i].end);
		}
		System.out.println(q.size());
	}
	
	public static class Class{
		int start;
		int end;
		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}
