import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts
 */

public class Tries {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();

        for(int i=0; i<n; i++){

            String op = in.next();

            if(op.equals("add")){
                String contact = in.next();
                trie.add(contact);
            }

            if(op.equals("find")){
                String partial = in.next();
                System.out.println(trie.findCount(partial));
            }
        }
    }

    private static class Trie {

        TrieNode root = new TrieNode('\0');

        void add(String word){
            root.add(word);
        }

        int findCount(String partial){
            return root.findCount(partial);
        }
    }

    private static class TrieNode {

        char key;
        int count;
        Map<Character, TrieNode> nodes;

        TrieNode(char key){
            this.key = key;
            this.count = 0;
            this.nodes = new HashMap<>();
        }

        void add(String word){

            if(!word.isEmpty()){

                char first = word.charAt(0);
                TrieNode node = getNode(first);

                if(node == null){
                    node = new TrieNode(first);
                    nodes.put(first, node);
                }

                node.count += 1;
                node.add(word.substring(1));
            }
        }

        int findCount(String partial){

            if(partial.isEmpty()){
                return this.count;
            }

            char first = partial.charAt(0);
            TrieNode node = getNode(first);

            if(node == null){
                return 0;
            }

            return node.findCount(partial.substring(1));
        }

        TrieNode getNode(char key){
            return this.nodes.get(key);
        }
    }

}


