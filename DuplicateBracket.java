import java.util.*;
//( , a  + b push 
// ) pop until you didn't find the counter part
//if the first character is ) it mean it doesn't have any own contained
public class DuplicateBracket {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String a = scn.nextLine();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			if (ch == ')' ) {
				if (st.peek() == '(') {
					System.out.println(true);
					return;
				} else {
					while (st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}
			} else { 
				st.push(ch);
			}
		}
		System.out.println(false);
	}
}