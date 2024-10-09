import java.util.*;

public class BJ1043 {

    static int[] parent;

    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        if(T==0){
            System.out.println(M);
            return;
        }

        parent = new int[N+1];
        int[] know = new int[T];
        for(int t=0;t<T;t++){
            know[t] = sc.nextInt();
        }


        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        List<List<Integer>> parties = new ArrayList<>();
        for(int m=0;m<M;m++){
            List<Integer> party = new ArrayList<>();
            int num = sc.nextInt();
            int first = sc.nextInt();
            party.add(first);

            for(int i=1;i<num;i++){
                int person = sc.nextInt();
                party.add(person);
                union(first, person);
            }
            parties.add(party);
        }

        for(int i=1;i<T;i++){
            union(know[0],know[i]);
        }

        int answer = 0;
        for(List<Integer> party : parties){
            boolean flag = true;
            for(int person: party){
                if(find(parent[person]) == find(know[0])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
