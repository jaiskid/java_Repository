import java.util.*;
public class Main {
	public static class Node {
		int data;
		ArrayList<Node>children = new ArrayList<>();
	}
	public static Node construct(int[] arr) {
		Node root = null;
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];
				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}
				st.push(t);
			}
		}
		return root;
	}
	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	public static void linearize(Node node) {
		for (Node child :  node.children) {
			linearize(child);
		}
		while (node.children.size() > 1) {
			Node lc = node.children.remove(node.children.size() - 1);
			Node sl = node.children.get(node.children.size() - 1);
			Node slt = getTail(sl);
			slt.children.add(lc);
		}
	}
	private static Node getTail(Node node) {
		while (node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}
	static int msn = 0;
	static int ms = Integer.MIN_VALUE;
	static int retSumAndCalculateMSST(Node node) {
		int sum = 0;
		for (Node child : node.children) {
			int csum = retSumAndCalculateMSST(child);
			sum += csum;
		}
		sum += node.data;
		if (sum > ms) {
			msn = node.data;
			ms = sum;
		}
		return sum;

	}
	static int dia = 0;
	public static int calculateDiameterHeight(Node node) {

		int dch = -1;
		int sdch = -1;
		for (Node child : node.children) {
			int ch = calculateDiameterHeight(child);
			if (ch > dch) {
				sdch = dch;
				dch = ch;
			} else if (ch > sdch) {
				sdch = ch;
			}
		}
		if (dch + sdch + 2 > dia) {
			dia = dch + sdch;
		}
		dch += 1;
		return dch;  
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]  = scn.nextInt();
		}
		Node root = construct(arr);
		// display(root);
		// linearize(root);
		// display(root);
		// retSumAndCalculateMSST(root);
		// System.out.println(msn + "@" + ms);

	}
}