import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set.add(scann.next());
		}
		List<String> list = new LinkedList<>();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
		});
		for(String s: list) {
			System.out.println(s);
		}
	}
}
