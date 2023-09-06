import java.util.Scanner;

public class Main {

	static int[] alphabet=new int[26];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine().toUpperCase();
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			alphabet[ch[i]-'A']++;
		}
		int maxnum=0;
		int maxidx=0;
		for (int i = 0; i < 26; i++) {
			if(alphabet[i] > maxnum) {
				maxnum = alphabet[i];
				maxidx = i;
			}
			else if(alphabet[i] == maxnum) {
				maxidx = -1;
			}
		}
		if(maxidx != -1) {
			char answer = (char) ('A'+maxidx);
			System.out.println(answer);
		}else {
			System.out.println("?");
		}
	}

}
