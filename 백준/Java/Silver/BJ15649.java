import java.util.*;
public class BJ15649 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        boolean[] visited = new boolean[N+1];
        backtracking(arr, visited, N, M, 0);
    }

    public static void backtracking(int[] arr, boolean[] visited, int N, int M, int depth){
        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                backtracking(arr, visited, N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}
