import java.util.*;

/*
https://www.hackerrank.com/challenges/ctci-ransom-note
 */

public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {

        magazineMap = getWordsCount(magazine);
        noteMap = getWordsCount(note);
    }

    public Map<String, Integer> getWordsCount(String text){

        StringTokenizer st = new StringTokenizer(text);
        Map<String, Integer> wordCount = new HashMap<>();

        while(st.hasMoreTokens()){
            String word = st.nextToken();
            int occurrences = 0;
            if(wordCount.containsKey(word)){
                occurrences = wordCount.get(word) + 1;
            }
            wordCount.put(word, occurrences);
        }

        return wordCount;
    }

    public boolean solve() {

        for(String word : noteMap.keySet()){
            if(!magazineMap.containsKey(word) || noteMap.get(word) > magazineMap.get(word)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}