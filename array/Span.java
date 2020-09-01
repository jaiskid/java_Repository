import java.util.*;
public class Span {
	public static int Maximum(int [] span) {
		int max = span[0];
		for (int i = 1; i < span.length; i++) {
			if (max <= span[i]) {
				max = span[i];
			}
		}
		return max;
	}
	public static int Minimum(int [] span) {
		int min = span[0];
		for (int i = 1; i < span.length; i++) {
			if (min >= span[i]) {
				min = span[i];
			}
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] span = new int[n];
		for (int i = 0; i < n; i++) {
			span[i] = scn.nextInt();
		}
		// for (int i = 0; i < n; i++) {
		// 	System.out.print(span[i] + " ");
		// }
		int max = Maximum(span);
		int min = Minimum(span);
		System.out.print(max - min);
		
	}
}