package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2253 (11278 - One-Handed Typist) */
/* SUBMISSION: 08955350 */
/* SUBMISSION TIME: 2011-06-16 00:21:23 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11278_OneHandedTypist {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[] map = new char[256];
		
		map['`'] = '`'; map['1'] = '1'; map['2'] = '2'; map['3'] = '3';
		map['4'] = 'q'; map['5'] = 'j'; map['6'] = 'l'; map['7'] = 'm';
		map['8'] = 'f'; map['9'] = 'p'; map['0'] = '/'; map['-'] = '[';
		map['='] = ']'; map['q'] = '4'; map['w'] = '5'; map['e'] = '6';
		map['r'] = '.'; map['t'] = 'o'; map['y'] = 'r'; map['u'] = 's';
		map['i'] = 'u'; map['o'] = 'y'; map['p'] = 'b'; map['['] = ';';
		map[']'] = '='; map['\\'] = '\\'; map['a'] = '7'; map['s'] = '8';
		map['d'] = '9'; map['f'] = 'a'; map['g'] = 'e'; map['h'] = 'h';
		map['j'] = 't'; map['k'] = 'd'; map['l'] = 'c'; map[';'] = 'k';
		map['\''] = '-'; map['z'] = '0'; map['x'] = 'z'; map['c'] = 'x';
		map['v'] = ','; map['b'] = 'i'; map['n'] = 'n'; map['m'] = 'w';
		map[','] = 'v'; map['.'] = 'g'; map['/'] = '\'';
		
		map['~'] = '~'; map['!'] = '!'; map['@'] = '@'; map['#'] = '#';
		map['$'] = 'Q'; map['%'] = 'J'; map['^'] = 'L'; map['&'] = 'M';
		map['*'] = 'F'; map['('] = 'P'; map[')'] = '?'; map['_'] = '{';
		map['+'] = '}'; map['Q'] = '$'; map['W'] = '%'; map['E'] = '^';
		map['R'] = '>'; map['T'] = 'O'; map['Y'] = 'R'; map['U'] = 'S';
		map['I'] = 'U'; map['O'] = 'Y'; map['P'] = 'B'; map['{'] = ':';
		map['}'] = '+'; map['|'] = '|'; map['A'] = '&'; map['S'] = '*';
		map['D'] = '('; map['F'] = 'A'; map['G'] = 'E'; map['H'] = 'H';
		map['J'] = 'T'; map['K'] = 'D'; map['L'] = 'C'; map[':'] = 'K';
		map['"'] = '_'; map['Z'] = ')'; map['X'] = 'Z'; map['C'] = 'X';
		map['V'] = '<'; map['B'] = 'I'; map['N'] = 'N'; map['M'] = 'W';
		map['<'] = 'V'; map['>'] = 'G'; map['?'] = '"';
		
		map[' '] = ' ';
		
		while (in.hasNextLine()) {
			char[] line = in.nextLine().toCharArray();
			char[] res = new char[line.length];
			
			int k = 0;
			for (char c : line)
				res[k++] = map[c];
			System.out.println(String.valueOf(res));
		}
	}
}