import java.util.*;
public class LevelOrder {
	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	public static Node construct(int [] arr) {
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
		String str = node.data + "-- >";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	public static int size(Node node) {
		int s = 0;
		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;
		return s;
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
	public static int max(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			int cm = max(child);
			max = Math.max(cm, max);
		}
		return Math.max(node.data, max);
	}
	public static void traversal(Node node) {
		//area 1
		//Euler left path
		System.out.println("Node Pre " + node.data);
		for (Node child : node.children) {
			//Edge pre
			System.out.println("Edge Pre " + node.data + "--" + child.data);
			traversal(child);
			System.out.println("Edge Post" + node.data + "--" + child.data);
		}
		//Euler right paths
		System.out.println("Node Post " + node.data);
	}
	public static void LevelOrder(Node node) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		while (q.size() > 0) {
			node = q.remove();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				q.add(child);
			}
		}
		System.out.print(".");
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		display(root);
		// System.out.println(max(root));
		// System.out.println(height(root));
		// traversal(root);
		LevelOrder(root);
	}

}