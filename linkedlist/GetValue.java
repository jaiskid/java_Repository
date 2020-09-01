import java.util.*;
public class GetValue {
	public static class Node {
		int data;
		Node next;
	}
	public static class LinkedList {
		Node head;
		Node tail;
		int size;
		public void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if (size == 0) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}
			size++;
		}
		public void display() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
		public void removeFirst() {
			if (size == 0) {
				System.out.print("list is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				head = head.next;
				size--;
			}
		}
		public int size() {
			return size;
		}
		public int getFirst() {
			if (size == 0) {
				System.out.println("list is empty");
				return -1;
			} else {
				return head.data;
			}
		}
		public int getLast() {
			if (size == 0) {
				System.out.println("list is empty");
				return -1;
			} else {
				return tail.data;
			}
		}
		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("list is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid Arguments");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LinkedList link = new LinkedList();
		String str = scn.nextLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("addLast")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				link.addLast(val);
			} else if (str.startsWith("removeFirst")) {
				link.removeFirst();
			} else if (str.startsWith("getFirst")) {
				System.out.println(link.getFirst());
			} else if (str.startsWith("getLast")) {
				System.out.println(link.getLast());
			} else if (str.startsWith("getAt")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				System.out.println(link.getAt(val));
			}
			str = scn.nextLine();
		}
	}
}