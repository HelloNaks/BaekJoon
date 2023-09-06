import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		StringBuilder sb = new StringBuilder();
		String[] teamnames = new String[N];
		List<String>[] lists = new ArrayList[N];
		for(int i=0;i<N;i++) {
			lists[i]=new ArrayList<>();
		}
		int M=scann.nextInt();
		for(int i=0;i<N;i++) {
			teamnames[i]=scann.next();
			int cnt = scann.nextInt();
			for(int j=0;j<cnt;j++) {
				String member = scann.next();
				lists[i].add(member);
			}
			Collections.sort(lists[i]);
		}
		
		for(int i=0;i<M;i++) {
			String temp = scann.next();
			int flag = scann.nextInt();
			if(flag==0) {			//멤버 모두 풀력
				for(int j=0;j<N;j++) {
					if(teamnames[j].equals(temp)) {
						for(int k=0;k<lists[j].size();k++) {
							sb.append(lists[j].get(k)+"\n");
						}
						break;
					}
				}
			}else if(flag==1) {		//팀 이름 출력
				boolean teamflag=false;
				for(int j=0;j<N;j++) {
					for(int k=0;k<lists[j].size();k++) {
						if(lists[j].get(k).equals(temp)) {
							sb.append(teamnames[j]+"\n");
							teamflag=true;
							break;
						}
						if(teamflag) {
							break;
						}
					}
					if(teamflag) {
						break;
					}
				}
			}
			
		}
		System.out.println(sb);
	}

}
