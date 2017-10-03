package leetcode;

public class LC168_ExcelSheetColumnTitle {
    
    private static final int BASE = 26;
    
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        for (; n-- > 0; n /= BASE) {
            title.append((char)(n % BASE + 'A'));
        }
        return title.reverse().toString();
    }
}
