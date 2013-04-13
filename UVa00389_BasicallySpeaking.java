package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 325 (389 - Basically Speaking) */
/* SUBMISSION: 07276150 */
/* SUBMISSION TIME: 2009-07-27 15:44:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00389_BasicallySpeaking {
    static int letraADecimal(char n)
    {
        if (n >= 'A' && n <= 'F')
            return n-55;
        return n-48;
    }

    static char decimalALetra(int n)
    {
        switch (n) {
            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';
        }
        return (char)(-1);
    }

    static int aDecimal(char[] n, int b)
    {
        int dec = 0;
        for (int i=0; i<n.length; i++) {
            dec += letraADecimal(n[n.length-1-i])*Math.pow(b, i);
        }
        return dec;
    }

    static char[] aBase(int d, int b)
    {
        char[] res;
        int n;
        StringBuffer num = new StringBuffer();
        while (d >= b) {
            num.append(decimalALetra(d % b));
            d /= b;
        }
        num.append(decimalALetra(d));
        n = num.length();
        res = new char[n];
        for (int i=0; i<n; i++) {
            res[i] = num.charAt(n-1-i);
        }

        return res;
    }
    public static void main(String[] args)
    {
        try {
            Scanner in = new Scanner(System.in);
            String input;
            StringTokenizer data;
            char[] origen, destino;
            int bOrigen, bDestino;

            input = in.nextLine();
            while (!input.equals("")) {
                data = new StringTokenizer(input);
                origen = data.nextToken().toCharArray();
                bOrigen = Integer.parseInt(data.nextToken());
                bDestino = Integer.parseInt(data.nextToken());
                destino = aBase(aDecimal(origen, bOrigen), bDestino);

                if (destino.length > 7)
                    System.out.println("  ERROR");
                else {
                    System.out.format("%7s%n", String.valueOf(destino));
                }
                input = in.nextLine();
            }
        } catch(Exception e) {
            System.exit(0);
        }
    }
}