import java.util.*;
public class Sumofarray {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = scn.nextInt();
		}
		int[] sum = new int[n > m ? n : m ];
		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int k = sum.length - 1;
		int c = 0;
		while (k >= 0) {
			int d = c;
			if (i >= 0) {

				d += arr1[i];
			}
			if (j >= 0) {
				d += arr2[j];
			}
			c = d / 10;
			d = d % 10;
			sum[k] = d;
			i--;
			j--;
			k--;
		}
		if (c != 0) {
			System.out.print(c);
		}
		for (int val : sum)
			System.out.print(val);
	}


}