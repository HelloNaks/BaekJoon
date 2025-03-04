import java.util.*;

public class BJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(LIS(arr));

    }
    static int LIS(int[] arr){
        int ret = 0;
        List<Integer> list = new LinkedList<>();
        list.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
                ret = list.size() - 1;
            }
            int pos = binary_search(list, 0, ret, arr[i]);
            list.set(pos, arr[i]);
        }
        return ret + 1;
    }

    static int binary_search(List<Integer> list, int st, int end, int num){
        while(st < end){
            int mid = (st+end)/2;
            if(num > list.get(mid)) st = mid+1;
            else end = mid;
        }
        return end;
    }
}
