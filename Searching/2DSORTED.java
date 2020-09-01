import java.util.*;
public class SORTED {
	static int row;
	static int col;
	public static void finder(int[][] arr, int key) {
		int i = 0;
		int j = arr[0].length - 1;
		while (i <= arr.length && j >= 0) {
			if (arr[i][j] == key) {
				row = i;
				col = j;
				break;
			} else if (arr[i][j] > key) {
				j--;
			} else {
				i++;
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		int key = scn.nextInt();
		row = -1;
		col = -1;
		finder(arr, key);
		if (row != -1) {
			System.out.println(row);
		} else {
			System.out.println("Not found");
		}
		if (col != -1) {
			System.out.println(col);
		} else {
			System.out.println("Not found");
		}
	}
}