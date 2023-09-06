import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s = scann.nextLine();
		char[] ch=s.toCharArray();
		int index=0;
		while(true) {
			if(ch.length-index<10) {
				for(int i=index;i<ch.length;i++) {
					System.out.print(ch[i]);
				}
				break;
			}else {
				for(int i=index;i<index+10;i++) {
					System.out.print(ch[i]);
				}
				System.out.println();
				index+=10;
			}
		}
	}
}
