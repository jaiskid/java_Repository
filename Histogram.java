import java.util.*;
public class Histogram {
	public static int[] NseR(int []arr) {
		// is me stack ke andar jaa rahe he index
		Stack<Integer> st = new Stack<>();
		int rb [] = new int[arr.length];

		st.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2 ; i >= 0 ; i--) {
			//bade ko pop karwana he
			while (st.size() >  0 && arr[i] <= arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				rb[i] = arr.length;
			} else {
				rb[i] = st.peek();
			}
			st.push(i);
		}
		return rb;
	}
	public static int[] NseL(int []arr) {
		// is me stack ke andar jaa rahe he index
		Stack<Integer> st = new Stack<>();
		int lb [] = new int[arr.length];

		st.push(0);
		lb[0] =	-1;
		for (int i = 1; i < arr.length; i++) {
			//bade ko pop karwana he
			while (st.size() >  0 && arr[i] <= arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				lb[i] = -1;
			} else {
				lb[i] = st.peek();
			}
			st.push(i); 
		}
		return lb;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		// int [][] arr = new int[n][n];
		// for (int i = 0; i < arr.length; i++) {
		// 	for (int j = 0; j < arr[i].length; j++) {
		// 		arr[i][j] = scn.nextInt();
		// 	}
		// }
		// for (int i = 0; i < arr.length; i++) {
		// 	for (int j = 0; j < arr[i].length; j++) {
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int [] rb = new int[arr.length];
		int [] lb = new int[arr.length];
		lb = NseL(arr);
		rb = NseR(arr);
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = arr[i] * width;
			if (area > maxArea) {
				maxArea = area;
			}
		}
		System.out.println(maxArea);
	}
}