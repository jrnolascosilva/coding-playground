package org.example.apple;

// https://leetcode.com/problems/number-of-islands/description/

public class NumberOfIslands {

    private static final char[][] MAP = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    traverseIsland(grid, i, j);
                    numOfIslands++;
                }

            }
        }
        return numOfIslands;
    }

    public static char checkBoundaries(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length)
            return '0';
        if (j < 0 || j >= grid[i].length)
            return '0';

        return grid[i][j];
    }

    private static void traverseIsland(char[][] grid, int i, int j) {
        // if i or j is out or bounds the assume then return 0 a.k.a "water"
        if (checkBoundaries(grid, i, j) == '0')
            return;

        // recursion base case. First order business to remember
        if (grid[i][j] == '0')
            return;

        // If we pass beyond base case then mark this coordinates as visited i.e. 0 or 2
        grid[i][j] = '0';

        traverseIsland(grid, i - 1, j);     // check up
        traverseIsland(grid, i + 1, j);     // check down
        traverseIsland(grid, i, j - 1);     // left
        traverseIsland(grid, i, j + 1);     // right
    }

    public static void main(String[] args) {

        System.out.println(numIslands(MAP));
    }


}
