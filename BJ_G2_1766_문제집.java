import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        Scanner scann = new Scanner(System.in);
        int N = scann.nextInt();
        int M = scann.nextInt();
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            int x = scann.nextInt();
            int y = scann.nextInt();
            list[x].add(y);
            indegree[y]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i=1; i<=N; i++){
            
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            
            int current = q.poll();
            System.out.print(current+" ");
            
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                indegree[next]--;
                
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
    }
}
