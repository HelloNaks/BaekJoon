import java.util.*;

public class BJ1715 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(sc.nextInt());
        }
        int answer = 0;
        while(pq.size()>1){

            int first = pq.poll();
            int second = pq.poll();
            pq.add(first+second);
            answer += first + second;
        }
        System.out.println(answer);
    }
}
