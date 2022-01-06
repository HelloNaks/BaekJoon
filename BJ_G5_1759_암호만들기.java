import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] arr;
	static char[] ans;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		v = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().toCharArray()[0];
		}
		Arrays.sort(arr);
		run(0, 0);
	}

	private static void run(int start, int cnt) {

		if (cnt == L) {
			int a = 0;
			int b = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < C; i++) {
				if (v[i]) {
					sb.append(arr[i]);
					if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
						a++;
					} else {
						b++;
					}
				}
			}
			if (a >= 1 && b >= 2)
				System.out.println(sb);
		}
		for (int i = start; i < C; i++) {
			v[i] = true;
			run(i + 1, cnt + 1);
			v[i] = false;
		}
	}
}
