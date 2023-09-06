import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			int num = Integer.parseInt(br.readLine());
			int len = s.length();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int[] arr = new int[26];

			if(num==1) {
				System.out.println("1 1");
				continue;
			}
			for (int i = 0; i < len; i++) {
				arr[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < len; i++) {
				if (arr[s.charAt(i) - 'a'] < num)
					continue;
				int temp = 1;
				for (int j = i + 1; j < len; j++) {
					if (s.charAt(j) == s.charAt(i)) {
						temp++;
					}
					if (temp == num) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
				System.out.println("-1");
			} else {
				System.out.println(min + " " + max);
			}
		}
	}

}
