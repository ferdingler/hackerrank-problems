import javax.sound.midi.SysexMessage;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 */

public class GridSearch {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int cases=0; cases<t; cases++){

            int R = in.nextInt();
            int C = in.nextInt();

            char[][] G = new char[R][C];
            for(int i=0; i<R; i++){
                String line = in.next();
                G[i] = line.toCharArray();
            }

            int r = in.nextInt();
            int c = in.nextInt();

            char[][] P = new char[r][c];
            for(int i=0; i<r; i++){
                String line = in.next();
                P[i] = line.toCharArray();
            }

            System.out.println(containsPattern(G, P)? "YES" : "NO");
        }
    }

    private static boolean containsPattern(char[][] m, char[][] pattern){

        int pIndex = 0;
        List<List<Integer>> matches = new ArrayList<>();

        for(int i=0; i<m.length; i++){

            matches = new ArrayList<>();
            pIndex = 0;
            for(int j=i; j<m.length && pIndex < pattern.length; j++){

                List<Integer> indexes = indexesOfPattern(m[j], pattern[pIndex]);
                if(indexes.size() <= 0){
                    break;
                }

                matches.add(indexes);
                pIndex++;
            }

            if(pIndex == pattern.length){
                break;
            }
        }

        if(matches.size() == 0){
            return false;
        }

        // From all the indexes, we need to grab the intersection of all.
        // If the resulting intersection is empty, then the pattern was not found.
        List<Integer> intersection = matches.get(0);
        for(int i=1; i<matches.size(); i++){
            intersection = intersection(intersection, matches.get(i));
        }

        return intersection.size() > 0;
    }

    private static List<Integer> intersection(List<Integer> a, List<Integer> b) {

        Set<Integer> set1 = new HashSet<>();
        for(int i: a){
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int i: b){
            if(set1.contains(i)){
                set2.add(i);
            }
        }

        return new ArrayList<>(set2);
    }

    private static List<Integer> indexesOfPattern(char[] a, char[] pattern){

        List<Integer> indexes = new ArrayList<>();
        for(int i=0; i<a.length; i++){

            int indexOf = 0;
            int pIndex = 0;
            for(int j=i; j<a.length && pIndex < pattern.length; j++){

                if(a[j] != pattern[pIndex]){
                    break;
                }

                if(pIndex++ == 0){
                    indexOf = i;
                }
            }

            if(pIndex == pattern.length){
                indexes.add(indexOf);
            }
        }

        return indexes;
    }

}
