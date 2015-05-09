import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AcmIcpcTeam {

    public static int numberOfTopics(BigInteger teamTopics){
        int topics = 0;
        while(teamTopics.compareTo(BigInteger.ZERO) != 0){
            topics += teamTopics.and(BigInteger.ONE).intValue();
            teamTopics = teamTopics.shiftRight(1);
        }
        return topics;
    }
    
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
                    int topics = numberOfTopics(team);
                    
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