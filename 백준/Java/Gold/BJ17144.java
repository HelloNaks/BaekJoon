import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class BJ17144 {
    static int R, C, T;
    static int[][] arr;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Node up_air, down_air;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        arr = new int[R][C];

        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                arr[r][c]=sc.nextInt();
                if(arr[r][c]==-1){
                    if(up_air!=null){
                        down_air = new Node(r,c);
                    }else{
                        up_air = new Node(r,c);
                    }
                }
            }
        }

        for(int t=0;t<T;t++){
            run();
        }
        int answer = 0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(arr[r][c]!=-1){
                    answer+=arr[r][c];
                }
            }
        }
        System.out.println(answer);
    }

    private static void run() {
        // 1. 미세먼지 확산
        spread();
//        print(arr);
//        System.out.println(up_air.r+" "+ up_air.c);
        // 2. 공기청정기 작동
        up_aircondition();
//        print(arr);
        down_aircondition();
//        print(arr);
    }

    private static void spread(){
        int[][] temp = new int[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(arr[r][c]!=0){
                    int flag = 0;
                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(isChecked(nr,nc)){
                            if(arr[nr][nc]!=-1) {
                                flag++;
                            }
                        }
                    }
                    for(int d=0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        if(isChecked(nr,nc)){
                            if(arr[nr][nc]!=-1) {
                                temp[nr][nc] += arr[r][c] / 5;
                            }
                        }
                    }
                    temp[r][c] += arr[r][c] - arr[r][c]/5*flag;
                }
            }
        }
        arr = temp;
//        print(arr);
    }
    private static boolean isChecked(int nr, int nc) {
        return nr>=0 && nc>=0 && nr<R && nc<C;
    }

    private static void up_aircondition() {
        int[][] sample = new int[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                sample[r][c]=arr[r][c];
            }
        }

        int d = 2;
        Node temp = up_air;
        boolean flag = false;
        while(d < 6){
            int nr = temp.r+dc[d%4];
            int nc = temp.c+dr[d%4];
//            System.out.println(nr+" "+nc);
            if(isChecked(nr,nc)){
                if(temp.r== up_air.r && temp.c== up_air.c){
                    temp = new Node(nr,nc);
                    if(flag){
                        break;
                    }
                    flag=true;
                }else{  // 처음이 아니라면
                    sample[nr][nc]=arr[temp.r][temp.c];
                    temp = new Node(nr,nc);
                }
            }else{
                d++;
            }
        }
        sample[up_air.r][up_air.c+1] = 0;
        sample[up_air.r][up_air.c]=-1;
        arr = sample;
//        System.out.println("arr");
//        print(arr);
    }

    private static void down_aircondition() {
        int[][] sample = new int[R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                sample[r][c]=arr[r][c];
            }
        }

        int d = 1;
        Node temp = down_air;
        boolean flag = false;
        while(d < 5){
            int nr = temp.r+dr[d%4];
            int nc = temp.c+dc[d%4];
//            System.out.println(nr+" "+nc);
            if(isChecked(nr,nc)){
                if(temp.r== down_air.r && temp.c== down_air.c){
                    temp = new Node(nr,nc);
                    if(flag){
                        break;
                    }
                    flag=true;
                }else{  // 처음이 아니라면
                    sample[nr][nc]=arr[temp.r][temp.c];
                    temp = new Node(nr,nc);
                }
            }else{
                d++;
            }
        }
        sample[down_air.r][down_air.c+1] = 0;
        sample[down_air.r][down_air.c]=-1;
        arr = sample;
    }

    private static class Node{
        int r;
        int c;

        private Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
    private static void print(int[][] arr){
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
