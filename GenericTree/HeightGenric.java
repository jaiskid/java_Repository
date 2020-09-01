import java.util.*;
public class HeightGenric {
	public static class Node {
		int data;
		ArrayList<Node>children = new ArrayList<>();
	}
	public static void display(Node node) {
		String str = node.data + " - >";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
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
	public static int size(Node node) {
		int s = 0;
		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;
		return s;
	}
	public static int max(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			int cm = max(child);
			max = Math.max(max, cm);
		}
		max = Math.max(node.data, max);
		return max;
	}
	public static int height(Node node) {
		int ht = -1;
		for (Node child : node.children) {
			int ch = height(child);
			ht = Math.max(ch, ht);
		}
		ht += 1;
		return ht;
	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int [n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		// display(root);
		// System.out.println(max(root));
		System.out.println(height(root));
	}
}