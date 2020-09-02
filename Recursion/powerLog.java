import java.util.*;
public class powerLog {
	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		int smallpower = power(x, n / 2);
		int bigpower = smallpower * smallpower;
		if (n % 2 == 0)
			return bigpower;
		else
			return x * bigpower;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int n = scn.nextInt();
		System.out.println(power(x, n));
	}
}