package tree;



public class IsBinaryTreeBST {
	
	public boolean isBST(TreeNode root,int min,int max) {
		if(root==null)
			return true;
		if(root.val<=min || root.val>max) {
			return false;
		}
		return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
	}
	
	public class TreeNode{
		TreeNode right;
		TreeNode left;
		int val=0;
		TreeNode(int val){
			this.val = val;
		}
	}

}
