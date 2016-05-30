package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2904 (11804 - Argentina) */
/* SUBMISSION: 09145015 */
/* SUBMISSION TIME: 2011-08-13 12:27:44 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11804_Argentina {
	
	static class Player implements Comparable<Player> {
		String name;
		int attack;
		int defense;
		
		public Player(String n, int a, int d) {
			this.name = n;
			this.attack = a;
			this.defense = d;
		}

		public int compareTo(Player p) {
			if (!this.name.equals(p.name))
				return this.name.compareTo(p.name);
			if (this.attack != p.attack)
				return this.attack - p.attack;
			if (this.defense != p.defense)
				return this.defense - p.defense;
			return 0;
		}
		
		public String toString() {
			return this.name;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			Player[] players = new Player[10];
			
			for (int i = 0; i < 10; ++i)
				players[i] = new Player(in.next(), in.nextInt(), in.nextInt());
			
			int maxattack = 0;
			int maxdefense = 0;
			List<Player> attackers = new ArrayList<Player>();
			List<Player> defendants = new ArrayList<Player>();
			for (int i = 0; i < (1 << 10); ++i) {
				
				if (Integer.bitCount(i) != 5)
					continue;
				
				int a = 0;
				int d = 0;
				List<Player> tmp = new ArrayList<Player>();
				for (int j = 0; j < 10; ++j) {
					if ((i & (1 << j)) != 0) {
						a += players[j].attack;
						tmp.add(players[j]);
					} else
						d += players[j].defense;
				}

				if (a > maxattack) {
					maxattack = a;
					maxdefense = d;
					attackers = new ArrayList<Player>(tmp);
				} else if (a == maxattack) {
					if (d > maxdefense) {
						maxdefense = d;
						attackers = new ArrayList<Player>(tmp);
					} else if (d == maxdefense && !attackers.isEmpty()) {
						Collections.sort(tmp);
						Collections.sort(attackers);
						
						for (int k = 0; k < 5; ++k)
							if (tmp.get(k).compareTo(attackers.get(k)) < 0) {
								attackers = new ArrayList<Player>(tmp);
								break;
							}
					}
				}
			}
			
			Collections.sort(attackers);
			for (Player p : players)
				if (!attackers.contains(p))
					defendants.add(p);
			Collections.sort(defendants);
			
			System.out.println("Case " + t + ":");
			System.out.println(attackers.toString().replace('[', '(').replace(']', ')'));
			System.out.println(defendants.toString().replace('[', '(').replace(']', ')'));
		}
	}
}