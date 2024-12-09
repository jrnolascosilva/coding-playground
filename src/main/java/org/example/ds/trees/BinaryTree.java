package org.example.ds.trees;

import org.example.commons.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    /*
                 2
               /   \
              8     4
             / \     \
            3   7     1
                     /
                    6
     */
    public TreeNode buildTree() {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(8);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(6);

        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.val + " --> ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.val + " --> ");
        preOrderTraversal(root.left);
        preOrderTraversal((root.right));
    }

    public void posOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        posOrderTraversal(root.left);
        posOrderTraversal((root.right));
        System.out.print(root.val + " --> ");
    }

    public void breathFirstSearch(TreeNode root) {

        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print("-->" + curr.val);

            if(curr.left != null)
                queue.offer(curr.left);
            if(curr.right != null)
                queue.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree app = new BinaryTree();
        TreeNode root = app.buildTree();
        System.out.print("inOrder: ");
        app.inOrderTraversal(root);
        System.out.print("\npreOrder: ");
        app.preOrderTraversal(root);
        System.out.print("\nposOrder: ");
        app.posOrderTraversal(root);
        System.out.print("\nBread First Search: ");
        app.breathFirstSearch(root);
    }
}
