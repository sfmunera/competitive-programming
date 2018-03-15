import java.util.*;

public class CandyBags {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int left = 1;
        int right = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j += 2) {
                if (j > 0) System.out.print(" ");
                System.out.print(left + " " + right);
                left++;
                right--;
            }
            System.out.println();
        }

        in.close();
        System.exit(0);
    }
}
