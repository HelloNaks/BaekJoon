import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static Robot[] A;
	
	public static void main(String[] args) throws IOException {
		/**
		 * 1. 전체 회전
		 * 2. 우선순위에 따라 로봇을 이동시킨다.(내구도 존재해야함 & 로봇 없어야함)
		 * 3. 로봇을 올린다.
		 * 4. 내구도 0인 개수 K일때 종료
		 * 5. 몇번째 단계가 진행중인지 출력
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		A=new Robot[2*N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++) {
			int durability=Integer.parseInt(st.nextToken());
			A[i]=new Robot(durability);
		}
		
		int answer=0;
		while(true) {
			answer++;
			if(answer!=0) {
				rotate();
				move();
			}
			newRobot();
			if(end()) {
				break;
			}
		}
		System.out.println(answer);
	}

	private static void move() {
		for(int i=N-2;i>=0;i--) {
			if(A[i].isRobot) {
				if(i+1==N-1) {
					if(A[i+1].durability>0) {
						A[i].isRobot=false;
						A[i+1].durability--;
						continue;
					}
				}
				if(A[i+1].isRobot || A[i+1].durability==0)
					continue;
				A[i+1].isRobot=true;
				A[i].isRobot=false;
				A[i+1].durability--;
			}
		}
	}
	private static boolean end() {
		int cnt=0;
		for(int i=0;i<2*N;i++) {
			if(A[i].durability==0) {
				cnt++;
			}
		}
		return cnt>=K ? true : false;
	}
	private static void newRobot() {
		if(!A[0].isRobot && A[0].durability>0) {
			A[0].isRobot=true;
			A[0].durability--;
		}
	}
	private static void rotate() {
		boolean Rtemp=A[2*N-1].isRobot;
		int Dtemp=A[2*N-1].durability;
		
		for(int i=N*2-1;i>=1;i--) {
			A[i].durability=A[i-1].durability;
			A[i].isRobot=A[i-1].isRobot;
			if(i==N-1) {
				A[i].isRobot=false;
			}
		}
		A[0].isRobot=Rtemp;
		A[0].durability=Dtemp;
	}

	public static class Robot {
		int durability;
		boolean isRobot;
		
		public Robot(int durability) {
			super();
			this.durability = durability;
			this.isRobot=false;
		}
	}
}
