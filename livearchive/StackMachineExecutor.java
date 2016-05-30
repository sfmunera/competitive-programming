package livearchive;

import java.util.*;

public class StackMachineExecutor {
	
	static class StackMachine {
		long[] stack;
		int size;
		StackMachine(int first) {
			size = 0;
			stack = new long[10000];
			stack[size++] = first;
		}
		
		void execute(List<Operation> ops) {
			boolean failure = false;
			for (Operation op : ops) {
				if (op.operator.equals("NUM")) {
					stack[size++] = op.param;
				}
				if (op.operator.equals("POP")) {
					if (size == 0) failure = true;
					else --size;
				}
				if (op.operator.equals("INV")) {
					if (size == 0) failure = true;
					else stack[size - 1] *= -1;
				}
				if (op.operator.equals("DUP")) {
					if (size == 0) failure = true;
					else {
						stack[size] = stack[size - 1];
						++size;
					}
				}
				if (op.operator.equals("SWP")) {
					if (size < 2) failure = true;
					else {
						long t = stack[size - 1];
						stack[size - 1] = stack[size - 2];
						stack[size - 2] = t;
					}
				}
				if (op.operator.equals("ADD")) {
					if (size < 2) failure = true;
					else {
						long sum = stack[size - 2] + stack[size - 1];
						if (Math.abs(sum) > (long) (1e9)) failure = true;
						else {
							--size;
							stack[size - 1] = sum;
						}
					}
				}
				if (op.operator.equals("SUB")) {
					if (size < 2) failure = true;
					else {
						long sum = stack[size - 2] - stack[size - 1];
						if (Math.abs(sum) > (long) (1e9)) failure = true;
						else {
							--size;
							stack[size - 1] = sum;
						}
					}
				}
				if (op.operator.equals("MUL")) {
					if (size < 2) failure = true;
					else {
						long mul = stack[size - 2] * stack[size - 1];
						if (Math.abs(mul) > (long) (1e9)) failure = true;
						else {
							--size;
							stack[size - 1] = mul;
						}
					}
				}
				if (op.operator.equals("DIV")) {
					if (size < 2 || stack[size - 1] == 0) failure = true;
					else {
						long div = stack[size - 2] / stack[size - 1];
						if (Math.abs(div) > (long) (1e9)) failure = true;
						else {
							--size;
							stack[size - 1] = div;
						}
					}
				}
				if (op.operator.equals("MOD")) {
					if (size < 2 || stack[size - 1] == 0) failure = true;
					else {
						long mod = Math.abs(stack[size - 2]) % Math.abs(stack[size - 1]);
						if (Math.abs(mod) > (long) (1e9)) failure = true;
						else {
							mod = stack[size - 2] < 0 ? -mod : mod;
							--size;
							stack[size - 1] = mod;
						}
					}
				}
			}
			
			failure |= size != 1;
			System.out.println(failure ? "ERROR" : stack[0]);
		}
	}
	
	static class Operation {
		String operator;
		long param;
		Operation(String op, long par) {
			this.operator = op;
			this.param = par;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		while (true) {
			List<Operation> ops = new ArrayList<Operation>();
			while (true) {
				String op = in.next();
				if (op.equals("QUIT")) {
					done = true;
					break;
				}
				if (op.equals("END"))
					break;
				
				long par = -1;
				if (op.equals("NUM")) par = in.nextLong();

				ops.add(new Operation(op, par));
			}
			if (done) break;
			
			int N = in.nextInt();
			for (int i = 0; i < N; ++i) {
				int first = in.nextInt();
				StackMachine SM = new StackMachine(first);
				SM.execute(ops);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
