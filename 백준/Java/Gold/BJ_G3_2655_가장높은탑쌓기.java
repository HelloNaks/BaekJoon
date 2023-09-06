import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		int[] dp = new int[N+1];
		Brick[] b = new Brick[N+1];
		b[0]=new Brick(0,0,0,0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			b[i+1] = new Brick(i + 1,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(b, new Comparator<Brick>() {

			@Override
			public int compare(Brick b1, Brick b2) {
				return b1.under - b2.under;
			}
		});

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (b[j].w < b[i].w) {
					dp[i] = Math.max(dp[i], dp[j] + b[i].h);
				}
			}
		}

		int max_h=-1;
		for(int i=0;i<=N;i++) {
			if(max_h<dp[i])max_h=dp[i];
		}
		
		int temp=N;
		while(temp!=0) {
			if(max_h==dp[temp]) {
				stack.add(b[temp].idx);
				max_h-=b[temp].h;
			}
			temp--;
		}

		System.out.println(stack.size());
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.println(stack.pop());
		}
	}

	public static class Brick {
		int idx;
		int under;
		int h;
		int w;

		public Brick(int idx, int under, int h, int w) {
			super();
			this.idx = idx;
			this.under = under;
			this.h = h;
			this.w = w;
		}
	}
}
