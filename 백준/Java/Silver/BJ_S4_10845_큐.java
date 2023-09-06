import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(s.contains("push")){
				String[] temp = s.split(" ");
				list.add(Integer.parseInt(temp[1]));
				continue;
			}
			switch(s) {
			case "pop":
				if(list.size()==0) {
					System.out.println("-1");
				}else {
					System.out.println(list.get(0));
					list.remove(0);
				}
				break;
			case "size":
				System.out.println(list.size());
				break;
			case "empty":
				if(list.size()==0) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				break;
			case "front":
				if(list.size()==0) {
					System.out.println("-1");
				}else {
					System.out.println(list.get(0));
				}
				break;
			case "back":
				if(list.size()==0) {
					System.out.println("-1");
				}else {
					System.out.println(list.get(list.size()-1));
				}
				break;
			}
		}
	}

}
