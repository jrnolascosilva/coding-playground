package cloud.jnolasco.leetcode;

// https://leetcode.com/problems/number-of-islands/description/
// Explanation 1: https://youtu.be/U6-X_QOwPcs?si=vD6oWTMHCzHigV2T
// Explanation 2: https://youtu.be/QBiVF2B_7XY?si=ExREtmSxvBbTXXzf

// Time complexity O(m * n)
// Space complexity O(m * n)

public class LC0200_NumberOfIslands {

    private static final char[][] MAP = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    bfsTraverseIsland(grid, i, j);
                    numberOfIslands++;
                }
            }
        };
        return numberOfIslands;
    }

    private void bfsTraverseIsland(char[][] grid, int i, int j) {
        // boundary checks: // if i or j is out or bounds the assume then return 0 a.k.a "water"
        if(i < 0 || i >= grid.length)
            return;
        if(j < 0 || j >= grid[i].length)
            return;

        // recursion base case. First order business to remember
        if(grid[i][j] == '0')
            return;

        // If we pass beyond base case then mark this coordinates as visited i.e. 0 or 2
        grid[i][j] = '0';       // mark as visited

        bfsTraverseIsland(grid, i - 1, j);    // up
        bfsTraverseIsland(grid, i + 1, j);    // down
        bfsTraverseIsland(grid, i, j -1 );    // left
        bfsTraverseIsland(grid, i, j + 1);    // right
    }

    public static void main(String[] args) {
        LC0200_NumberOfIslands app = new LC0200_NumberOfIslands();

        System.out.println(app.numIslands(MAP));
    }
}
