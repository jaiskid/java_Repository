import java.util.*;
public class countdigit {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		System.out.print(count);
	}
}