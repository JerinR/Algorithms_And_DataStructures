package bfs;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrder {
	public static void main(String[]args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrderBottom(root);
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return new ArrayList();
        List<List<Integer>> ls = new ArrayList();
        List<Integer> node = new ArrayList();
        List<TreeNode> nd = new ArrayList();
        node.add(root.val);
        nd.add(root);
        ls.add(node);
        while(node.size()>0){
            int len = node.size();
            node = new ArrayList();
            for(int i=0;i<len;i++){
                TreeNode temp = nd.get(0);
                nd.remove(0);
                
                if(temp.left!=null){
                    nd.add(temp.left);
                    node.add(temp.left.val);
                }
                if(temp.right!=null){
                    nd.add(temp.right);
                    node.add(temp.right.val);
                }
            }
            if(node.size()>0)
                ls.add(node);
        }
        Collections.reverse(ls);
        return ls;
    }
	public static class TreeNode {
		  int val;
		  TreeNode left;
		  TreeNode right;
		  TreeNode(int x) { val = x; }
	}
}
