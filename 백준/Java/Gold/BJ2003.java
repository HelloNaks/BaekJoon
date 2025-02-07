import java.util.Scanner;

public class BJ2003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int st = 0;
        int end = 0;
        int val = arr[0];
        while(true){
            if(val==M){
                answer++;
                if(end==N-1) break;
                val += arr[end+1] - arr[st];
                st++;
                end++;
            } else if(val<M){
                if(end==N-1) break;
                val += arr[end+1];
                end++;
            } else{
                if(st==N-1) break;
                val -= arr[st];
                st++;
            }
        }
        System.out.println(answer);
    }
}
