import java.util.*;

public class BJ7576 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = -1;
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1){
                    q.add(new Node(i,j));
                    visited[i][j]=true;
                }
            }
        }

        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                for(int d=0;d<4;d++){
                    int nr = temp.r+dr[d];
                    int nc = temp.c+dc[d];
                    if(isChecked(nr,nc)){
                        if(!visited[nr][nc] && arr[nr][nc]==0){
                            visited[nr][nc]=true;
                            arr[nr][nc]=1;
                            q.add(new Node(nr,nc));
                        }
                    }
                }
            }
            answer++;
        }

        boolean flag = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    flag=true;
                }
            }
        }
        if(flag) System.out.println(-1);
        else System.out.println(answer);
    }
    static boolean isChecked(int nr, int nc){
        return nr>=0 && nc>=0 && nr<N && nc<M;
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
