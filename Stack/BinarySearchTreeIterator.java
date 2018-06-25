package stack;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
import java.util.Stack;


public class BinarySearchTreeIterator {
	public static void main(String[]args) {
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(9);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(10);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(8);
		root.left.left.left.right = new TreeNode(5);
		root.left.left.left.right.right = new TreeNode(6);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(15);
		root.right.right.right = new TreeNode(22);
		
		BSTIterator i = new BSTIterator(root);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

class BSTIterator {
    
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        if(root!=null)
            st.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.peek();
        while(node.left!=null){
            st.push(node.left);
            node = node.left;
        }
        TreeNode temp = st.pop();
        int val = temp.val;
        if(temp.right!=null){
            st.add(temp.right);
            while(temp.left!=null){
                st.push(temp.left);
                temp = temp.left;
            }
        }
      
        if(!st.isEmpty()) st.peek().left = null;
        return val;
    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}