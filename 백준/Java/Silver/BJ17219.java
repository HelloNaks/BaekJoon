import java.util.*;

public class BJ17219 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        ArrayList<account> accounts = new ArrayList<>();


        for(int i=0;i<N;i++){
            String[] arr = sc.nextLine().split(" ");

            accounts.add(new account(arr[0], arr[1]));
        }

        Collections.sort(accounts, new Comparator<account>() {
            @Override
            public int compare(account o1, account o2) {
                return o1.site.compareTo(o2.site);
            }
        });

        int left = 0;
        int right = N-1;
        int mid = (left+right)/2 -1;

        for(int i=0;i<M;i++){
            String s = sc.nextLine();
            left = 0;
            right = N-1;
            mid = left + right / 2;

            while(true){
                if(accounts.get(mid).site.equals(s)){
                    System.out.println(accounts.get(mid).pw);
                    break;
                }else if(accounts.get(mid).site.compareTo(s)>0){
                    right = mid-1;
                    mid = (left+right)/2;
                }else {
                    left = mid+1;
                    mid = (left+right)/2;
                }
            }
        }

    }


    public static class account{
        String site;
        String pw;

        public account(String site, String pw){
            this.site = site;
            this.pw = pw;
        }

    }
}
