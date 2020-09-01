import java.util.*;
public class DigitFrequency {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int val = scn.nextInt();
		int count = 0;
		while (n != 0) {
			int rem = n % 10;
			if (rem == val)
				count++;
			n /= 10;
		}
		System.out.println(count);
	}

}