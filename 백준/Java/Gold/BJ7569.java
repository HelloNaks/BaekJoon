import java.io.*;
import java.util.*;

public class BJ7569 {

    public static int[] dh = {0,0,0,0,1,-1};
    public static int[] dn = {1,0,-1,0,0,0};
    public static int[] dm = {0,1,0,-1,0,0};

    static int M, N, H;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        int[][][] arr = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];

        Queue<Node> q = new LinkedList<>();

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    arr[h][n][m]=sc.nextInt();
                    if(arr[h][n][m]==1){
                        visited[h][n][m]=true;
                        q.add(new Node(h,n,m));
                    }
                }
            }
        }

        int answer = -1;
        while(!q.isEmpty()){
            answer++;
            int size = q.size();
            for(int i=0;i<size;i++){
                Node temp = q.poll();
                for(int d=0;d<6;d++){
                    int nh =temp.h+dh[d];
                    int nn = temp.n+dn[d];
                    int nm = temp.m+dm[d];
                    if(isChecked(nh,nn,nm)){
                        if(!visited[nh][nn][nm]){
                            if(arr[nh][nn][nm]==0){
                                arr[nh][nn][nm]=1;
                                visited[nh][nn][nm]=true;
                                q.add(new Node(nh,nn,nm));
                            }
                        }
                    }
                }
            }

        }

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(arr[h][n][m]==0){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }
    public static boolean isChecked(int nh,int nn, int nm){
        return nh>=0 && nn>=0 && nm>=0 && nh<H && nn<N && nm<M;
    }

    public static class Node {
        int h;
        int n;
        int m;

        public Node(int h, int n, int m){
            this.h=h;
            this.n=n;
            this.m=m;
        }
    }
}
