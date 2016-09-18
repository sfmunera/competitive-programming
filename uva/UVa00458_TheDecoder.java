package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 399 (458 - The Decoder) */
/* SUBMISSION: 08972009 */
/* SUBMISSION TIME: 2011-06-21 02:57:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00458_TheDecoder {
	public static void main(String[] args) throws Exception {
		DataInputStream in = new DataInputStream(System.in);
		DataOutputStream out = new DataOutputStream(System.out);
		//Scanner in = new Scanner(System.in);
		
		int c;
		while ((c = in.read()) != -1) {
			out.write(c == 10 || c == 13 ? c : (char)(c - 7));
		}
	}
}
