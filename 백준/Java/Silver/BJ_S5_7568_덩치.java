import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Person[] p = new Person[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i]=new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(p[i].weight>p[j].weight && p[i].height>p[j].height) {
					p[j].rank++;
				}else if(p[i].weight<p[j].weight && p[i].height<p[j].height) {
					p[i].rank++;
				}
			}
		}
		
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i].rank+" ");
		}
	}
	
	public static class Person{
		int height;
		int weight;
		int rank;
		
		public Person(int weight, int height) {
			super();
			this.height = height;
			this.weight = weight;
			this.rank=1;
		}	
	}
}
