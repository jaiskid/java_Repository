import java.util.*;
public class Digitofnumber {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// String n = scn.nextInt();
		// for (int i = 0; i < n.length(); i++) {
		// 	System.out.println(n.charAt(i));
		// }
		int n = scn.nextInt();
		int nod = 0;
		int temp = n;
		while (temp != 0) {
			temp = temp / 10;
			nod++;
		}
		int div = (int)Math.pow(10, nod - 1);
		while (n != 0) {
			int q = n / div;
			System.out.println(q);
			n = n % div;
			div = div / 10;
		}
	}
}