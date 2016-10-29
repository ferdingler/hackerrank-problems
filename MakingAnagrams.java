import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
https://www.hackerrank.com/challenges/ctci-making-anagrams
 */

public class MakingAnagrams {

    private static int numberNeeded(String first, String second) {

        int[] firstUniqueChars = getUniqueChars(first);
        int[] secondUniqueChars = getUniqueChars(second);

        int deletions = 0;
        for(int i=0; i<firstUniqueChars.length; i++){
            deletions += Math.abs(firstUniqueChars[i] - secondUniqueChars[i]);
        }

        return deletions;
    }

    private static int[] getUniqueChars(String str){
        int alphabetLength = ('z' - 'a') + 1;
        int[] uniques = new int[alphabetLength];
        for(int i=0; i<str.length(); i++){
            uniques[str.charAt(i) - 'a'] += 1;
        }
        return uniques;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
