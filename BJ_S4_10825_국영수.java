import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		Person[] p = new Person[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String name=st.nextToken();
			int kor=Integer.parseInt(st.nextToken());
			int eng=Integer.parseInt(st.nextToken());
			int math=Integer.parseInt(st.nextToken());
			p[i]=new Person(name, kor, eng, math);
			
		}
		Arrays.sort(p);
		for(int i=0;i<N;i++) {
			System.out.println(p[i].name);
		}
	}

	public static class Person implements Comparable<Person> {
		String name;
		int kor;
		int eng;
		int math;
		
		public Person(String name, int kor, int eng, int math) {
			this.name=name;
			this.kor=kor;
			this.eng=eng;
			this.math=math;
		}
		
		@Override
		public int compareTo(Person o) {
			if(this.kor==o.kor) {
				if(this.eng==o.eng) {
					if(this.math==o.math) {
						if(this.name.compareTo(o.name)>0) {
							return 1;
						}else if(this.name.compareTo(o.name)==0) {
							return 0;
						}else {
							return -1;
						}
					}else {
						return o.math-this.math;
					}
				}else {
					return this.eng-o.eng;
				}
			}else {
				return o.kor-this.kor;
			}
		}
	}
}
