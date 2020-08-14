import java.util.*;
public class DynamicStack {
	public static class Dynamic {
		int[] data;
		int tos;
		public Dynamic(int cap) {
			data = new int[cap];
			tos = -1;
		}
		void push(int val) {
			if (tos == data.length - 1 ) {
				int [] ndata = new int[2 * data.length];
				for (int i = 0; i < data.length; i++) {
					ndata[i] = data[i];

				}
				data = ndata;
				tos++;
				data[tos] = val;
			} else {
				tos++;
				data[tos] = val;
			}
		}
		int top() {
			if (tos == -1) {
				System.out.println("Stack Underflow");
				return -1;
			} else {
				int val = data[tos];
				return val;

			}
		}
		int size() {
			return tos + 1;
		}
		int pop() {
			if (tos == -1) {
				System.out.print("Stack Underflow");
				return -1;
			} else {
				int val = data[tos];
				tos--;
				return val;
			}
		}
		void display() {
			for (int i = tos ; i >= 0; i--) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Dynamic st = new Dynamic(n);
		String str = scn.nextLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.startsWith("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("display")) {
				st.display();
			}
			str = scn.nextLine();
		}
	}
}