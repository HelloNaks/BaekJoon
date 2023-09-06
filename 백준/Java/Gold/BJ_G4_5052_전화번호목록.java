import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			List<String> list = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				list.add(br.readLine());
			}
			Collections.sort(list);
			
			boolean flag=false;
			for(int i=0;i<N-1;i++) {
				if(list.get(i+1).startsWith(list.get(i))) {
					flag=true;
					break;
				}
			}
			if(flag) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
