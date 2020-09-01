import java.util.*;
public class Ceilandfloorarr {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int data = scn.nextInt();
		int low = 0;
		int hi = arr.length - 1;
		int ceil = 0;
		int floor = 0;
		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			if (data < arr[mid]) {
				hi = mid - 1;
				ceil = arr[mid];
			} else if (data > arr[mid]) {
				low = mid + 1;
				floor = arr[mid];
			} else {
				ceil = arr[mid];
				floor = arr[mid];
			}
		}
		System.out.println(ceil);
		System.out.println(floor);
	}
}