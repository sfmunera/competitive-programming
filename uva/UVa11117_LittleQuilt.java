package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2058 (11117 - Little Quilt) */
/* SUBMISSION: 08745685 */
/* SUBMISSION TIME: 2011-04-14 16:49:35 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11117_LittleQuilt {

    static char[][] turn(String exp) {
        char[][] input = parse(exp);
        int r = input.length;
        if (r == 0) return new char[][]{};

        String orig = "/-+\\|";
        String trans = "\\|+/-";
        int c = input[0].length;
        char[][] res = new char[c][r];

        for (int j = 0; j < c; ++j)
            for (int i = 0; i < r; ++i) {
                char ch = input[r - i - 1][j];
                res[j][i] = trans.charAt(orig.indexOf(ch));
            }
        return res;
    }

    static char[][] sew(String exp1, String exp2) {
        char[][] input1 = parse(exp1);
        char[][] input2 = parse(exp2);
        int r1 = input1.length;
        int r2 = input2.length;
        if (r1 == 0 || r2 == 0 || r1 != r2) return new char[][]{};

        int c1 = input1[0].length;
        int c2 = input2[0].length;
        char[][] res = new char[r1][c1 + c2];

        for (int i = 0; i < r1; ++i)
            for (int j = 0; j < c1; ++j)
                res[i][j] = input1[i][j];
        for (int i = 0; i < r1; ++i)
            for (int j = 0; j < c2; ++j)
                res[i][c1 + j] = input2[i][j];
        return res;
    }

    static char[][] parse(String exp) {
        char[][] res = {};
        exp = exp.trim();

        if (exp.equals("A")) {
            res = new char[][]{{'/', '/'}, {'/', '+'}};
        } else if (exp.equals("B")) {
            res = new char[][]{{'-', '-'}, {'-', '-'}};
        } else if (exp.length() >= 3 && exp.substring(0, 3).equals("sew")) {
            String arg1 = "";
            String arg2 = "";
            int indi = exp.indexOf('(');
            int indf = exp.lastIndexOf(')');
            if (indi < 0 || indf < 0) return res;
            int k = indi + 1;
            int cnt = 0;
            while (k < indf) {
                if (exp.charAt(k) == ',' && cnt == 0) break;
                if (exp.charAt(k) == '(') ++cnt;
                if (exp.charAt(k) == ')') --cnt;
                ++k;
            }
            if (k > indi)
                arg1 = exp.substring(indi + 1, k);
            if (indf > k)
                arg2 = exp.substring(k + 1, indf);
            res = sew(arg1, arg2);
        } else if(exp.length() >= 4 && exp.substring(0, 4).equals("turn")) {
            int indi = exp.indexOf('(');
            int indf = exp.lastIndexOf(')');
            if (indi < 0 || indf < 0) return res;
            if (indf > indi)
                res = turn(exp.substring(indi + 1, indf));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int quilt = 1;

        in.useDelimiter(";");
        while (in.hasNext()) {
            String token = in.next().trim();
            Scanner in2 = new Scanner(token);
            String exp = "";

            while (in2.hasNextLine())
                exp += in2.nextLine().trim();
            if (exp.isEmpty()) continue;
            
            System.out.println("Quilt " + quilt + ":");
            char[][] res = parse(exp);

            if (res.length == 0)
                System.out.println("error");
            else
                for (int i = 0; i < res.length; ++i)
                    System.out.println(String.valueOf(res[i]));
            ++quilt;
        }
    }
}
