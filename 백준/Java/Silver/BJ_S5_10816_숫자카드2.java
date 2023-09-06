import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new TreeMap<>();
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(s[i]);
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1);
			}
			arr[i]=temp;
		}
		Arrays.sort(arr);
//		Iterator<Map.Entry<Integer,Integer>> iter = map.entrySet().iterator();
//		while(iter.hasNext()) {
//			Map.Entry<Integer, Integer> map2 = iter.next();
//			System.out.println(map2.getKey()+" "+map2.getValue());
//		}
		int M=Integer.parseInt(br.readLine());

		s = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			int card = Integer.parseInt(s[i]);
			//System.out.println(card);
			if(hasCard(card, arr)) {
				sb.append(map.get(card)+" ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
		
	}

	private static boolean hasCard(int card, int[] arr) {
		
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int mid=(left+right)/2;
			if(arr[mid]>card) {
				right=mid;
			}else if(arr[mid]==card){
				return true;
			}else {
				left=mid+1;
			}
		}
		if(arr[left]==card) {
			return true;
		}
		return false;
	}

}
