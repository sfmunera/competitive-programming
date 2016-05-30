package interview;

public class DPParentheses {
	
	static void go(int toOpen, int toClose, String cur) {
		if (toOpen == 0 && toClose == 0) {
			System.out.println(cur);
			return;
		}
		
		if (toOpen > 0)
			go(toOpen - 1, toClose, cur + "(");
		if (toClose > toOpen)
			go(toOpen, toClose - 1, cur + ")");
	}
	
	public static void main(String[] args) {
		int n = 4;
		go(n, n, "");
	}
}
