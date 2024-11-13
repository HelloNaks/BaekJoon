import java.io.*;
import java.util.*;

public class BJ2667 {
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> answer;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        answer = new ArrayList<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    static void bfs(int r, int c) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        visited[r][c]=true;

        while(!q.isEmpty()){
            Node temp = q.poll();
            for(int d=0;d<4;d++){
                int nr = temp.r+dr[d];
                int nc = temp.c+dc[d];
                if(isChecked(nr,nc)){
                    if(!visited[nr][nc] && arr[nr][nc]==1){
                        cnt++;
                        q.add(new Node(nr,nc));
                        visited[nr][nc]=true;
                    }
                }
            }
        }

        answer.add(cnt);
    }
    static boolean isChecked(int nr, int nc){
        return nr>=0 && nc>=0 && nr<N && nc<N;
    }
    static class Node{
        int r;
        int c;
        Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
