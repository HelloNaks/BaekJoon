import java.util.*;
import java.io.*;

public class BJ10026 {
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int normalCnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j]) {
                    char now = arr[i][j];
                    normalCnt++;
                    visited[i][j]=true;
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i,j));

                    while(!q.isEmpty()){
                        Node temp = q.poll();
                        for(int d=0;d<4;d++){
                            int nr = temp.r+dr[d];
                            int nc = temp.c+dc[d];
                            if(isChecked(nr,nc,N)){
                                if(!visited[nr][nc]){
                                    if(arr[nr][nc]==now){
                                        q.add(new Node(nr,nc));
                                        visited[nr][nc]=true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='R'){
                    arr[i][j]='G';
                }
            }
        }

        int cnt = 0;
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!visited[i][j]) {
                    char now = arr[i][j];
                    cnt++;
                    visited[i][j]=true;
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i,j));

                    while(!q.isEmpty()){
                        Node temp = q.poll();
                        for(int d=0;d<4;d++){
                            int nr = temp.r+dr[d];
                            int nc = temp.c+dc[d];
                            if(isChecked(nr,nc,N)){
                                if(!visited[nr][nc]){
                                    if(arr[nr][nc]==now){
                                        q.add(new Node(nr,nc));
                                        visited[nr][nc]=true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(normalCnt +" "+cnt);
    }
    static boolean isChecked(int nr, int nc, int N){
        return nr>=0 && nc>=0 && nr<N && nc<N;
    }
    static class Node{
        int r;
        int c;

        Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
