import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2178 {
    public static int N, M;
    public static int[][] arr;
    public static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j] - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node tem = q.poll();
            if (tem.r == N - 1 && tem.c == M - 1) {
                System.out.println(tem.val);
                break;
            }

            for(int d=0;d<4;d++){
                int nr = tem.r+dr[d];
                int nc = tem.c+dc[d];
                if(isChecked(nr,nc)){
                    if(!visited[nr][nc] && arr[nr][nc]==1){
                        q.add(new Node(nr,nc,tem.val+1));
                        visited[nr][nc]=true;
                    }
                }
            }
        }
    }

    public static boolean isChecked(int nr, int nc){
        return nr>=0 && nc>=0 && nr<N && nc<M;
    }

    public static class Node {
        int r;
        int c;
        int val;

        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
}
