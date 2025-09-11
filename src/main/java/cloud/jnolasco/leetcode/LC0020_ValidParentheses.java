package cloud.jnolasco.leetcode;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
// Explanation: https://youtu.be/TaWs8tIrnoA?si=BKRN376QFSOoXd3X
// https://youtu.be/TaWs8tIrnoA?si=uXXsfLwumYfpXV-o
// Time complexity: O(n) where n is the length of the string
// Space complexity: O(n) where n is the length of the string


public class LC0020_ValidParentheses {

    public static boolean isValid(String s) {

        // easy way to get closing bracket for opening bracket
        HashMap<Character,Character> symbols = new HashMap<>();
        symbols.put('(', ')');
        symbols.put('[', ']');
        symbols.put('{', '}');

        // Lets use stack to keep track of opening brackets storing corresponding closing brackets
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for(Character c : charArray)
        {
            // if stack is empty, and we get closing bracket, then return false
            if(stack.isEmpty() && !symbols.containsKey(c))
                return false;

            // if opening bracket, then push corresponding closing bracket
            if(symbols.containsKey(c))  // is an opening bracket
                stack.push(symbols.get(c));
            else {
                // as c is not an opening bracket, it should be closing bracket then check if it matches
                // the top of stack
                if(stack.peek() == c)
                    stack.pop();
                else
                    return false;   // return false because closing bracket is not matching with opening bracket
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})()"));
    }
}
