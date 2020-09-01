import java.util.*;
public class RotateK {
	public static void reverse(int[] arr, int s, int e) {
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}

	}
	public static void rotate(int[] arr, int k) {
		k = k % arr.length;
		if (k < 0) {
			k += arr.length;
		}
		//part 1
		reverse(arr, 0, arr.length - k - 1);
		//part 2
		reverse(arr, arr.length - k, arr.length - 1);
		//all
		reverse(arr, 0, arr.length - 1);

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		rotate(arr, k);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}