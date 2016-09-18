package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2164 (11223 - O: dah dah dah!) */
/* SUBMISSION: 08789809 */
/* SUBMISSION TIME: 2011-04-28 17:55:32 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11223_Odahdahdah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Character> map = new HashMap<String, Character>();
        map.put(" ", ' ');
        map.put(".-", 'A');
        map.put("-...", 'B');
        map.put("-.-.", 'C');
        map.put("-..", 'D');
        map.put(".", 'E');
        map.put("..-.", 'F');
        map.put("--.", 'G');
        map.put("....", 'H');
        map.put("..", 'I');
        map.put(".---", 'J');
        map.put("-.-", 'K');
        map.put(".-..", 'L');
        map.put("--", 'M');
        map.put("-.", 'N');
        map.put("---", 'O');
        map.put(".--.", 'P');
        map.put("--.-", 'Q');
        map.put(".-.", 'R');
        map.put("...", 'S');
        map.put("-", 'T');
        map.put("..-", 'U');
        map.put("...-", 'V');
        map.put(".--", 'W');
        map.put("-..-", 'X');
        map.put("-.--", 'Y');
        map.put("--..", 'Z');
        map.put("-----", '0');
        map.put(".----", '1');
        map.put("..---", '2');
        map.put("...--", '3');
        map.put("....-", '4');
        map.put(".....", '5');
        map.put("-....", '6');
        map.put("--...", '7');
        map.put("---..", '8');
        map.put("----.", '9');
        map.put(".-.-.-", '.');
        map.put("--..--", ',');
        map.put("..--..", '?');
        map.put(".----.", '\'');
        map.put("-.-.--", '!');
        map.put("-..-.", '/');
        map.put("-.--.", '(');
        map.put("-.--.-", ')');
        map.put(".-...", '&');
        map.put("---...", ':');
        map.put("-.-.-.", ';');
        map.put("-...-", '=');
        map.put(".-.-.", '+');
        map.put("-....-", '-');
        map.put("..--.-", '_');
        map.put(".-..-.", '"');
        map.put(".--.-.", '@');

        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <=T; ++t) {
            String message = in.nextLine();
            String[] letters = message.split("[ ]");

            System.out.println("Message #" + t);
            for (int i = 0; i < letters.length; ++i) {
                if (letters[i].isEmpty()) System.out.print(" ");
                else System.out.print(map.get(letters[i]));
            }
            System.out.println();
            if (t < T) System.out.println();
        }
    }
}
