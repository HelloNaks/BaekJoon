import java.util.*;

public class BJ11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        int[][] arr = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]) {
                visited[i]=true;
                dfs(i, N, visited, arr);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int a, int N, boolean[] visited, int[][] arr){
        for(int i=1;i<=N;i++){
            if(!visited[i] && arr[a][i]==1){
                visited[i]=true;
                dfs(i,N,visited, arr);
            }
        }
    }
}
