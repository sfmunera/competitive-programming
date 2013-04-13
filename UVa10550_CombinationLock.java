package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1491 (10550 - Combination Lock) */
/* SUBMISSION: 09505977 */
/* SUBMISSION TIME: 2011-11-25 20:42:17 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10550_CombinationLock {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String[] parts = in.readLine().split("[ ]+");

      int p0 = Integer.parseInt(parts[0]);
      int p1 = Integer.parseInt(parts[1]);
      int p2 = Integer.parseInt(parts[2]);
      int p3 = Integer.parseInt(parts[3]);

      if (p0 == 0 && p1 == 0 && p2 == 0 && p3 == 0)
        break;

      int res = 3 * 40;
      if (p0 < p1)
        res += 40 + p0 - p1;
      else
        res += p0 - p1;
      if (p2 < p1)
        res += 40 + p2 - p1;
      else
        res += p2 - p1;
      if (p2 < p3)
        res += 40 + p2 - p3;
      else
        res += p2 - p3;

      res = res * 360 / 40;
      System.out.println(res);
    }

    in.close();
    System.exit(0);
  }
}