import java.util.*;
public class Sliding {
	public static void main(String[] args) {
		//isme stack me array ke index push ho rahe he
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Stack<Integer> st = new Stack<>();
		int k = scn.nextInt();
		int[] nge = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		st.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			// -a+
			while (st.size() > 0  && arr[i] > arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				nge[i] = arr.length;
			} else {
				nge[i] = st.peek();
			}
			st.push(i);
		}
		int j = 0;
		for (int i = 0; i <= arr.length - k; i++) {
			//enter the loop to find the maximum starting at i
			if ( j < i)
				j = i;
			while (nge[j] < i + k) {
				j = nge[j];
			}
			System.out.println(arr[j]);
		}
	}
}