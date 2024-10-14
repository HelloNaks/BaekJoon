import java.util.*;

public class BJ15654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[M];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
            map.put(list.get(i), 0);
        }
        Collections.sort(list);
        backtracking(list, arr, map, N, M, 0);
    }

    static void backtracking(ArrayList<Integer> list, int[] arr, Map<Integer, Integer> map, int N, int M, int depth){
        if(depth==arr.length){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i< list.size();i++){
            if(map.get(list.get(i))==0){
                map.put(list.get(i), 1);
                arr[depth] = list.get(i);
                backtracking(list, arr, map, N, M, depth+1);
                map.put(list.get(i), 0);
            }
        }
    }
}
