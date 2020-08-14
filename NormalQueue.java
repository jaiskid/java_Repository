import java.util.*;
public class NormalQueue {
	public static class Queue {
		int[] data;
		int front;
		int size;
		public Queue(int cap) {
			data = new int[cap];
			front = 0;
			size = 0;
		}
		int size() {
			return size;
		}
		void display() {
			for (int i = 0; i < size; i++) {
				int idx = (front + i) % data.length;
				System.out.print(data[idx] + " ");
			}
			System.out.println();
		}
		void add(int val) {
			if (size == data.length) {
				System.out.println("Queue overflow");
			} else {
				int rear = (front + size) % data.length;
				data[rear] = val;
				size++;
			}
		}
		int remove() {
			if (size == 0) {
				System.out.println("Queue underflow");
				return -1;
			} else {
				int val = data[front];
				front = (front + 1) % data.length;
				size--;
				return val;
			}
		}
		int peek() {
			if (size == 0) {
				System.out.println("Queue underflow");
				return -1;
			} else {
				int val = data[front];
				return val;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Queue que = new Queue(n);
		String str = scn.nextLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("add")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				que.add(val);
			} else if (str.startsWith("remove")) {
				int val = que.remove();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("peek")) {
				int val = que.peek();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(que.size());
			} else if (str.startsWith("display")) {
				que.display();
			}
			str = scn.nextLine();
		}
	}
}