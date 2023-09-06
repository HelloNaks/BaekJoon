import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer=0;
		String start = st.nextToken();
		String end = st.nextToken();
		String stream = st.nextToken();
		HashSet<String> s = new HashSet<>();
		HashSet<String> e = new HashSet<>();
		String temp;
		
		while((temp=br.readLine())!=null){
			if(start.compareTo(temp.split(" ")[0])>=0) {
				s.add(temp.split(" ")[1]);
			}else if(end.compareTo(temp.split(" ")[0])<=0 && stream.compareTo(temp.split(" ")[0])>=0) {
				e.add(temp.split(" ")[1]);
			}
		}
		
		for(String tmp : e) {
			if(s.contains(tmp)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
