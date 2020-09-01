import java.util.*;
public class QUEUEADLL {
	public static class LLToQueueAdapter {
		LinkedList<Integer> list;
		public LLToQueueAdapter() {
			list = new LinkedList<>();
		}
		public int size() {
			return list.size();
		}
		public void add(int val) {
			list.addLast(val);
		}
		public int remove() {
			if (size() == 0) {
				System.out.println("Queue underflow");
				return -1;

			} else {
				return list.removeFirst();
			}
		}

		public int peek() {
			if (size() == 0) {
				System.out.println("Queue underflow");
				return -1;

			} else {
				return list.getFirst();
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		LLToQueueAdapter qu = new LLToQueueAdapter();
		while (str.equals("quit") == false) {
			if (str.startsWith("add")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				qu.add(val);
			} else if (str.startsWith("remove")) {
				int val = qu.remove();
				if (val != -1) {
					System.out.println(val);
				}

			} else if (str.startsWith("peek")) {
				int val = qu.peek();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(qu.size());
			}
			str = scn.nextLine();
		}
	}
}