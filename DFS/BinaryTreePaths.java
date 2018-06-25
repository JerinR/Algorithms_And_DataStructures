package dfs;

/*
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *   1
 * /   \
 *2     3
 * \
 *  5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList();
        List<String>ls = new ArrayList();
        if(root!=null)
            binary(root,ls,"");
        return ls;
    }
    
    public void binary(TreeNode root,List<String> ls,String path){
        if(root.left == null && root.right == null){
            ls.add(path+root.val);
        }
        if(root.left != null) binary(root.left,ls,path+root.val+"->");
        if(root.right != null) binary(root.right,ls,path+root.val+"->");
        
            
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
