import java.util.*;
public class GetStairsPaths {
	public static ArrayList<String> getStairsPath(int n) {
		if (n == 0) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		if (n < 0) {
			ArrayList<String> bres = new ArrayList<>();
			return bres;
		}
		ArrayList<String> path1 = getStairsPath(n - 1);
		ArrayList<String> path2 = getStairsPath(n - 2);
		ArrayList<String> path3 = getStairsPath(n - 3);
		ArrayList<String> path = new ArrayList<>();
		for (String item : path1) {
			path.add("1" + item );
		}
		for (String item : path2) {
			path.add("2" + item);
		}
		for (String item : path3) {
			path.add("3" + item);
		}
		return path;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<String>paths = new ArrayList<>();
		paths = getStairsPath(n);
		System.out.println(paths);
	}
}