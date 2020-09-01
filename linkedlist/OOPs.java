import java.util.*;
public class OOPs {
	public static class Person {
		int age;
		String name;
		void saysHi() {
			System.out.println(name + "[" + age + "] says hi" );
		}
		Person() {
			//constructor
		}
		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 10;
		p1.name = "A";
		p1.saysHi();
		Person p2 = new Person(20, "B");
		p2.saysHi();
		/*

		Person p2 = new Person();
		p2.age = 20;
		p2.name = "B";
		p1.saysHi();
		p2.saysHi();
		swap1(p1, p2);
		p1.saysHi();
		p2.saysHi();

		*/
	}
	//game
	public static void swap1(Person psn1, Person psn2) {
		// Person temp = psn1;
		// psn1 = psn2;
		// psn2 = temp;
		int age = psn1.age;
		psn1.age = psn2.age;
		psn2.age = age;
		String name = psn1.name;
		psn1.name = psn2.name;
		psn2.name = name;
	}
}