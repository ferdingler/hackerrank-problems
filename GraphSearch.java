import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 */

public class GraphSearch {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();

        for(int q=0; q<queries; q++){

            int nodes = in.nextInt();
            int edges = in.nextInt();
            int[][] graph = new int[nodes][nodes];

            for(int i=0; i<edges; i++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                graph[u][v] = 1;
                graph[v][u] = 1;
            }

            int start = in.nextInt() - 1;
            for(int i=0; i<nodes; i++){
                if(i != start){

                    int distance = distance(start, i, 0, graph);

                    if(i > 0) {
                        System.out.print(" ");
                    }

                    System.out.print(distance * 6);
                }
            }

            System.out.println("");
        }
    }

    private static int distance(int from, int to, int c, int[][] graph){

        if(to == from){
            return 0;
        }

        if(graph[from][to] > 0){
            return graph[from][to] + c;
        }

        for(int i=0; i<graph[from].length; i++){
            if(i != from){
                int distance = distance(i, to, c + 1, graph);
                if(distance > 0){
                    graph[i][to] = distance;
                    graph[to][i] = distance;
                    return distance;
                }
            }
        }

        return -1;
    }


}
