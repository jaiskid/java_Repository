import java.util.*;
public class Allindices {
	static ArrayList<Integer> arr1;
	public static ArrayList<Integer> Allindice(int[]arr, int key, int idx) {
		if (idx == arr.length) {
			return new ArrayList<>();
		}
		if (arr[idx] == key) {
			arr1.add(idx);
		}
		Allindice(arr, key, idx + 1);
		return new ArrayList<>();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int key = scn.nextInt();
		arr1 = new ArrayList<>();
		arr1 = Allindice(arr, key, 0);
		for (Integer item : arr1) {
			System.out.println(item);
		}
	}
}`