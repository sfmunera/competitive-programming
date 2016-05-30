package livearchive;

import java.util.*;

public class ReauxShamBeaux {
	
	static enum Symbol {ROCK, PAPER, SCISSORS};
	static enum Status {FIRST, SECOND, TIE};
	
	static Map<String, Map<Symbol, Set<String>>> dict;
	
	static Status result(Symbol s1, Symbol s2) {
		if (s1 == s2) return Status.TIE;
		if (s1 == Symbol.ROCK) {
			if (s2 == Symbol.SCISSORS) {
				return Status.FIRST;
			} else {
				return Status.SECOND;
			}
		} else if (s1 == Symbol.PAPER) {
			if (s2 == Symbol.ROCK) {
				return Status.FIRST;
			} else {
				return Status.SECOND;
			}
		} else {
			if (s2 == Symbol.PAPER) {
				return Status.FIRST;
			} else {
				return Status.SECOND;
			}
		}
	}
	
	static void initDict() {
		dict = new HashMap<String, Map<Symbol, Set<String>>>();
		dict.put("cs", new HashMap<Symbol, Set<String>>());
		dict.get("cs").put(Symbol.ROCK, new HashSet<String>());
		dict.get("cs").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("cs").put(Symbol.PAPER, new HashSet<String>());
		dict.get("cs").get(Symbol.ROCK).add("Kamen");
		dict.get("cs").get(Symbol.SCISSORS).add("Nuzky");
		dict.get("cs").get(Symbol.PAPER).add("Papir");
		
		dict.put("en", new HashMap<Symbol, Set<String>>());
		dict.get("en").put(Symbol.ROCK, new HashSet<String>());
		dict.get("en").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("en").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("en").get(Symbol.ROCK).add("Rock");
		dict.get("en").get(Symbol.SCISSORS).add("Scissors");
		dict.get("en").get(Symbol.PAPER).add("Paper");
		
		dict.put("fr", new HashMap<Symbol, Set<String>>());
		dict.get("fr").put(Symbol.ROCK, new HashSet<String>());
		dict.get("fr").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("fr").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("fr").get(Symbol.ROCK).add("Pierre");
		dict.get("fr").get(Symbol.SCISSORS).add("Ciseaux");
		dict.get("fr").get(Symbol.PAPER).add("Feuille");
		
		dict.put("de", new HashMap<Symbol, Set<String>>());
		dict.get("de").put(Symbol.ROCK, new HashSet<String>());
		dict.get("de").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("de").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("de").get(Symbol.ROCK).add("Stein");
		dict.get("de").get(Symbol.SCISSORS).add("Schere");
		dict.get("de").get(Symbol.PAPER).add("Papier");
		
		dict.put("hu", new HashMap<Symbol, Set<String>>());
		dict.get("hu").put(Symbol.ROCK, new HashSet<String>());
		dict.get("hu").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("hu").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("hu").get(Symbol.ROCK).add("Ko");
		dict.get("hu").get(Symbol.ROCK).add("Koe");
		dict.get("hu").get(Symbol.SCISSORS).add("Ollo");
		dict.get("hu").get(Symbol.SCISSORS).add("Olloo");
		dict.get("hu").get(Symbol.PAPER).add("Papir");
		
		dict.put("it", new HashMap<Symbol, Set<String>>());
		dict.get("it").put(Symbol.ROCK, new HashSet<String>());
		dict.get("it").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("it").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("it").get(Symbol.ROCK).add("Sasso");
		dict.get("it").get(Symbol.ROCK).add("Roccia");
		dict.get("it").get(Symbol.SCISSORS).add("Forbice");
		dict.get("it").get(Symbol.PAPER).add("Carta");
		dict.get("it").get(Symbol.PAPER).add("Rete");
		
		dict.put("jp", new HashMap<Symbol, Set<String>>());
		dict.get("jp").put(Symbol.ROCK, new HashSet<String>());
		dict.get("jp").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("jp").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("jp").get(Symbol.ROCK).add("Guu");
		dict.get("jp").get(Symbol.SCISSORS).add("Choki");
		dict.get("jp").get(Symbol.PAPER).add("Paa");
		
		dict.put("pl", new HashMap<Symbol, Set<String>>());
		dict.get("pl").put(Symbol.ROCK, new HashSet<String>());
		dict.get("pl").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("pl").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("pl").get(Symbol.ROCK).add("Kamien");
		dict.get("pl").get(Symbol.SCISSORS).add("Nozyce");
		dict.get("pl").get(Symbol.PAPER).add("Papier");
		
		dict.put("es", new HashMap<Symbol, Set<String>>());
		dict.get("es").put(Symbol.ROCK, new HashSet<String>());
		dict.get("es").put(Symbol.SCISSORS, new HashSet<String>());
		dict.get("es").put(Symbol.PAPER, new HashSet<String>());
		
		dict.get("es").get(Symbol.ROCK).add("Piedra");
		dict.get("es").get(Symbol.SCISSORS).add("Tijera");
		dict.get("es").get(Symbol.PAPER).add("Papel");
	}
	
	static Symbol translate(String lang, String word) {
		if (dict.get(lang).get(Symbol.ROCK).contains(word)) {
			return Symbol.ROCK;
		} else if (dict.get(lang).get(Symbol.SCISSORS).contains(word)) {
			return Symbol.SCISSORS;
		} else {
			return Symbol.PAPER;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		initDict();
		int game = 1;
		while (true) {
			String lang1 = in.next();
			String name1 = in.next();
			String lang2 = in.next();
			String name2 = in.next();
			
			int cnt1 = 0;
			int cnt2 = 0;
			
			String first, second;
			while (true) {
				first = in.next();
				if (first.equals("-") || first.equals(".")) break;
				second = in.next();
				
				Status status = result(translate(lang1, first), translate(lang2, second));
				if (status == Status.FIRST) {
					++cnt1;
				} else if (status == Status.SECOND) {
					++cnt2;
				}
			}
			
			System.out.println("Game #" + game + ":");
			System.out.println(name1 + ": " + cnt1 + " point" + (cnt1 == 1 ? "" : "s"));
			System.out.println(name2 + ": " + cnt2 + " point" + (cnt2 == 1 ? "" : "s"));
			if (cnt1 == cnt2) {
				System.out.println("TIED GAME");
			} else {
				System.out.println("WINNER: " + (cnt1 > cnt2 ? name1 : name2));
			}
			System.out.println();
			
			++game;
			if (first.equals(".")) break;
		}
		
		in.close();
		System.exit(0);
	}
}
