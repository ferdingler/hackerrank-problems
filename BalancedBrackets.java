import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */

public class BalancedBrackets {

    private static boolean isBalanced(String expression) {

        int len = expression.length();
        Stack<String> stack = new Stack<>();

        if(len % 2 > 0){
            return false;
        }

        for(int i=0; i<len; i++){
            String c = String.valueOf(expression.charAt(i));
            if(isOpenBracket(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty() || !match(stack.pop(), c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(String s){
        return (s.equals("(") || s.equals("[") || s.equals("{"));
    }

    private static boolean match(String char1, String char2){

        if(char1.equals("(") && char2.equals(")")){
            return true;
        }

        if(char1.equals("[") && char2.equals("]")){
            return true;
        }

        if(char1.equals("{") && char2.equals("}")){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
