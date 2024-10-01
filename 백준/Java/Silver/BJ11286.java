import java.util.*;

public class BJ11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o2.absolute==o1.absolute){
                    return o1.val-o2.val;
                }
                return o1.absolute-o2.absolute;
            }
        });
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            if(a!=0) {
                pq.add(new Node(Math.abs(a), a));
            }else {
                if(pq.isEmpty()){
                    System.out.println(0);
                }else {
                    Node n = pq.poll();
                    System.out.println(n.val);
                }
            }
        }

    }

    public static class Node {

        int absolute;
        int val;

        public Node(int absolute, int val) {
            this.absolute = absolute;
            this.val = val;
        }
    }
}

