import java.util.*;
public  class Takeinput {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		System.out.println(n);
		String name = scn.nextLine();
		System.out.println("Hello "+name);
	}
}