import java.util.*;
public class Removelink {
	public static class Node {
		int data;
		Node next;
	}
	public static class Linklist {
		Node head;
		Node tail;
		int size;
		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if (size == 0) {
				head = tail = temp;
			} else {
				//current
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
		public int size() {
			return size;
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
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Linklist list = new Linklist();
		String str = scn.nextLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("addLast")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				list.addLast(val);
			} else if (str.startsWith("size")) {
				System.out.println(list.size());
			} else if (str.startsWith("display")) {
				list.display();   
			} else if (str.startsWith("removeFirst")) {
				list.removeFirst();
			}
			str = scn.nextLine();
		}
	}
}
