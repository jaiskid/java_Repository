import java.util.*;
public class NormalStack {
	public static class Customstack {
		int [] data;
		int tos;
		public Customstack(int cap) {
			data = new int[cap];
			tos = -1;
		}
		int size() {
			return tos + 1;
		}
		void display() {
			for (int i = tos ; i >= 0; i--) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		void push(int val) {
			if (tos == data.length - 1) {
				System.out.print("Stack overflow");
			} else {
				tos++;
				data[tos] = val;
			}
		}
		int top() {
			if (tos == -1) {
				System.out.print("Stack underflow");
				return -1;
			} else {
				int val = data[tos];
				return val;
			}
		}
		int pop() {
			if (tos == -1) {
				System.out.print("Stack underflow");
				return -1;
			} else {
				int val = data[tos];
				tos--;
				return val;
			}
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Customstack  st = new Customstack(n);
		String str  = scn.nextLine();
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
			} else if (str.startsWith("display")) {
				st.display();
			}
			str = scn.nextLine();
		}

	}


}