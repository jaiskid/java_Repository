import java.util.*;
public class AreTreeSimilar {
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
					root  = t;

				}
				st.push(t);
			}
		}
		return root;
	}
	public static void display(Node node) {
		String str  = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	public static ArrayList<Integer> nodetopath(Node node , int data) {
		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}
		for (Node child : node.children) {
			ArrayList ptc = nodetopath(child, data);
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
		p1 = nodetopath(node , d1);
		p2 = nodetopath(node , d2);
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
	public static boolean areTreeSimilar(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}
		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(i);
			if (areTreeSimilar(c1, c2) == false) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = scn.nextInt();
		}
		Node root1 = construct(arr1);
		Node root2 = construct(arr2);
		// display(root1);
		// display(root2);
		System.out.println(areTreeSimilar(root1, root2));
	}
}
