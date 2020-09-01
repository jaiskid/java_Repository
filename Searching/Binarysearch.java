import java.util.*;
public class Binarysearch {
	public static int bs(int[]arr , int s, int e , int key) {
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] < key) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int key = scn.nextInt();
		System.out.println(bs(arr, 0, arr.length - 1, key));
	}
}