import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int MAX = Integer.MIN_VALUE;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 가로로 교체
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				
				isMax(N);
				
				temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				
			}
		}
		// 세로로 교체
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				char temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
				
				isMax(N);
				
				temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
			}
		}
		System.out.println(MAX);
	}

	private static void isMax(int N) {
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
				} else {
					count = 1;
				}
				MAX = Math.max(MAX, count);
			}
		}
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count++;
				} else {
					count = 1;
				}
				MAX = Math.max(MAX, count);
			}
		}
	}
}
