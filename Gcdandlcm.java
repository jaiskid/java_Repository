import java.util.*;
public class Gcdandlcm {
	public static int gcd(int a, int b) {
		while (a % b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		return b;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int gcdvalue = gcd(a, b);
		System.out.println(gcdvalue);
		System.out.println((a * b) / gcdvalue);
	}
}