//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//    static int N, M, V;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        N = Integer.parseInt(s[0]);
//        M = Integer.parseInt(s[1]);
//        V = Integer.parseInt(s[2]);
//        List<Integer>[] list = new ArrayList[N+1];
//        for(int i=0;i<N+1;i++){
//            list[i] = new ArrayList<>();
//        }
//        boolean[] visited = new boolean[N+1];
//
//        for(int i=0;i<M;i++){
//            s = br.readLine().split(" ");
//            list[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
//            list[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
//        }
//        for(int i=0;i<N+1;i++){
//            Collections.sort(list[i]);
//        }
//
//        dfs(list, visited, V);
//        System.out.println();
//        visited = new boolean[N+1];
//        bfs(list, visited);
//
//    }
//
//    public static void dfs(List<Integer>[] list, boolean[] visited, int v){
//        if(!visited[v]){
//            System.out.print(v+" ");
//            visited[v]=true;
//            for(int i=0;i<list[v].size();i++){
//                dfs(list,visited,list[v].get(i));
//            }
//        }
//    }
//
//    public static void bfs(List<Integer>[] list, boolean[] visited){
//        visited[V]=true;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(V);
//        System.out.print(V+" ");
//
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i=0;i<size;i++){
//                int temp = q.poll();
//                for(int j=0;j<list[temp].size();j++){
//                    if(!visited[list[temp].get(j)]){
//                        visited[list[temp].get(j)]=true;
//                        q.add(list[temp].get(j));
//                        System.out.print(list[temp].get(j)+" ");
//                    }
//                }
//            }
//        }
//    }
//
//}
