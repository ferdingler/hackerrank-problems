import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 */

public class GraphSearch {

    private static class Graph {

        List<Node> nodes;

        private Graph(int size) {
            this.nodes = new ArrayList<>();
            for(int i=0; i<size; i++){
                nodes.add(new Node(i));
            }
        }

        private void addEdge(int first, int second) {
            Node n1 = getNode(first);
            Node n2 = getNode(second);
            n1.connect(n2);
            n2.connect(n1);
        }

        private int[] shortestReach(int startId) {

            int[] distances = new int[nodes.size()];
            Arrays.fill(distances, -1);
            distances[startId] = 0;

            Queue<Node> pending = new LinkedList<>();
            Node start = getNode(startId);
            pending.add(start);

            while(!pending.isEmpty()){
                Node current = pending.poll();
                Collection<Node> neighbors = current.neighbors.values();
                for(Node neighbor : neighbors){
                    if(distances[neighbor.id] == -1) { // not visited
                        distances[neighbor.id] = distances[current.id] + 6;
                        pending.add(neighbor);
                    }
                }
            }

            return distances;
        }

        private Node getNode(int id){

            for(Node node : nodes){
                if(node.id == id){
                    return node;
                }
            }

            Node node = new Node(id);
            nodes.add(node);
            return node;
        }

    }

    private static class Node {

        int id;
        Map<Integer, Node> neighbors;

        private Node(int id){
            this.neighbors = new HashMap<>();
            this.id = id;
        }

        private void connect(Node node){
            neighbors.put(node.id, node);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int t = 0; t<queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i=0; i<distances.length; i++) {
                if(startId != i) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}