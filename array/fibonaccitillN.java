import java.util.*;
public class fibonaccitillN {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 0;
		int b = 1;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			System.out.print(a + " ");
			sum = a + b;
			b = a;
			a = sum;
		}

	}
}