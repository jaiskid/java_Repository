import java.util.*;
public class Balanced {
	public static boolean handlecase(Stack<Character>st, char corresoch) {
		if (st.size() == 0) {
			return false;
		} else if (st.peek() != corresoch) {
			return false;
		} else {
			st.pop();
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Stack<Character> st = new Stack<>();
		//open push close check counterpart available ?
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')') {
				boolean handle = handlecase(st, '(');
				if (handle == false) {
					System.out.print(handle);
					return;
				}
			} else if (ch == '}') {
				boolean handle = handlecase(st, '{');
				if (handle == false) {
					System.out.print(handle);
					return;
				}
			} else if (ch == ']') {
				boolean handle = handlecase(st, '[');
				if (handle == false)
					System.out.print(handle);
				return;
			}
		}
		if (st.size() == 0)
			System.out.print(true);
		else
			System.out.print(false);

	}
}