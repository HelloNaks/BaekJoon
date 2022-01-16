import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s=scann.next();
		char[] ch = s.toCharArray();
		Integer[] arr=new Integer[ch.length];
		for(int i=0;i<arr.length;i++) {
			arr[i]=Character.getNumericValue(ch[i]);
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
}
