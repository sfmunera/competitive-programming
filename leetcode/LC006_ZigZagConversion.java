
public class LC006_ZigZagConversion {
    private char[][] initialize(String s, int numRows) {
        char[][] zigzag = new char[numRows][s.length()];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < s.length(); j++) {
				zigzag[i][j] = ' ';
			}
		}
        return zigzag;
    }
    
    private String readRows(char[][] zigzag) {
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zigzag.length; i++) {
			for (int j = 0; j < zigzag[0].length; j++) {
				if (zigzag[i][j] != ' ') {
					sb.append(zigzag[i][j]);
				}
			}
		}
		return sb.toString();
    }
    
	public String convert(String s, int numRows) {
        if (numRows == 1) return s;
		char[][] zigzag = initialize(s, numRows);
		
		boolean writeDiagonal = false;
		int r = 0;
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			zigzag[r][c] = s.charAt(i);
			if (writeDiagonal) {
                if (r > 0) {
				    r--;
				    c++;
                } else {
                    r++;
					writeDiagonal = false;
				}
			} else {
				if (r < numRows - 1) {
                    r++;
				} else {
					c++;
					r--;
					writeDiagonal = true;
				}
			}
		}
		return readRows(zigzag);
	}
}
