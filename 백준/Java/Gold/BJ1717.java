import java.util.*;

public class BJ1717 {

    static int[] parent;

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];

        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(flag==0){
                union(a, b);
            }else{
                if(find(parent[a])==find(parent[b])){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
