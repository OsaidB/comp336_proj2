package com.example.comp336_proj2;

public class TreeNode implements Comparable<TreeNode> {

    int frequency;
    char treeChar;
    TreeNode left;
    TreeNode right;

    public TreeNode(int frequency, char treeChar) {
        this.treeChar = treeChar;
        this.left = null;
        this.right = null;
        this.frequency = frequency;
    }

    public TreeNode() {
        super();
    }

    @Override
    public int compareTo(TreeNode other) {
        int result=0;

        result = (this.frequency) - (other.frequency);
        return result;  //  (-)->this frq   less
                        //  (0)->equals
                        //  (+)->this frq   greater
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "frequency=" + frequency +
                ", element=" + treeChar +
                '}';
    }
}
