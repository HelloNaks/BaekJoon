import java.util.*;

public class BJ2630 {
    static int white = 0, blue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        run(arr, 0,N,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void run(int[][] arr, int r1, int r2, int c1, int c2){
        boolean flag = false;
        int temp = arr[r1][c1];
        for(int i=r1;i<r2;i++){
            for(int j=c1;j<c2;j++){
                if(arr[i][j] != temp){
                    flag=true;
                }
            }
            if(flag){
                break;
            }
        }
        if(!flag){
            if(temp==1){
                blue++;
            }else{
                white++;
            }
        }else{
            run(arr,r1,(r1+r2)/2,c1,(c1+c2)/2);
            run(arr,r1,(r1+r2)/2,(c1+c2)/2,c2);
            run(arr,(r1+r2)/2,r2,c1,(c1+c2)/2);
            run(arr,(r1+r2)/2,r2,(c1+c2)/2,c2);
        }
    }
}
