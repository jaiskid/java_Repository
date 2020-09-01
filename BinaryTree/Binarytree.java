import java.util.*;
public class Binarytree {
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
	public	static class Pair {
		Node node;
		int state;
		Pair(Node node , int state) {
			this.node = node;
			this.state = state;
		}
	}
	public static void print(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}
	public static int sum(Node root) {
		if (root == null) {
			return 0;

		}
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		int final_sum = lsum + rsum + root.data;
		return final_sum;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		//state one is left
		//state two is right
		//state three is pop
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
					top.node.left = new Node(arr[idx] , null , null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}
				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != -1) {
					top.node.right = new Node(arr[idx] , null , null);
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
		print(root);
	}
}