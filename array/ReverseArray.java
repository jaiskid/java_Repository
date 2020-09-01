import java.util.*;
public class ReverseArray {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();

		}
		int s = 0;
		int e = arr.length - 1;
		while (s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");

		}
	}
}
