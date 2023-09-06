import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		//SHA-256 형식으로 암호화
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		//update() 메소드를 호풀할 때 마다 객체 내에 저장된 SHA-256 digest 값이 계속해서 갱신된다.
		md.update(s.getBytes());
		//digest()메소드를 호출하면 그 값을 가져올 수 있다.
		for(byte b: md.digest()) {
			System.out.printf("%02x", b);	//%02x : 2자리 16진수 표시
		}
	}
}
