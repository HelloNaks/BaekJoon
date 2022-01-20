import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int testCase;      //테스트 케이스 수
	static int n, d, c;       //n : 컴퓨터 개수 / d : 의존성 개수 / c : 해킹당한 컴퓨터 번호
	static int[] distance;    //해당 노드까지의 거리
	static boolean[] visited; //해당 노드 방문여부
	static ArrayList<Computer>[] list; //해당 노드에서 출발하는 간선의 종류
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testCase=Integer.parseInt(br.readLine());
		for(int i=0;i<testCase;i++) {
			st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			distance=new int[n+1];
			visited=new boolean[n+1];
			
			for(int j=1;j<=n;j++) {
				distance[j]=Integer.MAX_VALUE;      //아직 연결되지 않았으므로 무한대 값
				list[j]=new ArrayList<>();
			}
			
			for(int j=0;j<d;j++) {
				st=new StringTokenizer(br.readLine());
				
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				list[b].add(new Computer(a,s));   
			}
			
			distance[c]=0;      //첫 시작점에서의 거리는 0
			dijkstra();
			
			int cnt=0;          //총 감염되는 컴퓨터 수
			int time=0;         //마지막 컴퓨터가 감염되기까지 걸리는 시간
			
			for(int j=1;j<=n;j++) {
				if(distance[j] != Integer.MAX_VALUE) {
					cnt++;
					time=Math.max(time, distance[j]);
				}
			}
			System.out.println(cnt+" "+time);
			
		}
	}

	private static void dijkstra() {
		PriorityQueue<Computer> queue = new PriorityQueue<>();
		queue.add(new Computer(c,0));       //첫번째 컴퓨터를 queue에 추가
		while(!queue.isEmpty()) {
			int cur = queue.poll().node;
			if(!visited[cur]) {
				visited[cur]=true;
				
				for(Computer next: list[cur]) {     //출발지를 cur 컴퓨터로 하는 노드들 반복
					if(distance[next.node] > distance[cur] + next.time) {     //현재까지 next까지의 거리가 최소가 아니라면(cur까지의 거리 + cur에서 next까지의 거리)
						distance[next.node] = distance[cur] + next.time;        //최솟값으로 변경
						queue.add(new Computer(next.node, distance[next.node])); // queue에 추가
					}
				}
			}
		}
	}

	public static class Computer implements Comparable<Computer>{
		int node;
		int time;
		public Computer(int node, int time) {
			super();
			this.node = node;
			this.time = time;
		}
		
		@Override
		public int compareTo(Computer com) {
			return this.time - com.time;
		}
		
	}
}
