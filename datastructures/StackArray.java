package datastructures;

public class StackArray {
	static private final int STACK_SIZE = 1000;
	static private int top = -1;
	static private int[] S = new int[STACK_SIZE];
	
	public static boolean empty() {
		return top == -1;
	}
	public static void push(int x) {
		if (top == STACK_SIZE - 1)
			System.err.println("Error: Stack overflow.");
		else
			S[++top] = x;
	}
	public static int pop() {
		if (empty()) {
			System.err.println("Error: Stack underflow.");
			return -1;
		} else
			return S[top--];
	}
	public static int top() {
		if (empty()) {
			System.err.println("Error: Stack underflow.");
			return -1;
		} else
			return S[top];
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 20; ++i)
			push(i);
		
		for (int i = 0; i < 15; ++i) {
			pop();
			System.out.println(top);
		}
	}
}
