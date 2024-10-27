import java.util.*;

public class BJ15666 {
    static int N, M;
    static int[] arr, list;
    static Set<String> answer;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<N;i++){
            set.add(sc.nextInt());
        }
        answer = new LinkedHashSet<>();
        list = new int[set.size()];
        arr = new int[N];
        list = set.stream().mapToInt(Integer::intValue).toArray();

        backtracking(0, "");

        answer.stream().forEach((s)-> sb.append(s+"\n"));
        System.out.println(sb);
    }
    static void backtracking(int depth, String s){
        if(depth==M){
            answer.add(s.trim());
            return;
        }
        for(int i=0;i<list.length;i++){
            if(depth!=0){
                if(arr[depth-1]<=list[i]){
                    arr[depth]=list[i];
                    backtracking(depth + 1, s + list[i] + " ");
                }
            }else {
                arr[depth]=list[i];
                backtracking(depth + 1, s + list[i] + " ");
            }
        }
    }
}
