import java.util.*;
public class LevelOTA {
	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
		Node() {

		}
		Node(int data) {
			this.data = data;
		}
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
	public static int max(Node node ) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			int cm = max(child);
			max = Math.max(max, cm);
		}
		max = Math.max(max, node.data);
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
	public static int size(Node node) {
		int s = 0;
		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;
		return s;
	}
	public static void traversal(Node node) {
		System.out.println("Node pre " + node.data);
		for (Node child : node.children) {
			System.out.println("Edge pre " + child.data + "--" + node.data);
			traversal(child);
			System.out.println("Edge post " + child.data + "--" + node.data);

		}
		System.out.println("Node post " + node.data);
	}
	public static void level(Node node) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		while (q.size() > 0) {
			node = q.remove();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				q.add(child);
			}
		}
		System.out.println();
	}
	public static void levelwise(Node node ) {
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

			}
		}
	}
	public static void levelwiseZigzag(Node node ) {
		Stack<Node> ms = new Stack<>();
		Stack<Node> cs = new Stack<>();
		ms.push(node);
		int level = 1;
		while (ms.size() > 0) {
			node = ms.pop();
			if (level % 2 == 1) {
				for (int i = 0; i < node.children.size(); i++) {
					cs.push(node.children.get(i));

				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					cs.push(node.children.get(i));

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
	public static void levelOrderLinewise2(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		mq.add(new Node(-1));
		while (mq.size() > 0) {
			node = mq.remove();
			if (node.data != -1) {
				System.out.print(node.data + " ");
				for (Node child : node.children) {
					mq.add(child);

				}
			} else {
				if (mq.size() > 0) {
					mq.add(new Node(-1));
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		Node root = construct(arr);
		traversal(root);
		level(root);
		display(root);
		levelwise(root);
		levelwiseZigzag(root);
		levelOrderLinewise2(root);
		System.out.println("Height " + height(root));
		System.out.println("Size " + size(root));
		System.out.println("Max " + max(root));
	}
}

