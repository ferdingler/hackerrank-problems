import java.util.Scanner;

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
        int indexOf = 0;
        int indexOfPrev = 0;

        for(int i=0; i<m.length && pIndex < pattern.length; i++){

            indexOf = indexOfPattern(m[i], pattern[pIndex]);

            if(indexOf >= 0 && (indexOfPrev == indexOf || pIndex == 0)){
                pIndex++;
                indexOfPrev = indexOf;
            } else {
                i = (pIndex > 0)? i - 1 : i;
                pIndex = 0;
            }

            if(pattern.length - pIndex > m.length - i){
                break;
            }

        }

        return pIndex == pattern.length;
    }

    private static int indexOfPattern(char[] a, char[] pattern){

        int pIndex = 0;
        int indexOf = 0;

        for(int i=0; i<a.length && pIndex < pattern.length; i++){

            if(a[i] == pattern[pIndex]){
                pIndex++;
                indexOf = (pIndex == 1)? i : indexOf;
            } else {
                i = (pIndex > 0)? i - 1 : i;
                pIndex = 0;
            }

            if(pattern.length - pIndex > a.length - i){
                break;
            }

        }

        return (pIndex == pattern.length)? indexOf : -1;
    }

}
