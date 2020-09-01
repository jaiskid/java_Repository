import java.util.*;
public class DistanceBN {
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
		for (Node child : node.children) {
			str += child.data + ", ";

		}
		str += ".";
		System.out.println(str);
		for (Node child  : node.children) {
			display(child);
		}
	}
	public static ArrayList<Integer> nodetoPath(Node node , int data) {
		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}
		for (Node child : node.children) {
			ArrayList<Integer> ptc = nodetoPath(child, data);
			if (ptc.size() > 0) {
				ptc.add(node.data);
				return ptc;
			}
		}
		return new ArrayList<>();
	}
	public static int lca(Node node , int d1, int d2) {
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> p2 = new ArrayList<>();
		p1 = nodetoPath(node, d1);
		p2 = nodetoPath(node, d2);
		int i = p1.size() - 1;
		int j = p2.size() - 1;
		while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return p1.get(i);
	}
	public static int Distance(Node node , int d1, int d2) {
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> p2 = new ArrayList<>();
		p1 = nodetoPath(node, d1);
		p2 = nodetoPath(node, d2);
		int i = p1.size() - 1;
		int j = p2.size() - 1;
		while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;

		}
		i++;
		j++;
		return i + j;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		display(root);
		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		System.out.println(Distance(root, d1, d2));

	}
}