package tree;

/*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its depth = 3.
 */
import tree.InvertTree.TreeNode;

public class MininumDepthOfBinaryTree {
	public static void main(String[]args) {
		
	}
	
	public static int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
			return 1;
		return depth(root,0);
	}
	
	public static int depth(TreeNode root, int length) {
		if(root==null)
			return length;
		int left = depth(root.left,length+1);
		int right = depth(root.right,length+1);
		return (left==0||right==0)?left+right+1:Math.min(left, right)+1;
	}
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

}
