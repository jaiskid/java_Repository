import java.util.*;
public class isprime {
	public static boolean prime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if (prime(n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}