import java.util.*;
public class Minimum1 {
	public static class MinStack {
		Stack<Integer>allData;
		Stack<Integer>minData;
		public MinStack() {
			allData = new Stack<>();
			minData = new Stack<>();
		}
		int size() {
			return allData.size();
		}
		void push(int val) {
			allData.push(val);
			if (minData.size() == 0 || val <= minData.peek())
				minData.push(val);
		}
		int pop() {
			if (size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				int val = allData.pop();
				if (val == minData.peek()) {
					minData.pop();
				}
				return val;
			}
		}
		int top() {
			if (size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				return allData.peek();
			}
		}
		int min() {
			if (size( ) == 0) {
				System.out.println("Stack underflow");
				return -1;
			} else {
				return minData.peek();
			}
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		MinStack st = new MinStack();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.equals("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.equals("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("min")) {
				int val = st.min();
				if (val != -1) {
					System.out.println(val);
				}
			}
			str = scn.nextLine();
		}
	}
}