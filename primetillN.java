import java.util.*;
public class primetillN {
	public static boolean isprime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args)   {
		Scanner scn = new Scanner(System.in);
		int low = scn.nextInt();
		int high = scn.nextInt();
		for (int i = low; i < high; i++) {
			if (isprime(i))
				System.out.println(i);
		}
	}
}