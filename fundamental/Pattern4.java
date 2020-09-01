import java.util.*;
public class Pattern4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k <= n; k++) {
				for (int r = 1; r <= k; r++) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}
