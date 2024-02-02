
import java.util.Stack;

/******************************************************************************
 * Evaluates (fully parenthesized) arithmetic expressions using Dijkstra's
 * two-stack algorithm.
 *
 * Link: 
 * https://introcs.cs.princeton.edu/java/43stack/Evaluate.java.html
 ******************************************************************************/

public class Evaluate {

	public static void main(String[] args) {
		// ACHTUNG:
		// LEERZEICHEN sind wichtig!!!
		// Volle Klammerung notwendig!!!
		berechne("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) + 6 )");
		berechne("( 1 + ( 2 + 3 ) )");
		berechne("( ( 1 + sqrt ( 5 ) ) / 2 )");
	}

	public static void berechne(String exp) {
		MyStack ops = new MyStack();
		MyStack vals = new MyStack();

		String[] a = exp.split(" ");
		for (String s : a) {
			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			else if (s.equals("sqrt"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = (String) ops.pop();
				double v = (double)vals.pop();
				if (op.equals("+"))
					v = (double)vals.pop() + v;
				else if (op.equals("-"))
					v = (double)vals.pop() - v;
				else if (op.equals("*"))
					v = (double)vals.pop() * v;
				else if (op.equals("/"))
					v = (double)vals.pop() / v;
				else if (op.equals("sqrt"))
					v = Math.sqrt(v);
				vals.push(v);
			} else
				vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop());
	}
}
