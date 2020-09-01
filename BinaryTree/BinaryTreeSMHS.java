import java.util.*;
public class BinaryTreeSMHS {
	public static class Node {
		int data;
		Node left;
		Node right;
		Node(int data , Node left, Node right) {
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
		return root;
	}
	public static void display(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		display(root.left);
		display(root.right);
	}
	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		int ls = size(root.left);
		int rs = size(root.right);
		return ls + rs + 1;
	}
	public static int depth(Node root) {
		if (root == null) {
			return -1;
		}
		int lh = depth(root.left);
		int rh = depth(root.right);
		int final_height = Math.max(lh, rh) + 1;
		return final_height;
	}
	public static int Minelement(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int lm = Minelement(root.left);
		int rm = Minelement(root.right);
		int final_min = Math.min(Math.min(lm, rm), root.data);
		return final_min;
	}
	public static int Maxelement(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int lm = Maxelement(root.left);
		int rm = Maxelement(root.right);
		int final_max = Math.max(Math.max(lm, rm), root.data);
		return final_max;
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
		System.out.println(size(root));
		System.out.println(sum(root));
		System.out.println(Maxelement(root));
		System.out.println(depth(root));
		


	}
}