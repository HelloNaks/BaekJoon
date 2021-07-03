import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int a=scann.nextInt();
		int b=scann.nextInt();
		String s1=Integer.toString(a);
		String s2=Integer.toString(b);

		char[] ch1=s1.toCharArray();
		char[] ch2=s2.toCharArray();
		char[] ch3=new char[ch1.length];
		char[] ch4=new char[ch2.length];
		for(int i=0;i<ch1.length;i++) {
			ch3[i]=ch1[ch1.length-i-1];
		}
		for(int i=0;i<ch2.length;i++) {
			ch4[i]=ch2[ch2.length-i-1];
		}

		String z1 = "";
		for (int i = 0; i < ch3.length; i++) {
			z1 += Character.toString(ch3[i]);
		}
		String z2 = "";
		for (int i = 0; i < ch4.length; i++) {
			z2 += Character.toString(ch4[i]);
		}
		
		int answer = Math.max(Integer.parseInt(z1), Integer.parseInt(z2)); 
		System.out.println(answer);
	}

}
