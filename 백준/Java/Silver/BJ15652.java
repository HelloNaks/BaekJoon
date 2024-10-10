import java.util.*;

public class BJ15652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];

        backtracking(arr, N, M, 0);

    }

    static void backtracking(int[] arr, int N, int M, int depth) {
        if(depth == M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if(depth == 0){
                arr[0] = i;
                backtracking(arr, N, M, depth + 1);
            }else {
                if (arr[depth - 1] <= i) {
                    arr[depth] = i;
                    backtracking(arr, N, M, depth + 1);
                }
            }
        }
    }
}
