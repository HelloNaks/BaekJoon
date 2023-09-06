import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		N=scann.nextInt();
		String s;
		int num;
		for (int i = 0; i < N; i++) {
			s=scann.next();
			if(s.equals("push")) {
				num=scann.nextInt();
				st.push(num);
			}else if(s.equals("pop")) {
				if(st.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(st.pop()).append("\n");
				}
			}else if(s.equals("size")) {
				sb.append(st.size()).append("\n");
			}else if(s.equals("empty")) {
				if(st.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else if(s.equals("top")) {
				if(st.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(st.peek()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
