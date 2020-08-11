import java.util.*;
public class Balanced {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ')') {
				if (st.peek() == '(') {
					st.pop();
				} else {
					while (st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}
			} else  if (ch == ']') {
				if (st.peek() == '[') {
					st.pop();
				} else {
					while (st.peek() != '[') {
						st.pop();
					}
					st.pop();
				}
			} else  if (ch == '}') {
				if (st.peek() == '{') {
					st.pop();
				} else {
					while (st.peek() != '{') {
						st.pop();
					}
					st.pop();
				}
			} else {
				st.push(ch);
			}
		}
		if (st.size() == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}