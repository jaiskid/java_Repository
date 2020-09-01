import java.util.*;
public class SORTED {
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
		int i = 0;
		int j = arr[0].length - 1;
		while (i < arr.length && j >= 0) {
			if (arr[i][j] == key) {
				System.out.println(i);
				System.out.println(j);
				return;
			} else if (arr[i][j] > key) {
				j--;
			} else {
				i++;
			}
		}
		System.out.println("Not Found");
	}
}