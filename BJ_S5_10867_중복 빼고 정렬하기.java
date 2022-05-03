import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		StringBuilder sb = new StringBuilder();
		
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++) {
			set.add(scann.nextInt());
		}
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next()+" ");
		}
		System.out.println(sb);
	}

}
