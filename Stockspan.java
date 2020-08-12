import java.util.*;
public class Stockspan {
	public static int [] stock(int[] arr) {
		int [] span = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] > arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				span[i] = i + 1;
			} else {
				span[i] = i - st.peek();
			}
			st.push(i);
		}
		return span;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int [] span = new int[arr.length];
		span  = stock(arr);
		for (int i = 1; i < span.length; i++) {
			System.out.print(span[i] + " ");
		}
	}

}