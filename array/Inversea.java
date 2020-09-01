import java.util.*;
public class Inversea {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int[] newarr = new int[n];
		for (int i = 0; i < newarr.length; i++) {
			newarr[arr[i]] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(newarr[i] + " ");
		}
	}
}