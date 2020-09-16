import java.util.*;
public class countingSort {
	public static void counting_sort(int [] a, int max, int n) {
		int[] count = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + " ");
		}
		System.out.println();
		for (int i = 0; i <= max; i++) {
			for (int j = 1; j <= count[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		counting_sort(a, max, n);
	}
}