import java.util.*;

public class BJ1427 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
