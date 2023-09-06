import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int size=(int) Math.pow(2, N);
		run(size,r,c);
		System.out.println(answer);
	}
	private static void run(int size, int r, int c) {
		if(size==1) return;
		if(r < size/2 && c < size/2) {
			run(size/2, r, c);
		}else if(r < size/2 && c >= size/2) {
			answer += size*size/4; 
			run(size/2, r, c - size/2);
		}else if(r >= size/2 && c < size/2) {
			answer += (size*size/4)*2;
			run(size/2, r - size/2, c);
		}else {
			answer += (size*size/4)*3;
			run(size/2, r - size/2,c - size/2);
		}
	}
}
