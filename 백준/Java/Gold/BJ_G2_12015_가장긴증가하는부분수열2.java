import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		int[] LIS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		LIS[0]=arr[0];
		int length=1;
		for(int i=1;i<N;i++) {
			int value=arr[i];
			if(LIS[length-1]<value) {
				length++;
				LIS[length-1]=value;
			}else {
				int left=0;
				int right=length-1;
				
				while(left<right) {
					int mid=(left+right) >> 1;
					if(LIS[mid]>=value) {
						right=mid;
					}else {
						left=mid+1;
					}
				}
				LIS[left]=value;
				
			}
		}
		System.out.println(length);
	}

}
