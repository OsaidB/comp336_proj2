package com.example.comp336_proj2;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insertChar(int frequency,char element) {
        root = insertRecursive(root, frequency, element);
    }

    private TreeNode insertRecursive(TreeNode root,int frequency, char element) {
        if (root == null) {
            root = new TreeNode(frequency,element);
            return root;
        }

        if (element < root.treeChar) {
            root.left = insertRecursive(root.left, frequency,element);
        } else if (element > root.treeChar) {
            root.right = insertRecursive(root.right, frequency,element);
        }

        return root;
    }

    // Method to perform in-order traversal of the tree
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.treeChar + " ");
            inOrderTraversalRecursive(root.right);
        }
    }
}
