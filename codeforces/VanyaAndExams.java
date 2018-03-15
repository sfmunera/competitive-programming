package codeforces;

import java.io.*;
import java.util.*;

public class VanyaAndExams {
    
    static class Exam implements Comparable<Exam> {
        int grade, essaysPerIncrement;
        Exam(int a, int b) {
            this.grade = a;
            this.essaysPerIncrement = b;
        }
        @Override
        public int compareTo(Exam that) {
            if (this.essaysPerIncrement != that.essaysPerIncrement) {
                return this.essaysPerIncrement - that.essaysPerIncrement;
            }
            return this.grade - that.grade;
        }
        
    }
    
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        
        int n = in.nextInt();
        int r = in.nextInt();
        long avg = in.nextLong();
        
        Exam[] exams = new Exam[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            exams[i] = new Exam(a, b);
            sum += exams[i].grade;
        }
        Arrays.sort(exams);
        long ans = 0;
        for (int index = 0; index < n && sum < avg * n; index++) {
            if (exams[index].grade < r) {
                long add = Math.min(r - exams[index].grade, avg * n - sum);
                ans += exams[index].essaysPerIncrement * add;
                sum += add;
            }
        }
        System.out.println(ans);
        
        System.exit(0);
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = new StringTokenizer("");
        }

        public String next() {
            try {
                while (!tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
            return tokenizer.nextToken();
        }
        
        public String nextLine() {
            String line = null;
            try {
                tokenizer = new StringTokenizer("");
                line =  reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
    }
}
