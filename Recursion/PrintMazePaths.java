import java.util.*;
public class PrintMazePaths {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		printmaze(1, 1, n, m, "");
	}
	public static void printmaze(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		for (int ms = 1 ; ms <= dc - sc; ms++) {
			printmaze(sr , sc + ms, dr, dc, psf + "h" + ms);
		}
		for (int ms = 1; ms <= dr - sr; ms++) {
			printmaze(sr + ms, sc, dr, dc, psf + "v" + ms);
		}
		for (int ms = 1 ; ms <= dr - sr && ms <= dc - sc; ms++) {
			printmaze(sr + ms, sc + ms, dr, dc, psf + "d" + ms);
		}
	}
}