package datastructures;

public class QueueArray {
	static private final int QUEUE_SIZE = 1000;
	static private int head = 0;
	static private int tail = 0;
	static private int[] Q = new int[QUEUE_SIZE];
	
	public static boolean empty() {
		return head == tail;
	}
	public static void enqueue(int x) {
		if ((tail + 1) % QUEUE_SIZE == head)
			System.err.println("Error: Queue overflow.");
		else {
			Q[tail] = x;
			tail = (tail + 1) % QUEUE_SIZE;
		}
	}
	public static int dequeue() {
		if (empty()) {
			System.err.println("Error: Queue underflow.");
			return -1;
		} else {
			int x = Q[head];
			head = (head + 1) % QUEUE_SIZE;
			return x;
		}
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 999; ++i)
			enqueue(i);
		
		for (int i = 0; i < 20; ++i) {
			dequeue();
			System.out.println(head + " " + tail);
		}
	}
}
