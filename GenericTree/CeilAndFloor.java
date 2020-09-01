import java.util.*;
public class CeilAndFloor {
	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	public static Node construct(int[] arr) {
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
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}
	static Node predecessor;
	static Node successor;
	static int state;
	public static void Preducsuc(Node node, int data) {
		if (state == 0) {
			if (node.data == data) {
				state++;
			} else {
				predecessor = node;
			}
		} else if (state == 1) {
			successor = node;
			state ++;
		}
		for (Node child : node.children) {
			Preducsuc(child, data);
		}
	}
	static int ceil;
	static int floor;
	public static void CeilAndFlo(Node node, int data) {
		if (node.data > data) {
			if (node.data < ceil)
				ceil = node.data;
		}
		if (node.data < data) {
			if (node.data > floor)
				floor = node.data;
		}
		for (Node child : node.children) {
			CeilAndFlo(child, data);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int data = scn.nextInt();
		Node root = construct(arr);
		predecessor = null;
		successor = null;
		state = 0;
		//  Preducsuc(root, data);
		// if (predecessor != null)
		// 	System.out.println("Predecessor = " + predecessor.data);
		// else
		// 	System.out.println("Predecessor = Not found");
		// if (successor != null)
		// 	System.out.println("Successor = " + successor.data);
		// else
		// 	System.out.println("Successor = Not found");

		ceil = Integer.MAX_VALUE;
		floor = Integer.MIN_VALUE;
		CeilAndFlo(root, data);
		System.out.println("CEIL = " + ceil);
		System.out.println("FLOOR = " + floor);
	}
}