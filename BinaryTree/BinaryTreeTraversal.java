import java.util.*;
public class BinaryTreeTraversal {
	public static class Node {
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static class Pair {
		Node node;
		int state;
		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}
	public static Node construct(int[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair r = new Pair(root, 1);
		Stack<Pair> st = new Stack<>();
		st.push(r);
		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != -1) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}
				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != -1) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}
				top.state++;
			} else {
				st.pop();
			}

		}
		return root;
	}
	public static void display(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data + " ");
		display(root.left);
		display(root.right);
	}
	public static void Inorder(Node root) {
		if (root == null) {
			return;
		}
		Inorder(root.left);
		System.out.println(root.data + " ");
		Inorder(root.right);
	}
	public static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data + " ");
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// int n = scn.nextInt();
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// 	arr[i] = scn.nextInt();
		// }
		int n = Integer.parseInt(scn.nextLine());
		int [] arr = new int[n];
		String[] values = scn.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = -1;
			}
		}
		Node root = construct(arr);
		// display(root);
		Inorder(root);
	}
}