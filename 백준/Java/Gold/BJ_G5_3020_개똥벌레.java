import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int H=scann.nextInt();
		int cnt=0;
		int answer=Integer.MAX_VALUE;
		int[] arr= new int[H+1];
		int[] rev= new int[H+1];
		for(int i=0;i<N;i++) {
			int temp = scann.nextInt();
			if(i%2==0) {
				arr[temp]++;
			}else {
				rev[temp]++;
			}
		}
		
		for(int i=H-1;i>0;i--) {
			rev[i]+=rev[i+1];
			arr[i]+=arr[i+1];
		}
		for(int i=1;i<=H;i++) {
			int now = rev[i] + arr[H-i+1];
			
			if(now<answer) {
				answer=now;
				cnt=1;
			}else if(now==answer){
				cnt++;
			}
		}
		System.out.println(answer+" "+cnt);
	}

}
