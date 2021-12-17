import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().toCharArray()[0];
			char l = st.nextToken().toCharArray()[0];
			char r = st.nextToken().toCharArray()[0];
			tree.add(c, l, r);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
	}

	public static class Tree {
		Node root;

		public void add(char c, char l, char r) {
			if(root == null) {
				if(c != '.') root = new Node(c);
				if(l != '.') root.left = new Node(l);
				if(r != '.') root.right = new Node(r);
			}else {
				search(root,c,l,r);
			}
		}
		
		private void search(Node rot, char c, char l, char r) {
			if(rot==null) return;
			if(rot.c==c) {
				rot.left=new Node(l);
				rot.right=new Node(r);
			}
			else {
				search(rot.left,c,l,r);
				search(rot.right,c,l,r);
			}
		}

		public void preOrder(Node r) {
			if(r.c!='.')
				System.out.print(r.c);
			if(r.left!=null) preOrder(r.left);
			if(r.right!=null) preOrder(r.right);
		}

		public void inOrder(Node r) {
			if(r.left!=null) inOrder(r.left);
			if(r.c!='.')
				System.out.print(r.c);
			if(r.right!=null) inOrder(r.right);
		}

		public void postOrder(Node r) {
			if(r.left!=null) postOrder(r.left);
			if(r.right!=null) postOrder(r.right);
			if(r.c!='.')
				System.out.print(r.c);
		}
	}

	public static class Node {
		char c;
		Node left;
		Node right;

		public Node(char c) {
			super();
			this.c = c;
		}
	}

}
