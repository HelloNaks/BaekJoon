import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<N;i++) {
			st.add(sc.nextInt());
		}
		int answer = 1;
		int cur=0;
		if(N==0) {
			answer = 0;
		}
		while(true) {
			if(st.size()==0) {
				break;
			}
			int temp = st.pop();
			if(cur+temp>M) {
				cur = temp;
				answer++;
			}else {
				cur += temp;
			}
		}
		System.out.println(answer);
	}

}
