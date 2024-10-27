import java.util.*;

public class BJ15663 {
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        backTracking(N, M, 0, "");

        for(String s: set){
            System.out.println(s);
        }
    }

    static void backTracking(int N, int M, int depth, String s){
        if(depth==M){
            set.add(s.trim());
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                backTracking(N, M, depth+1, s+arr[i]+" ");
                visited[i]=false;
            }
        }
    }
}
