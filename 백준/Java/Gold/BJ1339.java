import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int answer = 0;

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        int[] alphabet = new int[26];

        for(int i=0;i<N;i++){
            for(int j=0;j<arr[i].length();j++){
                alphabet[arr[i].charAt(j)-'A'] += Math.pow(10,arr[i].length()-j-1);
            }
        }
        int index = 9;
        Arrays.sort(alphabet);
        for(int i=alphabet.length-1;i>=0;i--){
            if(alphabet[i] == 0){
                break;
            }
            answer += alphabet[i] *index;
            index--;
        }

        System.out.println(answer);
    }
}
