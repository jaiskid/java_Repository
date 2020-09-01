import java.util.*;
public class Celebrity {
	public static findCelebrity(int [][] arr) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}
		while (st.size() > 2) {
			int i = st.pop();
			int j = st.pop();
			if (arr[i][j] == 1) {
				//if i knows j it means i is not celebrity
				st.push(j);
			} else {
				// If i doesnot know j it means j is not celebrity problem
				st.push(i);
			}
		}
		int pot = st.pop();
		for (int i = 0; i < arr.length; i++) {
			if (i != pot) {
				if (arr[i][pot] == 0 || arr[pot][i] == 1) {
					System.out.print("none");
					return;
				}
			}
		}
		System.out.println(pot);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}
}