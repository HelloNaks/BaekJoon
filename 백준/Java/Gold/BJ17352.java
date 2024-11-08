import java.util.*;

public class BJ17352 {
    static int[] parent;
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x!=y){
            parent[y] = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i]=i;
        }
        for(int i=0;i<N-2;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a<=b) {
                union(a, b);
            }else{
                union(b, a);
            }
        }
        int temp = parent[1];
        for(int i=2;i<=N;i++){
            if(find(temp)!=find(parent[i])){
                System.out.println(parent[1]+" "+parent[i]);
                break;
            }
        }
    }
}
