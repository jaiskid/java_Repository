import java.util.*;
public class IsSymetric {
	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

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
		for (Node child :  node.children) {
			str += child.data;
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	public static boolean areMirror(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}
		for (int i = 0; i < n1.children.size(); i++) {
			int j = n1.children.size() - 1 - i;
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(j);
			if (areMirror(c1, c2) == false) {
				return false;
			}
		}
		return true;
	}
	public static boolean Issymetric(Node n1, Node n2) {
		return areMirror(n1, n2);

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = scn.nextInt();
		}
		Node root1 = construct(arr1);
		System.out.println(Issymetric(root1, root1));
	}
}
