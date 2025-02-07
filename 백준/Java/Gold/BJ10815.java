import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ10815 {

    static PriorityQueue<Integer> st = new PriorityQueue<>();
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            st.add(sc.nextInt());
        }
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=st.poll();
        }
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            int temp = sc.nextInt();
            boolean a = binary_search(0, N, temp);
            if(a) {
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }
    public static boolean binary_search(int st, int end, int num){
        while(st<end){
            int pivot = (st+end) / 2;
            if(num == arr[pivot]) return true;
            if(num > arr[pivot]) st = pivot + 1;
            else end = pivot;
        }
        return false;
    }
}
