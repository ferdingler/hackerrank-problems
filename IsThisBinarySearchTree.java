import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/submissions/code/33551810
 */
public class IsThisBinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;
     }

    boolean checkBST(Node root) {

        List<Integer> elements = new ArrayList<>();
        Set<Integer> uniques = new HashSet<>();
        flatten(root, elements);

        uniques.add(elements.get(0));
        for(int i=1; i<elements.size(); i++){

            if(!uniques.add(elements.get(i))){
                return false;
            }

            if(elements.get(i) < elements.get(i-1)){
                return false;
            }
        }

        return true;
    }

    void flatten(Node node, List<Integer> elements){

        if(node == null){
            return;
        }

        if(isLeaf(node)){
            elements.add(node.data);
        } else {
            flatten(node.left, elements);
            elements.add(node.data);
            flatten(node.right, elements);
        }
    }

    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

}
