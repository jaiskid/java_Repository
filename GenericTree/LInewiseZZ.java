import java.util.*;
public class LInewiseZZ {
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
		String str = node.data + "-->";
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
		return Math.max(node.data , max);
	}
	public static void Traversal(Node node) {
		System.out.println("Node Pre" + node.data);
		for (Node child : node.children) {
			System.out.println("Edge Pre" + child.data + "--" + node.data);
			Traversal(child);
			System.out.println("Edge Post" + child.data + "--" + node.data);

		}
		System.out.println("Node Post" + node.data);
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
	public static void LevelLinewise(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		Queue<Node> cq = new ArrayDeque<>();
		mq.add(node);
		while (mq.size() > 0) {
			node = mq.remove();  
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				cq.add(child);
			}
			if (mq.size() == 0) {
				mq = cq;
				cq = new ArrayDeque<>();
				System.out.println();
			}
		}
	}
	public static void LInewiseLevelZZ(Node node) {
		Stack<Node> ms = new Stack<>();
		Stack<Node> cs = new Stack<>();
		ms.push(node);
		int level = 1;
		while (ms.size() > 0) {
			node = ms.pop();
			System.out.print(node.data + " ");
			if (level % 2 == 1) {
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}
			if (ms.size() == 0) {
				ms = cs;
				cs = new Stack<>();
				level++;
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		// LevelLinewise(root);
		// LevelOrder(root);
		LInewiseLevelZZ(root);

	}
}