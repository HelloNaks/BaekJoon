import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int max = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			long val = Long.parseLong(br.readLine());
			map.put(val, map.getOrDefault(val, 0) + 1);
			max = Math.max(map.get(val), max);
		}
		
		List<Long> list = new ArrayList<>();
		for(Entry<Long, Integer> val: map.entrySet()) {
			if(val.getValue()==max)
				list.add(val.getKey());
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}

}
