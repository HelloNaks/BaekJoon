import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] LIS = new long[N];
		long[] len = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		for(int i=0;i<N;i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		LIS[0]=arr[0];
		len[0]=1;
		int length=1;
		for(int i=1;i<N;i++) {
			long value=arr[i];
			if(LIS[length-1]<value) {
				length++;
				LIS[length-1]=value;
				len[i]=length;
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
				len[i]=left+1;
			}
		}
		
		int value = length;
		Stack<Long> stack = new Stack<>();
		for(int i=N-1;i>=0;i--) {
			if(value==len[i]) {
				stack.push(arr[i]);
				value--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(length);
		System.out.println(sb.toString());
	}

}
