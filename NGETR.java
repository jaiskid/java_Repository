import java.util.*;
public class NGETR {
	public static int[] solve(int[] arr) {
		int [] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr[arr.length - 1]);
		nge[arr.length - 1] = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			//-a+
			while (st.size() > 0 && arr[i] >= st.peek()) {
				// pop until you didn't find any big value compare to itself
				st.pop();
			}
			if (st.size() == 0) {
				// if stack is exhausted then it's mean stack is empty and there is no greater element then itself
				nge[i] = -1;
			} else {
				//this case is for when the current value find the value greater than itself
				nge[i] = st.peek();
			}

			st.push(arr[i]);
		}
		return nge;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int [] nge = new int[n];
		nge = solve(arr);
		for (int i = 0; i < nge.length; i++) {
			System.out.print(nge[i] + " ");
		}
	}
}