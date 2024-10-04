import java.util.*;

public class BJ1260 {

    public static int[][] arr;
    public static boolean[] visited;
    public static int N, M, V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // dfs
        System.out.print(V+" ");
        visited[V]=true;
        dfs(V);

        // 초기화
        visited = new boolean[N+1];
        System.out.println();

        //bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V]=true;
        System.out.print(V+" ");

        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i=1;i<=N;i++){
                if(arr[temp][i]==1 && i!=temp) {
                    if (!visited[i]){
                        visited[i]=true;
                        q.add(i);
                        System.out.print(i+" ");
                    }
                }
            }
        }
    }

    public static void dfs(int V) {
        for(int i=1;i<=N;i++){
            if(arr[V][i]==1 && i!=V){
                if(!visited[i]){
                    System.out.print(i+" ");
                    visited[i]=true;
                    dfs(i);
                }
            }
        }
    }
}
