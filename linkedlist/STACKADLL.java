import java.util.*;
public class STACKADLL {
	public static class stackapt {
		LinkedList<Integer> list;
		public stackapt () {
			list = new LinkedList<>();
		}
		int size() {
			return list.size();
		}
		void  push(int val) {
			list.addFirst(val);
		}
		int pop() {
			if (size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
 
			else {
				return list.removeFirst();
			}
		}
		int top() {
			if (size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				return list.getFirst();
			}
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		stackapt st = new stackapt();
		String str = scn.nextLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.startsWith("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(st.size());
			}
			str = scn.nextLine();
		}
	}

}