import java.util.*;
public class Waveprint {
	static int[][] arr;
	static int n, m;
	public static void display() {

		for (int j = 0; j < m; j++) {
			if (j % 2 == 1) {
				for (int i = n - 1; i >= 0; i--)
					System.out.print(arr[i][j] + " ");
			} else {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		display();
	}
}