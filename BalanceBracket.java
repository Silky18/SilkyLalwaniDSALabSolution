package lab3work;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalanceBracket {
	static boolean areBracketsBalanced(String expr) {

		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter string ");
			String expr = sc.nextLine();
			// Function call
			if (areBracketsBalanced(expr))
				System.out.println("The entered string contains balance bracket ");
			else
				System.out.println("The entered string donont contain balanced bracket ");
		}
	}

}
