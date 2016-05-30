
public class Test {
	public static void main(String[] args) {
		for (int i = 1; i < 1000; ++i)
			for (int j = 1; j <= i; ++j) {
				int buf_len = (i + 1) % 256; // not include \n
				if ((i + 1) > buf_len || j > i) {
					continue;
				}
				buf_len = (buf_len + j + 1 + 1) % 256;
				
				if (i == buf_len + 4 + 12 + 4) {
					System.out.println("buf = " + buf_len + ", " + i + " " + j);
				}
			}
	}
}
