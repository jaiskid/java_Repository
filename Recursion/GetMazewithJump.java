import java.util.*;
public class GetMazewithJump {
	public static ArrayList<String> getmazePaths(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		ArrayList<String> paths = new ArrayList<>();
		//horizontal moves
		for (int ms = 1; ms <= dc - sc; ms++) {
			ArrayList<String> hpaths = getmazePaths(sr, sc + ms, dr, dc);
			for (String hpath : hpaths) {
				paths.add("h" + ms + hpath);
			}
		}
		//vertical moves
		for (int ms = 1; ms <= dr - sr; ms++) {
			ArrayList<String> vpaths = getmazePaths(sr + ms, sc, dr, dc);
			for (String vpath : vpaths) {
				paths.add("v" + ms + vpath);
			}
		}
		return paths;
	}
	public static void main(String[] args) {
		Scanner scn =  new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		ArrayList<String> paths = getmazePaths(1, 1, n, m);
		System.out.println(paths);
	}
}