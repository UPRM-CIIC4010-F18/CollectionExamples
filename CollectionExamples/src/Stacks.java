import java.util.Stack;

public class Stacks {

	public static int factorial(int n) {
		if (n<=1) return 1;
		return (n * factorial(n-1));
	}

	private static class FactStackFrame {
		public int n;
		public int result;
		public int stage;

		public FactStackFrame(int n, int result, int stage) {
			super();
			this.n = n;
			this.result = result;
			this.stage = stage;
		}
	}

	public static int iterFactorial(int n) {
		
		Stack<FactStackFrame> s = new Stack<FactStackFrame>();
		s.push(new FactStackFrame(n, 0, 0));

		while (true) {
			n = s.peek().n;
			switch (s.peek().stage) {
			case 0:
				if (n <= 1) {
					if (s.size() == 1) return 1;
					s.pop();
					s.peek().result = 1;
				}
				else {
					s.peek().stage = 1;
					s.push(new FactStackFrame(n-1, 0, 0));
				}
				break;
			case 1:
				if (s.size() == 1) return n * s.peek().result;
				int result = s.peek().result;
				s.pop();
				s.peek().result = n * result;
			}
		}
	}

	public static int powerSums(int n, int i) {
		if (i > n) {
			return 0;
		}
		else if (i==n) {
			return 1;
		}
		return (powerSums(n-i, i+1) + powerSums(n, i+1));
	}

	public static class PSStackFrame {
		public int i;
		public int n;
		public int lResult;
		public int rResult;
		public int stage;

		public PSStackFrame(int n, int i, int lResult, int rResult, int stage) {
			this.i = i;
			this.n = n;
			this.lResult = lResult;
			this.stage = stage;
		}
	}

	public static int powerSumsIter(int n, int i) {

		Stack<PSStackFrame> theStack = new Stack<PSStackFrame>();

		theStack.push(new PSStackFrame(n, i, 0, 0, 0));

		while (true) {

			n = theStack.peek().n;
			i = theStack.peek().i;

			switch (theStack.peek().stage) {
			case 0: 
				if (i > n) {
					if (theStack.size() == 1) return 0;
					theStack.pop();
					theStack.peek().lResult = 0;
				}
				else if (i == n) {
					if (theStack.size() == 1) return 1;
					theStack.pop();
					theStack.peek().lResult = 1;
				}
				else {
					theStack.peek().stage = 1;
					theStack.push(new PSStackFrame(n-i, i+1, 0, 0, 0));
				}
				break;

			case 1:
				theStack.peek().rResult = theStack.peek().lResult;
				theStack.peek().stage = 2;
				theStack.push(new PSStackFrame(n, i+1, 0, 0, 0));
				break;

			case 2:
				int sum = theStack.peek().lResult + theStack.peek().rResult;
				if (theStack.size() == 1) return sum;
				theStack.pop();
				theStack.peek().lResult = sum;
				break;
			}
		}
	}
}
