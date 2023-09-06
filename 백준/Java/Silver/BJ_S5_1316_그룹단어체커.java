import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, answer = 0;
	static String[] word;
	static char[] al=new char[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i]=br.readLine();
		}
		for (int i = 0; i < N; i++) {
			al=new char[26];
			char[] ch = word[i].toCharArray();
			for (int j = ch.length-1; j > 0; j--) {
				if(ch[j]==ch[j-1]) {
					ch[j]='0';
				}
			}
			for (int j = 0; j < ch.length; j++) {
				if(ch[j]=='0') {
					continue;
				}else {
					al[ch[j]-'a']++;
					if(al[ch[j]-'a']>1) {
						break;
					}
				}
			}
			boolean temp=false;
			for (int j = 0; j < al.length; j++) {
				if(al[j]>1) {
					temp=true;
					break;
				}
			}
			if(temp==false) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
