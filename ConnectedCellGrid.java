import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 */

public class ConnectedCellGrid {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }


        Graph graph = new Graph(grid);
        int maxRegionSize = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){

                Node node = graph.getNode(String.format("%d%d", row, col));
                List<Node> region = new ArrayList<>();
                node.getRegion(region, new HashMap<>());

                maxRegionSize = Math.max(maxRegionSize, region.size());
            }
        }

        System.out.println(maxRegionSize);
    }

    private static class Graph {

        Map<String, Node> nodes;

        Graph(int[][] grid){

            this.nodes = new HashMap<>();
            int n = grid.length;
            int m = grid[0].length;

            for(int row=0; row<n; row++){
                for(int col=0; col<m; col++){

                    String nodeId = String.format("%d%d", row, col);
                    Node node = this.getNode(nodeId, grid[row][col]);

                    String neighborId;
                    int value;

                    if(row+1 < n) {

                        neighborId = String.format("%d%d", row + 1, col);
                        value = grid[row + 1][col];
                        this.addConnection(node, this.getNode(neighborId, value));

                        if(col+1 < m) {
                            neighborId = String.format("%d%d", row + 1, col + 1);
                            value = grid[row + 1][col + 1];
                            this.addConnection(node, this.getNode(neighborId, value));
                        }

                        if(col-1 >= 0) {
                            neighborId = String.format("%d%d", row + 1, col - 1);
                            value = grid[row + 1][col - 1];
                            this.addConnection(node, this.getNode(neighborId, value));
                        }

                    }

                    if(col+1 < m) {
                        neighborId = String.format("%d%d", row, col + 1);
                        value = grid[row][col + 1];
                        this.addConnection(node, this.getNode(neighborId, value));
                    }

                    if(col-1 >= 0) {
                        neighborId = String.format("%d%d", row, col - 1);
                        value = grid[row][col - 1];
                        this.addConnection(node, this.getNode(neighborId, value));
                    }

                    if(row-1 >= 0){

                        neighborId = String.format("%d%d", row-1, col);
                        value = grid[row-1][col];
                        this.addConnection(node, this.getNode(neighborId, value));

                        if(col+1 < m) {
                            neighborId = String.format("%d%d", row-1, col + 1);
                            value = grid[row-1][col + 1];
                            this.addConnection(node, this.getNode(neighborId, value));
                        }

                        if(col-1 >= 0){
                            neighborId = String.format("%d%d", row-1, col - 1);
                            value = grid[row-1][col-1];
                            this.addConnection(node, this.getNode(neighborId, value));
                        }
                    }
                }
            }
        }

        Node getNode(String nodeId, int value){

            if(nodes.containsKey(nodeId)){
                return nodes.get(nodeId);
            }

            return new Node(nodeId, value);
        }

        Node getNode(String nodeId){
            return nodes.get(nodeId);
        }

        void addConnection(Node node1, Node node2){
            node1.addConnection(node2);
            node2.addConnection(node1);
            nodes.put(node1.id, node1);
            nodes.put(node2.id, node2);
        }

    }

    private static class Node {

        String id;
        int value;
        Map<String, Node> connections;

        Node(String id, int value){
            this.id = id;
            this.value = value;
            this.connections = new HashMap<>();
        }

        void addConnection(Node node){
            if(!connections.containsKey(node.id)){
                connections.put(node.id, node);
            }
        }

        void getRegion(List<Node> region, Map<String, Node> visited){

            if(this.value == 0 || visited.containsKey(this.id)){
                return;
            }

            visited.put(this.id, this);
            region.add(this);

            Collection<Node> conn = this.connections.values();
            for(Node node : conn){
                node.getRegion(region, visited);
            }
        }
    }
}
