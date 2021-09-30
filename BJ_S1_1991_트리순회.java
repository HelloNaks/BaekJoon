import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scann = new Scanner(System.in);
		
		int N=scann.nextInt();
		Tree tree = new Tree();
		for (int i = 0; i < N; i++) {
			tree.Add(scann.next().charAt(0),scann.next().charAt(0),scann.next().charAt(0));
		}
		
		tree.Preorder(tree.root);
		System.out.println();
		tree.Inorder(tree.root);
		System.out.println();
		tree.Postorder(tree.root);
	}

	public static class Tree{
		Node root;
		
		public void Add(char c, char left, char right) {
			if(root == null) {
				if(c!='.') root = new Node(c);
				if(left!='.') root.left = new Node(left);
				if(right!='.') root.right = new Node(right);
			}else {
				Search(root,c,left,right);
			}
		}

		//후위
		public void Postorder(Node root) {

			if(root.left!=null) Postorder(root.left);
			if(root.right!=null) Postorder(root.right);
			System.out.print(root.c);
		}

		//중위
		public void Inorder(Node root) {
			if(root.left!=null) Inorder(root.left);
			System.out.print(root.c);
			if(root.right!=null) Inorder(root.right);
		}

		//전위
		public void Preorder(Node root) {
			System.out.print(root.c);
			if(root.left!=null) Preorder(root.left);
			if(root.right!=null) Preorder(root.right);
		}

		private void Search(Node root, char c, char left, char right) {
			if(root==null) return;
			else if(root.c==c) {
				if(left!='.') root.left = new Node(left);
				if(right!='.') root.right = new Node(right); 
			}else {
				Search(root.left,c,left,right);
				Search(root.right,c,left,right);
			}
		}
	}

	public static class Node{
		char c;
		Node left;
		Node right;
		
		public Node(char c) {
			super();
			this.c = c;
		}
	}
}
