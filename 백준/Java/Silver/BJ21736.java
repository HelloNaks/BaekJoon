import java.util.*;
public class BJ21736 {
    public static int[][] arr;
    public static boolean[][] visited;
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};
    private static int answer = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        arr = new int[r][c];
        visited = new boolean[r][c];

        int ir=0;
        int ic=0;
        // 배열 입력 받기
        for(int i=0;i<r;i++){
            String st = sc.nextLine();
            for(int j=0;j<c;j++){
                if(st.charAt(j)=='O'){              // 공간
                    arr[i][j] = 0;
                }else if(st.charAt(j)=='I'){        // 본인
                    arr[i][j] = 1;
                    ir=i;
                    ic=j;
                }else if(st.charAt(j)=='P'){        // 사람
                    arr[i][j] = 2;
                }else if(st.charAt(j)=='X'){        // 벽
                    arr[i][j] = 3;
                }
            }
        }



        Queue<Node> q = new LinkedList<>();
        q.add(new Node(ir,ic));
        visited[ir][ic]=true;

        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++) {
                Node n = q.poll();
                for(int d=0;d<4;d++){
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];

                    if(isChecked(nr,nc, r, c)){
                        if(!visited[nr][nc]){
                            if(arr[nr][nc]==0) {
                                q.add(new Node(nr, nc));
                                visited[nr][nc]=true;
                            }
                            if(arr[nr][nc]==2){
                                q.add(new Node(nr, nc));
                                answer++;
                                arr[nr][nc]=0;
                                visited[nr][nc]=true;
                            }
                        }
                    }
                }
            }
        }
        if(answer!=0) {
            System.out.println(answer);
        }else {
            System.out.println("TT");
        }
    }
    public static boolean isChecked(int nr, int nc, int r, int c){
        return nr>=0 && nc>=0 && nr<r && nc<c;
    }
    public static class Node{
        int r;
        int c;

        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
