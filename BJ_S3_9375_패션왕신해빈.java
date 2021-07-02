import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			HashMap<String, Integer> clothes = new HashMap<String, Integer>();
			
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String s = st.nextToken();
				if(clothes.containsKey(s)) {
					clothes.put(s, clothes.get(s) + 1);
				}else {
					clothes.put(s, 1);
				}
			}
			int answer = 1;
			for(int number : clothes.values()) {
				answer *= (number + 1);
			}
			System.out.println(answer - 1);
		}
		
	}

}
