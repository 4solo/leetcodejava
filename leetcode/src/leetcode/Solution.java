package leetcode;

public class Solution {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	//leetcode question 104
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null &&root.right!=null)
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        else if(root.left!=null)
            return maxDepth(root.left)+1;
        else 
            return maxDepth(root.right)+1;
    }
    //leetcode question 136
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        result^=0;
        return result;
    }
    //leetcode question 258
    public int addDigits(int num) {
        return num-9*((num-1)/9);
    }
    
	//leetcode question 292
	public boolean canWinNim(int n) {
        if (n<4) return true;
        if (n%4==0) return false;
        return true; 
    }
	
  

}
 