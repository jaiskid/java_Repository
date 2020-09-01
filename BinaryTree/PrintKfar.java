import java.util.*;
public class PrintKfar {
	public static class Node {
		int data;
		Node left;
		Node right;
		Node(int data, Node left , Node right) {
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
			this.state  = state;
		}
	}
	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);
		Stack<Pair> st = new Stack<>();
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
				if (arr[idx] != null) {

					top.node.right = new Node(arr[idx], null, null);
					Pair rp  = new Pair(top.node.right, 1);
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
	static ArrayList<Node> path;
	public static boolean find(Node root, int data) {
		// path = new
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			path.add(root);
			return true;
		}
		boolean flic = find(root.left, data);
		if (flic) {
			path.add(root);
			return true;
		}
		boolean flir = find(root.right, data);
		if (flir) {
			path.add(root);
			return true;
		}
		return false;
	}
	public static void kleveldown(Node root, int k, Node blocker) {
		if (root == null || k < 0 || root == blocker) {
			return;
		}
		if (k == 0)
			System.out.println(root.data);
		kleveldown(root.left, k - 1, blocker);
		kleveldown(root.right, k - 1, blocker);
	}
	public static void printKNodesFar(Node node, int data, int k) {
		path = new ArrayList<>();
		find(node, data);
		for (int i = 0; i < path.size(); i++) {
			kleveldown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
		}
	}
	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Integer[] arr = new Integer[n];
		String [] values = scn.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false)
				arr[i] = Integer.parseInt(values[i]);
			else
				arr[i] = null;

		}
		// for (int i = 0; i < arr.length; i++)
		// 	System.out.println(arr[i] + "	");
		Node root = construct(arr);
		int data = Integer.parseInt(scn.nextLine());
		// find(root, data);
		// display(root);
		// for (int i = 0; i < path.size(); i++) {
		// 	int d = path.get(i).data;
		// 	System.out.println(d + " ");
		// }
		int k = Integer.parseInt(scn.nextLine());
		printKNodesFar(root, data, k);
		// display(root);
	}
}
