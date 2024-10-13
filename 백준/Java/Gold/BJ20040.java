import java.util.*;

public class BJ20040 {
    static int[] parent;

    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x!=y){
            parent[y]=x;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int answer = 0;
        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(find(a)==find(b)){
                System.out.println(i+1);
                return;
            }else{
                union(a,b);
            }
        }

        System.out.println(0);
    }
}
