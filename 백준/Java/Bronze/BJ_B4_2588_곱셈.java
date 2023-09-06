import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int first=scann.nextInt();
		int second=scann.nextInt();
		int answer=0;
		int idx=0;
		while(true){
			if(second/10==0) {
				System.out.println(first*second);
				answer+=first*(second%10)*Math.pow(10, idx++);
				break;
			}
			System.out.println(first*(second%10));
			answer+=first*(second%10)*Math.pow(10, idx++);
			second/=10;
		}
		System.out.println(answer);
	}
}
