package main.java.com.compsci;

import java.util.*;

public class BalancedParenthesis {

    public static void main(String[] args) {
        String balancedParens = "(1)";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String emptyString = "";

        System.out.println("Balanced Parantheses Testing: TTFFFF");
        System.out.println(balancedParentheses(balancedParens));
        System.out.println(balancedParentheses(emptyString));
        System.out.println(balancedParentheses(tooManyOpenParens));
        System.out.println(balancedParentheses(tooManyOpenParens1));
        System.out.println(balancedParentheses(tooManyClosedParens));
        System.out.println(balancedParentheses(startClosedParens));

        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String mismatchedBrackets = "<({)}>";

        System.out.println("Balanced Brackets Testing: TTFFFFTTF");
        System.out.println(balancedBrackets(emptyString));
        System.out.println(balancedBrackets(balancedParens));
        System.out.println(balancedBrackets(tooManyOpenParens));
        System.out.println(balancedBrackets(tooManyOpenParens1));
        System.out.println(balancedBrackets(tooManyClosedParens));
        System.out.println(balancedBrackets(startClosedParens));
        System.out.println(balancedBrackets(balancedAngleBrackets));
        System.out.println(balancedBrackets(balancedComboBrackets));
        System.out.println(balancedBrackets(mismatchedBrackets));


        MissingNumber mn = new MissingNumber();
        int[] missingMax = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(mn.missingNumber(missingMax, 10));

    }

    public static boolean balancedParentheses(String s) {
        int numUnclosedBrackets = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedBrackets += 1;
            } else if (s.charAt(i) == ')') {
                numUnclosedBrackets -= 1;
            }

            if (numUnclosedBrackets == 0) {
                return true;
            }
        }
            return false;
    }

        public static boolean balancedBrackets (String s){

            Stack<Character> stack = new Stack<Character>();
            HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
            bracketPairs.put(')', '(');
            bracketPairs.put(']', '[');
            bracketPairs.put('}', '{');
            bracketPairs.put('>', '<');

            for (int i = 0; i < s.length(); i += 1) {

                if (bracketPairs.containsValue(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else if (bracketPairs.containsKey(s.charAt(i))) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character mostRecentBracket = stack.pop();
                    if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }

