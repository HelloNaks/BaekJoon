import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine();
		String temp="";
		char[] ch = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(ch[i]>='a' && ch[i]<='z') {
				temp+=s.valueOf(ch[i]).toUpperCase();
			}else if(ch[i]>='A' && ch[i]<='Z') {
				temp+=s.valueOf(ch[i]).toLowerCase();
			}else {
				temp+=s.valueOf(ch[i]);
			}
		}
		System.out.println(temp);
		
	}

}
