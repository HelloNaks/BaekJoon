import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		int M=scann.nextInt();
		int[] arr= new int[N];

		int left=0;
		int right=0;
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
			if(right<arr[i]) {
				right=arr[i];
			}
		}
		
		while(left<right) {
			long temp=0;
			int mid=(left+right)/2;
			for(int i=0;i<N;i++) {
				if(arr[i]>mid) {
					temp+=arr[i]-mid;
				}
			}
			if(temp>=M) {
				left=mid+1;
			}else if(temp<M) {
				right=mid;
			}
		}
		System.out.println(left-1);
	}

}
