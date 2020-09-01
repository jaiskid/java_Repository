import java.util.*;
public class NodetoRoot {
	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
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
	public static ArrayList<Integer> NodeToRootPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}
		for (Node child : node.children) {
			ArrayList<Integer> ptc = NodeToRootPath(child, data);
			if (ptc.size() > 0) {
				ptc.add(node.data);
				return ptc;
			}
		}
		return new ArrayList<>();
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
		int data = scn.nextInt();
		ArrayList<Integer> ls = new ArrayList<>();
		ls = NodeToRootPath(root, data);
		for (int item : ls) {
			System.out.print(item + " ");
		}

	}
}
