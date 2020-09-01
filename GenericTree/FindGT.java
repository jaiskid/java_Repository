import java.util.*;
public class FindGT {
	public static class Node {
		int data ;
		ArrayList<Node> children = new ArrayList<>();
	}
	public static Node construct(int [] arr) {
		Stack<Node> st = new Stack<>();
		Node root = null;
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
			str += child.data + " ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	public static boolean find(Node node, int key) {
		if (node.data == key) {
			return  true;
		}
		for (Node child : node.children) {
			boolean fic = find(child, key);
			if (fic) {
				return true;
			}

		}
		return false;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		display(root);
		int key = scn.nextInt();
		System.out.println(find(root, key));
	}
}