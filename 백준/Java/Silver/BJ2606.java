import java.util.*;

public class BJ2606 {
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }

        visited[1]=true;
        dfs(1, N, visited, arr);

        System.out.println(cnt);
    }
    
    public static void dfs(int p, int N, boolean[] visited, int[][] arr) {
        for(int i=1;i<=N;i++){
            if(arr[p][i]==1 && !visited[i]){
                cnt++;
                visited[i]=true;
                dfs(i, N, visited, arr);
            }
        }
    }
}
