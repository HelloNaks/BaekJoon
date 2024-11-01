import java.sql.Array;
import java.util.*;

public class BJ1753 {
    static int[] dist;
    static int V, E, K;
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] list;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        list = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1;i<=V;i++){
            list[i] = new ArrayList<>();
            dist[i]=INF;
        }

        for(int i=0;i<E;i++){
            int st = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            list[st].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(K);

        for(int i=1;i<=V;i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int cur = temp.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node: list[cur]){
                if(dist[node.end]>dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;
        Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
}
