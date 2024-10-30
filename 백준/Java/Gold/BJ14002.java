import java.util.*;

public class BJ14002 {
    static List<Integer> list;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<=N;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(dp[i], result);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result+"\n");

        int val = result;
        Stack<Integer> stack = new Stack<>();

        for(int i=N;i>=1;i--){
            if(val == dp[i]){
                stack.push(arr[i]);
                val--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }

}
