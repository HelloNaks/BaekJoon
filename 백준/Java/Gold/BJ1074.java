import java.util.Scanner;

public class BJ1074 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        run(N, r, c);
        System.out.println(answer);
    }
    static void run(int N, int r, int c){
        if (N==0) return;

        int half = 1 << (N-1);
        long areaSize = (long) half * half;

        if(r < half && c < half){ // 1번
            run(N-1, r, c);
        }else if(r < half && c >= half){    // 2번
            answer += areaSize;
            run(N-1,r,c-half);
        }else if(r>=half && c<half){ // 3번
            answer += 2*areaSize;
            run(N-1,r-half,c);
        }else{  // 4번
            answer += 3*areaSize;
            run(N-1,r-half,c-half);
        }
    }
}
