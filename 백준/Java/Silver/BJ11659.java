import java.util.*;

public class BJ11659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] sum = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            if(i!=0) {
                sum[i] += sum[i - 1] + arr[i];
            }else{
                sum[i] = arr[i];
            }
        }

        for(int i=0;i<M;i++){
            int left = sc.nextInt();
            int right = sc.nextInt();

            System.out.println(sum[right-1]-sum[left-1] + arr[left-1]);
        }
    }
}
