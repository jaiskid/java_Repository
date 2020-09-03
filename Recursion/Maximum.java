import java.util.*;
public class Maximum {
	public static int maximum(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			return arr[idx];
		}
		int max = maximum(arr, idx + 1);
		if (max > arr[idx])
			return max;
		else
			return arr[idx];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int max = maximum(arr, 0);
		System.out.println(max);
	}
}