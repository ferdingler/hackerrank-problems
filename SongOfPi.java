import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem URL: https://www.hackerrank.com/challenges/song-of-pi
 */

public class SongOfPi {

	private static String PI = "31415926535897932384626433833";

	public static boolean isPiSong(String song[]){

		for(int i=0; i<song.length; i++){
			int piDigit = Character.getNumericValue(PI.charAt(i));
			if(song[i].length() != piDigit)
				return false;
		}

		return true;
	}

    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();
    	
    	in.nextLine(); // Needed since nextInt doesn't read end of line

    	for(int i=0; i<t; i++){

    		String song = in.nextLine();
    		String rola[] = song.split(" ");

    		System.out.println(isPiSong(rola)? "It's a pi song." : "It's not a pi song.");
    	}
    }

}