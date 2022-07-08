import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		while(list.size()>1) {
			list.remove(0);
			int temp = list.get(0);
			list.remove(0);
			list.add(temp);
		}
		System.out.println(list.get(0));
	}

}
