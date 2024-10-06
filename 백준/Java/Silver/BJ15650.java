import java.util.*;

public class BJ15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        boolean[] visited = new boolean[N+1];

        backtracking(arr, visited, 0);
    }

    public static void backtracking(int[] arr, boolean[] visited, int depth) {
        if(depth == arr.length){
            for(int i=0;i<depth;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<visited.length;i++){
            if(!visited[i]){
                if(depth==0){
                    arr[depth]=i;
                    visited[i]=true;
                    backtracking(arr, visited, depth+1);
                    visited[i]=false;
                }else{
                    if(arr[depth-1]<i){
                        arr[depth]=i;
                        visited[i]=true;
                        backtracking(arr, visited, depth+1);
                        visited[i]=false;
                    }
                }
            }
        }
    }
}
