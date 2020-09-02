import java.util.*;
public class Incdec {
	public static void decinc(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		decinc(n - 1);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		decinc(n);

	}
}