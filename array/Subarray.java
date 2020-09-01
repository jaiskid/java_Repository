import java.util.*;
public class Subarray {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = 0; k <= j; k++) {
					System.out.println(arr[k] + " ");
				}
			}
		}
	}
}