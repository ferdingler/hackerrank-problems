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

        System.out.println(getBiggestRegion(grid));
    }

    private static int getBiggestRegion(int[][] grid){

        int maxRegionSize = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                int region = cellsInRegion(grid, row, col, visited);
                maxRegionSize = Math.max(maxRegionSize, region);
            }
        }

        return maxRegionSize;
    }

    private static int cellsInRegion(int[][] grid, int row, int col, boolean[][] visited) {

        if(row < 0 || row>=grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }

        if(visited[row][col] || grid[row][col] == 0){
            return 0;
        }

        visited[row][col] = true;
        int cells = 1;
        cells += cellsInRegion(grid, row - 1, col - 1, visited);
        cells += cellsInRegion(grid, row - 1, col, visited);
        cells += cellsInRegion(grid, row - 1, col + 1, visited);
        cells += cellsInRegion(grid, row, col - 1, visited);
        cells += cellsInRegion(grid, row, col + 1, visited);
        cells += cellsInRegion(grid, row + 1, col - 1, visited);
        cells += cellsInRegion(grid, row + 1, col + 1, visited);
        cells += cellsInRegion(grid, row + 1, col, visited);

        return cells;
    }
}
