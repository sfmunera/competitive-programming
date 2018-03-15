
public class LC434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        String[] parts = s.split(" ");
        int ans = 0;
        for (String p : parts) {
            if (!p.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
    
    public int countSegments2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
        		ans++;
        	}
        }
        return ans;
    }
}
