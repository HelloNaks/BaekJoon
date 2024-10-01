import java.util.*;

public class BJ11279 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            if(a == 0){
                if(pq.size()==0){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else {
                pq.add(a);
            }
        }
    }
}
