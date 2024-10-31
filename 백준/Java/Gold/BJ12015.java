import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        System.out.println(LIS(arr));
    }

    static int LIS(int[] arr){
        int ret = 0;
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
                ret = list.size()-1;
            }
            int pos = binary_search(list, 0, ret, arr[i]);
            list.set(pos, arr[i]);
        }
        return ret + 1;
    }

    static int binary_search(List<Integer> list, int st, int end, int val){
        while(st<end){
            int mid = (st+end)/2;
            if(val > list.get(mid)) st = mid+1;
            else end = mid;
        }
        return end;
    }
}
