import java.util.*;
public class printKeypadCombination {
	static String[] codes = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwxyz"};
	public static void printKpc(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		//remaining question
		String roq = ques.substring(1);
		String codeforch = codes[ch - '0'];
		for (int i = 0; i < codeforch.length(); i++) {
			char cho = codeforch.charAt(i);
			printKpc(roq , ans + cho);
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		printKpc(str , "");
	}
}