import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		long S = scann.nextLong();
		long sum=0;
		long count=0;
		long i=1;
		while(true) {
			sum+=i;
			count++;
			if(sum>S) {
				count--;
				break;
			}
			i++;
		}

		System.out.println(count-1);
	}

}
