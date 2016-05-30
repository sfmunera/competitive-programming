package facebook;

import java.io.*;
import java.util.*;

public class BasketballGame {
	
	static class Student implements Comparable<Student> {
		String name;
		int pctg, height, time;
		public Student(String name, int pctg, int height) {
			this.name = name;
			this.pctg = pctg;
			this.height = height;
			this.time = 0;
		}
		@Override
		public int compareTo(Student s) { // Highest ranked first
			if (s.pctg != this.pctg) return s.pctg - this.pctg;
			return s.height - this.height;
		}
		public String toString() {
			return this.name;
		}
		public void incrementTime() {
			++this.time;
		}
	}
	
	static class Bench implements Comparable<Bench> {
		Student s;
		public Bench(Student s) {
			this.s = s;
		}
		@Override
		public int compareTo(Bench b) { // First with lowest time and highest ranked
			if (this.s.time != b.s.time)
				return this.s.time - b.s.time;
			return this.s.compareTo(b.s);
		}
	}
	
	static class Field implements Comparable<Field> {
		Student s;
		public Field(Student s) {
			this.s = s;
		}
		@Override
		public int compareTo(Field f) { // First with highest time and lowest ranked
			if (f.s.time != this.s.time)
				return f.s.time - this.s.time;
			return f.s.compareTo(this.s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("basketball_game.txt"));
		PrintWriter out = new PrintWriter(new File("outputFH2.txt"));
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int M = in.nextInt();
			int P = in.nextInt();
			
			Student[] students = new Student[N];
			for (int i = 0; i < N; ++i) {
				String name = in.next();
				int pctg = in.nextInt();
				int height = in.nextInt();
				
				students[i] = new Student(name, pctg, height);
			}
			
			Arrays.sort(students);
			PriorityQueue<Bench> bench1 = new PriorityQueue<Bench>();
			PriorityQueue<Bench> bench2 = new PriorityQueue<Bench>();
			PriorityQueue<Field> field1 = new PriorityQueue<Field>();
			PriorityQueue<Field> field2 = new PriorityQueue<Field>();
			
			for (int i = 0; i < N; ++i) {
				if (i < 2 * P) {
					if (i % 2 == 0)
						field1.offer(new Field(students[i]));
					else
						field2.offer(new Field(students[i]));
				} else {
					if (i % 2 == 0)
						bench1.offer(new Bench(students[i]));
					else
						bench2.offer(new Bench(students[i]));
				}
			}
			
			for (int m = 1; m <= M; ++m) {
				ArrayList<Field> tmp = new ArrayList<Field>();
				while (!field1.isEmpty()) {
					Field f = field1.poll();
					f.s.incrementTime();
					tmp.add(f);
				}
				for (Field f : tmp)
					field1.offer(f);
				
				tmp.clear();
				while (!field2.isEmpty()) {
					Field f = field2.poll();
					f.s.incrementTime();
					tmp.add(f);
				}
				for (Field f : tmp)
					field2.offer(f);
				
				if (!bench1.isEmpty()) {
					Field out1 = field1.poll();
					Bench in1 = bench1.poll();
					field1.offer(new Field(in1.s));
					bench1.offer(new Bench(out1.s));
				}
				
				if (!bench1.isEmpty()) {
					Field out2 = field2.poll();
					Bench in2 = bench2.poll();
					field2.offer(new Field(in2.s));
					bench2.offer(new Bench(out2.s));
				}	
			}
			
			String[] names = new String[2 * P];
			for (int i = 0; i < P; ++i)
				names[i] = field1.poll().s.name;
			for (int i = 0; i < P; ++i)
				names[P + i] = field2.poll().s.name;
			
			Arrays.sort(names);
			System.out.print("Case #" + t + ":");
			out.print("Case #" + t + ":");
			for (int i = 0; i < 2 * P; ++i) {
				System.out.print(" " + names[i]);
				out.print(" " + names[i]);
			}
			System.out.println();
			out.println();
		}
		
		in.close();
		out.close();
		
	}
}
