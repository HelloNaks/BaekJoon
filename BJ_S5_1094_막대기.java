import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int X=scann.nextInt();
		int answer=0;		//총 필요한 막대 개수
		int stick = 64;
		while(X>0) {
			if(stick>X) {	//stick이 원하는 길이보다 길면
				stick/=2;
			}else {			//stick이 원하는 길이보다 짧으면 
				X-=stick;	//원하는 길이에서 stick만큼 빼주고
				answer++;	//막대의 개수를 증가시킨다.
			}
		}
		System.out.println(answer);
	}
}
