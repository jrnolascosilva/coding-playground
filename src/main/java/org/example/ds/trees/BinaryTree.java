package org.example.ds.trees;

public class BinaryTree {

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
        System.out.print(root.value + " --> ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.value + " --> ");
        preOrderTraversal(root.left);
        preOrderTraversal((root.right));
    }

    public void posOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        posOrderTraversal(root.left);
        posOrderTraversal((root.right));
        System.out.print(root.value + " --> ");
    }

    public static void main(String[] args) {
        BinaryTree app = new BinaryTree();
        TreeNode root = app.buildTree();
        System.out.print("inOrder -> ");
        app.inOrderTraversal(root);
        System.out.print("\npreOrder -> ");
        app.preOrderTraversal(root);
        System.out.print("\nposOrder -> ");
        app.posOrderTraversal(root);
    }
}
