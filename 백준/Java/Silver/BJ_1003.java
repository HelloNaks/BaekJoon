import java.util.*;


public class BJ1003 {

    private static int[] zero = new int[41];
    private static int[] one = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int i=0;i<41;i++){
            if(i==0) {
                zero[i] = 1;
                one[i] = 0;
            } else if(i==1){
                zero[i] = 0;
                one[i] = 1;
            } else {
                zero[i] = zero[i-1] + zero[i-2];
                one[i] = one[i-1] + one[i-2];
            }
        }
        for(int t=0;t<T;t++){
            int val = sc.nextInt();
            System.out.println(zero[val]+" "+ one[val]);
        }
    }

}
