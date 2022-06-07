import java.util.Scanner;

public class Main {

	static int N;
	static int max=Integer.MIN_VALUE;
	static int[] arr;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		arr= new int[N];
		numbers=new int[N];
		visited=new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if(cnt==N) {
			int answer=0;
			for(int i=0;i<N-1;i++) {
				answer+=Math.abs(numbers[i]-numbers[i+1]);
			}
			max = Math.max(max, answer);
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				numbers[cnt]=arr[i];
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}
}
