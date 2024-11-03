import java.util.*;

public class BJ15655 {
    static int N, M;
    static int[] arr;
    static boolean[] visited = new boolean[10001];
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        for(int i=0;i<N;i++){
            int num = sc.nextInt();
            list.add(num);
        }
        Collections.sort(list);

        visited = new boolean[list.get(list.size()-1)+1];
        backtracking(list, 0);
        System.out.println(sb);
    }

    static void backtracking(List<Integer> list, int depth){
        if(depth == M){
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<list.size();i++){
            if(!visited[list.get(i)]) {
                if(depth!=0) {
                    if (arr[depth - 1] < list.get(i)) {
                        visited[list.get(i)] = true;
                        arr[depth] = list.get(i);
                        backtracking(list, depth + 1);
                        visited[list.get(i)] = false;
                    }
                }else{
                    visited[list.get(i)] = true;
                    arr[depth] = list.get(i);
                    backtracking(list, depth + 1);
                    visited[list.get(i)] = false;
                }
            }
        }
    }
}
