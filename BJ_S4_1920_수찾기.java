import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int N=scann.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = scann.nextInt();
		}
		Arrays.sort(A);
		int M=scann.nextInt();
		
		for(int i=0;i<M;i++) {
			int temp=scann.nextInt();
			
			int left=0;
			int right=N-1;
			boolean flag=false;
			while(left<=right) {
				int mid=(left+right)/2;
				if(A[mid]==temp) {
					flag=true;
					break;
				}else if(A[mid]>temp) {
					right=mid-1;
				}else {
					left=mid+1;
				}
			}
			if(flag) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
}
