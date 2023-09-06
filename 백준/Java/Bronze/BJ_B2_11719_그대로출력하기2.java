import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		while(scann.hasNextLine()) {
			
			String s = scann.nextLine();
			System.out.println(s);
		}
	}
}
