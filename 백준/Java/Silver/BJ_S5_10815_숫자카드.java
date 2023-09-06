import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N=scann.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=scann.nextInt();
		}
		Arrays.sort(arr);
		int M=scann.nextInt();
		
		for(int i=0;i<M;i++) {
			int card = scann.nextInt();
			//System.out.println(card);
			if(hasCard(card, arr)) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
		
	}

	private static boolean hasCard(int card, int[] arr) {
		
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int mid=(left+right)/2;
			if(arr[mid]>card) {
				right=mid;
			}else if(arr[mid]==card){
				return true;
			}else {
				left=mid+1;
			}
		}
		if(arr[left]==card) {
			return true;
		}
		return false;
	}

}
