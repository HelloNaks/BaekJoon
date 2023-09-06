import java.util.Scanner;

public class Main {

	static Node[] tree;			//tree
	static int[] min,max;		//각 레벨별 최소, 최대값을 저장
	static int lv=1;			//레벨은 1부터 존재
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N=scann.nextInt();
		tree=new Node[N+1];
		min=new int[N+1];
		max=new int[N+1];
		int root = 0;
		for(int i=0;i<=N;i++) {				//초기화 작업
			tree[i]=new Node(i,-1,-1);
			min[i]=N;
			max[i]=0;
		}
		
		for(int i=1;i<=N;i++) {				//입력된 값을 tree에 저장
			int num=scann.nextInt();
			int left=scann.nextInt();
			int right=scann.nextInt();
			tree[num].left=left;
			tree[num].right=right;
			if(left!=-1)tree[left].parent=num;
			if(right!=-1)tree[right].parent=num;
		}
		// tree의 배열 중 parent 값의 변경이 없는 경우 root이므로 root로 지정
		for(int i=1;i<=N;i++) {
			if(tree[i].parent==-1) {
				root=i;
				break;
			}
		}
		// 번호가 left -> Node -> right로 이동하기때문에 중위순회
		inOrder(root,1);
		int level=1;
		int width=0;
		// 
		for(int i=1;i<=N;i++) {
			int temp=max[i]-min[i];
			if(width<temp) {
				level=i;
				width=temp;
			}
		}
		System.out.println(level+" "+(width+1));
	}
	
	private static void inOrder(int root, int level) {
		Node cur=tree[root];
		if(cur.left!=-1)			//왼쪽에 자식이 있다면
			inOrder(cur.left,level+1);	//중위순회이기에 왼쪽부터 탐색해야함
		min[level] = Math.min(min[level], lv);	//해당 레벨에 가장 왼쪽의 번호
		max[level] = Math.max(max[level], lv);	//해당 레벨에 가장 오른쪽의 번호
		lv++;
		if(cur.right!=-1){			//오른쪽에 자식이 있다면
			inOrder(cur.right,level+1);	//오른쪽으로 탐색
		}
	}

	public static class Node{
		int point;
		int parent;
		int left;
		int right;

		public Node(int point, int left, int right) {
			super();
			this.point = point;
			this.parent=-1;
			this.left = left;
			this.right = right;
		}
	}
}
