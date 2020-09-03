import java.util.*;
public class Lastocc {
	public static int Lastoc(int[]arr, int idx, int key) {
		if (idx == arr.length) {
			return -1;
		}
		int liisa = Lastoc(arr, idx + 1, key);
		if (liisa == -1) {
			if (arr[idx] == key) {
				return idx;
			} else {
				return -1;
			}
		} else {
			return liisa;
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
		System.out.println(Lastoc(arr, 0, key));
	}
}