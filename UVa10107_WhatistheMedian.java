package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1048 (10107 - What is the Median?) */
/* SUBMISSION: 08813446 */
/* SUBMISSION TIME: 2011-05-05 13:54:16 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10107_WhatistheMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
            Collections.sort(numbers);
            int n = numbers.size();
            int mid = n / 2;
            int med = 0;

            if (n % 2 == 1)
                med = numbers.get(mid);
            else
                med = (numbers.get(mid - 1) + numbers.get(mid)) / 2;
            System.out.println(med);
        }
    }
}
