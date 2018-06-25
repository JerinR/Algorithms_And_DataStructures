package tree;

/* Input : Binary Tree
 * Output :count of largest Binary Tree
 * Implementation - POST ORDER TRAVERSAL
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece
 * of information to root which isBST, size of max BST, min and max in those
 * subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size +
 * right size + 1 and new min will be min of left side and new max will be max of
 * right side.
 * */
public class LongestBSTInBinaryTree {
	public static void main(String[]args) {
		
	}
	
	public static BST checkBST(TreeNode root) {
		if(root==null)
			return null;
		if(root.left==null && root.right==null)
			return new BST(true,1,root.val,root.val);
		BST left = checkBST(root.left);
		BST right = checkBST(root.right);
		BST curr;
		if(left.isBST==false || right.isBST==false || (left.maxNode>root.val || right.minNode<=root.val)) {
			curr = new BST(false,Math.max(left.countNodes, right.countNodes),root.val,root.val);
		}
		else {
			curr = new BST(true,left.countNodes+right.countNodes+1,
							root.left==null?root.val:left.minNode,
							root.right==null?root.val:right.maxNode);
		}
		return curr;
	}

	public static class BST{
		boolean isBST=false;
		int countNodes=0;
		int maxNode=Integer.MIN_VALUE;
		int minNode=Integer.MAX_VALUE;
		BST(boolean isBST,int countNodes,int maxNode,int minNode){
			this.isBST = isBST;
			this.countNodes = countNodes;
			this.maxNode = maxNode;
			this.minNode = minNode;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
}
