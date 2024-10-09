import java.util.*;

public class BJ15651 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];

        backtracking(arr, N, M, 0);
        System.out.println(sb);
    }

    static void backtracking(int[] arr, int N, int M, int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            arr[depth]=i;
            backtracking(arr, N, M, depth+1);
        }
    }
}
