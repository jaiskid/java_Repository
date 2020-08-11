import java.util.*;
public class Felement {
	public static boolean Find(int [] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int key = scn.nextInt();
		if (Find(arr, key)) {
			System.out.println("found");
		} else {
			System.out.println("Not exist");
		}
	}
}