import java.util.*;

public class BJ9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] arr = new long[101];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        arr[4]=2;
        arr[5]=2;
        for(int i=6;i<=100;i++){
            arr[i]=arr[i-1]+arr[i-5];
        }
        for(int t=0;t<T;t++){
            int a = sc.nextInt();
            System.out.println(arr[a]);
        }
    }
}
