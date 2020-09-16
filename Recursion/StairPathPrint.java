import java.util.*;
public class StairPathPrint {
	public static void pathPrint(int n , String path) {
		if (n < 0) {
			return;
		}
		if (n == 0) {
			System.out.println(path);
			return;
		}
		pathPrint(n - 1, path + "1");
		pathPrint(n - 2, path + "2");
		pathPrint(n - 3, path + "3");

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		pathPrint(n, "");
	}
}