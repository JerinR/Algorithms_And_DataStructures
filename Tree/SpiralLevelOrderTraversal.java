package tree;

import java.util.Stack;

import tree.IterativePostOrderTraversal.TreeNode;
/* Input:tree
 * Output: Elements in spiral order
 * implementation: TWO STACKS
 * */

public class SpiralLevelOrderTraversal {
	public static void main(String[]args) {
		TreeNode root = new TreeNode(1);
		Stack<TreeNode> st = new Stack();
		Stack<TreeNode> st1 = new Stack();
		st.push(root);
		while(!st.isEmpty() || !st1.isEmpty()) {
			TreeNode curr;
			while(!st.empty()) {
				curr = st.pop();
				System.out.println(curr.val);
				if(curr.left!=null)
					st1.push(curr.left);
				if(curr.right!=null)
					st1.push(curr.right);
			}
			while(!st1.empty()) {
				curr = st1.pop();
				System.out.println();
				if(curr.left!=null)
					st.push(curr.right);
				if(curr.right!=null)
					st.push(curr.left);
			}
		}
	}

}
