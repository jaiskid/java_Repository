import java.util.*;
public class Decreasing {
	public static void decreasing(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		decreasing(n - 1);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		decreasing(n);
	}
}