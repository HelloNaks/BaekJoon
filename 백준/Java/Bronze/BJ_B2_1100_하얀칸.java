import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] s = new char[8][8];
		int answer=0;
		for(int i=0;i<8;i++) {
			char[] ch = br.readLine().toCharArray();
			s[i]=ch;
		}
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i+j)%2==0 && s[i][j]=='F') {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
