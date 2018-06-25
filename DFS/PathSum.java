package dfs;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 */
public class PathSum {
	public static void main(String[]args) {
		PathSum path = new PathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(path.hasPathSum(root, 22));
	}
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root.left == null && root.right==null && sum==root.val)
            return true;
        if(root.left == null && root.right==null && sum!=root.val)
            return false;
        return path(root,sum,root.val);
    }
    public boolean path(TreeNode root, int sum, int total){
        if(root.left == null && root.right==null && sum==total)
            return true;
        else if(root.left == null && root.right==null && sum!=total)
            return false;
        else if(root.left==null && root.right!=null)
            return path(root.right,sum,total+root.right.val);
        else if(root.right==null && root.left!=null)
            return path(root.left,sum,total+root.left.val);
        
        else{
            boolean left = path(root.left,sum,total+root.left.val);
            if(left) return true;
            boolean right = path(root.right,sum,total+root.right.val);
            if(right) return true;
            return false;
        }
        
    }

    public static class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }
}
