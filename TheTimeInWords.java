import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem URL: https://www.hackerrank.com/challenges/the-time-in-words
 */

public class TheTimeInWords {

	private static String numbers[] = {"zero","one","two","three","four","five","six","seven","eight",
									   "nine","ten","eleven","twelve","thirteen","fourteen","fifteen",
									   "sixteen","seventeen","eighteen","nineteen"};

	private static String moreNumbers[] = {"twenty","thirty","fourty","fifty"};

	public static String timeInWords(int h, int m){

		if(m == 0)
			return numberToWords(h) + " o' clock";

		if(m == 15){
			return "quarter past " + numberToWords(h);
		}

		if(m == 30)
			return "half past " + numberToWords(h);

		if(m < 30)
			return numberToWords(m) + " " + minutes(m) + " past " + numberToWords(h);

		if(m == 45)
			return "quarter to " + numberToWords(hoursPlusOne(h));

		return numberToWords(60 - m) + " " + minutes(60 - m) + " to " + numberToWords(hoursPlusOne(h));
	}

	public static int hoursPlusOne(int hours){
		return (hours == 12)? 1 : hours + 1;
	}

	public static String minutes(int m){
		return (m == 1)? "minute" : "minutes";
	}

	public static String numberToWords(int n){

		if(n < 20)
			return numbers[n];

		String words = "";
		for(int i=2; i<6; i++){
			int t = n - i*10;
			if(t < 10){
				words = moreNumbers[i - 2];
				if(t > 0)
					words += " " + numbers[t];
				return words;
			}
		}

		return "";
	}

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int hours = in.nextInt();
        int minutes = in.nextInt();

        System.out.println(timeInWords(hours, minutes));

    }
}