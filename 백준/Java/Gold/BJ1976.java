import java.util.*;

public class BJ1976 {
    static int[] parent;

    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a!=b){
            parent[b]=a;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[] cities = new int[M];
        parent = new int[N+1];
        for(int i=0;i<M;i++){
            cities[i] = sc.nextInt();
        }
        for(int i=1;i<=N;i++){
            parent[i]=i;
        }

        for(int i=1;i<=N;i++){
            for(int j=i;j<=N;j++){
                if(arr[i][j]==1){
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        int first = find(cities[0]);

        for(int i=1;i<M;i++){
            if(find(cities[i])!=first){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
