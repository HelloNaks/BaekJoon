import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ9663 {

    static int N, answer = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        run(0);
        System.out.println(answer);
    }

    public static void run(int length){

        if(length==N){
            answer++;
            return;
        }
        
        for(int i=0;i<N;i++){
            arr[length] = i;
            if(check(length)){
                run(length+1);
            }
        }
    }

    public static boolean check(int length){
        for(int i=0;i<length;i++){
            if(arr[length] == arr[i] || length-i == Math.abs(arr[length]-arr[i])) return false;
        }
        return true;
    }

}
