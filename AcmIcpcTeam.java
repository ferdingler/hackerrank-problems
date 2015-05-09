import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/acm-icpc-team
*/

public class AcmIcpcTeam {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        BigInteger[] people = new BigInteger[N];
        
        for(int i=0; i<N; i++){
            people[i] = new BigInteger(in.next(), 2);
        }
        
        int maxTopics = 0; 
        int maxTeams = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(i != j){
                    
                    BigInteger team = people[i].or(people[j]);
                    int topics = team.bitCount();
                    
                    if(topics > maxTopics){
                        maxTopics = topics;
                        maxTeams = 1;
                    } else if(topics == maxTopics){
                        maxTeams++;
                    }
                }
            }
        }
        
        System.out.println(maxTopics);
        System.out.println(maxTeams);
        
    }
}