import java.util.*;
public class firstLast {
	public static int first(int[] arr, int data, int s, int e) {
		int first = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == data) {
				first = mid;
				e = mid - 1;
			} else if (arr[mid] < data) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return first;
	}
	public static int second(int[] arr, int data, int s, int e) {
		int last = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] == data) {
				last = mid;
				s = mid + 1;
			} else if (arr[mid] < data) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return last;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int data = scn.nextInt();
		System.out.println(first(arr, data, 0, arr.length - 1));
		System.out.println(second(arr, data, 0, arr.length - 1));
	}
}