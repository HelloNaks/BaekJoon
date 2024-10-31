import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String temp  = br.readLine();
            temp = temp.substring(1,temp.length()-1);
            String[] st = temp.split(",");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            if(!st[0].equals("")) {
                for (int i = 0; i < st.length; i++) {
                    deque.addLast(Integer.parseInt(st[i]));
                }
            }

            boolean flag = false;
            boolean isReversed = false;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='R'){
                    isReversed = !isReversed;
                }else{
                    if(deque.isEmpty()){
                        sb.append("error"+"\n");
                        flag = true;
                        break;
                    }
                    if(!isReversed) {
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }
            }
            if(!flag) {
                int size = deque.size();
                if(size == 0){
                    sb.append("[]");
                }
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        sb.append("[");
                    }
                    if (i == size - 1) {
                        if(!isReversed) {
                            sb.append(deque.pollFirst() + "]");
                        }else{
                            sb.append(deque.pollLast() + "]");
                        }
                    }else {
                        if(!isReversed) {
                            sb.append(deque.pollFirst() + ",");
                        }else{
                            sb.append(deque.pollLast() + ",");
                        }
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
