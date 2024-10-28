import java.util.*;

public class BJ11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        int answer = 0;
        for(int i=0;i<N;i++){   //기준점
            int a = LIS(arr, i);
            int b = REV_LIS(arr, i);
            if(answer<a+b){
                answer = a+b-1;
            }
        }
//        answer = LIS(arr, N);
        System.out.println(answer);
    }

    static int LIS(int[] arr, int i){
        List<Integer> temp = new LinkedList<>();
        temp.add(arr[0]);

        for(int j=1;j<=i;j++){
            if(arr[j]>temp.get(temp.size()-1)){
                temp.add(arr[j]);
            }
            int pos = binary_search(temp, arr[j]);
            temp.set(pos, arr[j]);
        }
        return temp.size();
    }

    static int REV_LIS(int[] arr, int i){
        List<Integer> temp = new LinkedList<>();
        temp.add(arr[i]);
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<temp.get(temp.size()-1)){
                temp.add(arr[j]);
            }
            int pos = rev_binary_search(temp, arr[j]);
            temp.set(pos, arr[j]);
        }

        return temp.size();
    }

    static int binary_search(List<Integer> list, int num){
        int st = 0;
        int end = list.size();

        while(st < end){
            int mid = (st+end)/2;
            if(num > list.get(mid)) st = mid+1;
            else end = mid;
        }
        return end;
    }

    static int rev_binary_search(List<Integer> list, int num){
        int st = 0;
        int end = list.size();

        while(st < end){
            int mid = (st+end)/2;
            if(num < list.get(mid)) st = mid+1;
            else end = mid;
        }
        return end;
    }
}
