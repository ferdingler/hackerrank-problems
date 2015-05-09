import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AcmIcpcTeam {

    public static int numberOfTopics(int teamTopics){
        int topics = 0;
        while(teamTopics > 0){
            topics += teamTopics & 1;
            teamTopics = teamTopics >> 1;
        }
        return topics;
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] people = new int[N];
        
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(in.next(), 2);
            people[i] = number;
        }
        
        int maxTopics = 0; 
        int maxTeams = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(i != j){
                    
                    int team = people[i] | people[j];
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