import java.util.*;

public class BJ11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int answer = 0;
        for(int i=0;i<N;i++){
            answer += (N-i) * list.get(i);
        }
        System.out.println(answer);
    }
}
