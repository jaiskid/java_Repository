import java.util.*;
public class Disp {
	public static void display_Arr(int[]arr, int idx) {
		if (idx == arr.length) {
			return;
		}
		System.out.println(arr[idx]);
		display_Arr(arr, idx + 1);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		display_Arr(arr, 0);
	}
}