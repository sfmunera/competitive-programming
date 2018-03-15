import java.util.*;

public class FindMaximum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        String maxMask = in.next();
        int[] maskSum = new int[n];
        int[] totalSum = new int[n];
        for (int i = 0; i < n; i++) {
            maskSum[i] = i > 0 ? maskSum[i - 1] : 0;
            maskSum[i] += (maxMask.charAt(i) - '0') * a[i];
            totalSum[i] = a[i] + (i > 0 ? totalSum[i - 1] : 0);
        }

        int max = maskSum[n - 1];
        for (int i = 0; i < n; i++) {
            if (maxMask.charAt(i) == '1') {
                max = Math.max(max, maskSum[n - 1] - maskSum[i] + (i > 0 ? totalSum[i - 1] : 0));
            }
        }
        System.out.println(max);

        in.close();
        System.exit(0);
    }
}
