import java.io.IOException;
import java.util.*;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int st = sc.nextInt();
            int end = sc.nextInt();

            nodeList.add(new Node(st, end));
        }
        Collections.sort(nodeList, new Comparator<Node>(
        ) {
            @Override
            public int compare(Node o1, Node o2) {
                if(o2.end==o1.end) {
                    return o1.st - o2.st;
                }
                return o1.end - o2.end;
            }
        });
        
        int cnt = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (end <= nodeList.get(i).st) {
                end = nodeList.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static class Node {
        int st;
        int end;

        public Node(int st, int end) {
            this.st = st;
            this.end = end;
        }
    }
}
