import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int num=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int temp=N;
		while(true) {
			
			int tmp = (temp/10)+(temp%10);
			if(tmp<10) {
				temp=tmp+(temp%10)*10;
			}else {
				temp=tmp%10+(temp%10)*10;
			}
			num++;
			if(temp==N) {
				break;
			}
		}
		System.out.println(num);
	}
}
