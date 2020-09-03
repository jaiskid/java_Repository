import java.util.*;
public class firstIndex {
	public static int firstIndex(int[]arr, int idx, int key) {
		if (idx == arr.length)
			return -1;
		if (arr[idx] == key)
			return idx;
		else {
			int fiisa = firstIndex(arr, idx + 1, key);
			return fiisa;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int key = scn.nextInt();
		System.out.println(firstIndex(arr, 0, key));
	}
}