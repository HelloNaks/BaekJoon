import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N, M;
        N=Integer.parseInt(s[0]);
        M=Integer.parseInt(s[1]);
        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=temp.charAt(j) - '0';
            }
        }
        bfs(0,0,N,M,arr,visited);

    }

    private static void bfs(int r, int c, int n, int m, int[][] arr, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c,1));
        visited[r][c]=true;

        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0;i<size;i++) {
                Node temp = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = temp.r + dr[d];
                    int nc = temp.c + dc[d];

                    if (nr == n - 1 && nc == m - 1) {
                        System.out.print(temp.cnt+1);
                        return;
                    }

                    if (isChecked(nr, nc, n, m) && !visited[nr][nc]) {
                        if (arr[nr][nc] == 1) {
                            q.add(new Node(nr, nc, temp.cnt + 1));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }

    private static boolean isChecked(int nr, int nc, int n, int m) {
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }


    private static class Node{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}
