package cloud.jnolasco.leetcode;

import cloud.jnolasco.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Explanation 1: https://youtu.be/9M3oCwPGamE?si=qGziJuuTwUVpksxx
 * Explanation 2: https://youtu.be/EaR1fdmHN_4?si=N9gKnUvGqH-k8FT4
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */
public class LC0102_BinaryTreeLevelOrderTraversal {

    /*
     * Psuedocode:
     * 1. If root is null, return empty list
     * 2. Create an output list
     * 3. Create a queue
     * 4. Add root to queue
     * 5. While queue is not empty
     *      a. Create a current level list
     *      b. Get the size of the queue
     *      c. For each element in the queue
     *          i. Get the current node
     *          ii. Add the current node value to the current level list
     *          iii. If the current node has a left child, add it to the queue
     *          iv. If the current node has a right child, add it to the queue
     *      d. Add the current level list to the output list
     * 6. Return the output list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        if (root == null)
            return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr == null)
                    continue;

                currentLevel.add(curr.val);
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }
            output.add(currentLevel);
        }

        return output;
    }

    public static void main(String[] args) {

        LC0102_BinaryTreeLevelOrderTraversal app = new LC0102_BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> output = app.levelOrder(root);
        output.forEach(System.out::println);
    }
}
