import java.util.*;
public class printKlevelDown {
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
		Pair(Node node, int state) {t 
			this.node = node;
			this.state = state;
		}
	}
	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);
		Stack<Pair>st = new Stack<>();
		st.push(rtp);
		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}
				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {r
					top.node.right = new Node(arr[idx] , null, null);
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
		System.out.print(root.data + "	");
		display(root.left);
		display(root.right);
	}
	public static void printKleveldown(Node root , int k) {
		if (root == null || k < 0)
			return;
		if (k == 0)
			System.out.print(root.data + " ");
		printKleveldown(root.left, k--);
		printKleveldown(root.right, k--);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Integer[] arr = new Integer[n];
		String[] values = scn.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false)
				arr[i] = Integer.parseInt(values[i]);
			else
				arr[i] = null;
		}
		Node root = construct(arr);
		// display(root);
		printKleveldown(root, 2);
	}
}