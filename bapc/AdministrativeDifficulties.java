package bapc;

import java.util.*;
import java.io.*;

public class AdministrativeDifficulties {
	
	static class Car {
		String name;
		int price;
		int pickupCost;
		int costPerKm;
		
		public Car(String n, int p, int pc, int k) {
			this.name = n;
			this.price = p;
			this.pickupCost = pc;
			this.costPerKm = k;
		}
	}
	
	static class Event implements Comparable<Event> {
		int time;
		char type;
		String car;
		int dist;
		double severity;
		
		public Event(int time, char type, String car) {
			this.time = time;
			this.type = type;
			this.car = car;
			this.dist = -1;
			this.severity = -1;
		}
		
		public Event(int time, char type, int dist) {
			this.time = time;
			this.type = type;
			this.car = null;
			this.dist = dist;
			this.severity = -1;
		}
		
		public Event(int time, char type, double severity) {
			this.time = time;
			this.type = type;
			this.car = null;
			this.dist = -1;
			this.severity = severity;
		}

		@Override
		public int compareTo(Event e) {
			return this.time - this.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			HashMap<String, Car> cars = new HashMap<String, Car>();
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				String name = stk.nextToken();
				int price = Integer.parseInt(stk.nextToken());
				int pickupCost = Integer.parseInt(stk.nextToken());
				int costPerKm = Integer.parseInt(stk.nextToken());
				
				cars.put(name, new Car(name, price, pickupCost, costPerKm));
			}
			
			TreeMap<String, ArrayList<Event>> spies = new TreeMap<String, ArrayList<Event>>();
			for (int i = 0; i < M; ++i) {
				stk = new StringTokenizer(in.readLine());
				int time = Integer.parseInt(stk.nextToken());
				String spy = stk.nextToken();
				char event = stk.nextToken().charAt(0);
				
				if (!spies.containsKey(spy)) {
					spies.put(spy, new ArrayList<Event>());
				}
				if (event == 'p') {
					String car = stk.nextToken();
					spies.get(spy).add(new Event(time, event, car));
				} else if (event == 'r') {
					int dist = Integer.parseInt(stk.nextToken());
					spies.get(spy).add(new Event(time, event, dist));
				} else if (event == 'a') {
					double severity = Integer.parseInt(stk.nextToken()) / 100.0;
					spies.get(spy).add(new Event(time, event, severity));
				}
			}
			
			for (String spy : spies.keySet()) {
				long total = 0;
				boolean good = true;
				int curState = -1;
				String curCar = null;

				for (Event e : spies.get(spy)) {
					char type = e.type;
					if (curState == -1 || curState == 2) {
						if (type != 'p') {
							good = false;
							break;
						}
						curCar = e.car;
						total += cars.get(curCar).pickupCost;
						curState = 0;
					} else if (curState == 0 || curState == 1) {
						if (type != 'a' && type != 'r') {
							good = false;
							break;
						}
						if (type == 'a') {
							total += Math.ceil(cars.get(curCar).price * e.severity - 1e-9);
							curState = 1;
						} else if (type == 'r') {
							total += cars.get(curCar).costPerKm * e.dist;
							curState = 2;
						}
					}
				}
				if (curState != 2)
					good = false;
				
				System.out.println(spy + " " + (good ? total : "INCONSISTENT"));
			}
		}
		
		in.close();
	}
}
