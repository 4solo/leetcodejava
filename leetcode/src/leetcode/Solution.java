package leetcode;

public class Solution {
	
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	//leetcode question 100
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        else if(p!=null&&q!=null){
            if(p.val==q.val){
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
            else 
                return false;
        }
        else return false;
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
    //leetcode question 122 
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                sum=sum+prices[i]-prices[i-1];
            }
        }
        return sum;
    }
    //leetcode question 136
    public int singleNumberI(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        result^=0;
        return result;
    }
    //leetcode question 226 
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
    //leetcode question 237
  	 public void deleteNode(ListNode node) {
          if(node.next!=null){
              node.val=node.next.val;
              node.next=node.next.next;
          }
          else 
              node=null;
  	}
    //leetcode question 258
    public int addDigits(int num) {
        return num-9*((num-1)/9);
    }
    //leetcode question 260
    public int[] singleNumberIII(int[] nums) {
        int [] result =new int[2];
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp^=nums[i];
        }
        temp^=0;
        int count=0;
        while(true){
            if((temp&1)==1){
                break;
            }
            temp>>=1;
            count++;
        }
        for(int i=0;i<nums.length;i++){
            if(((nums[i]>>count)&1)==1){
                result[0]^=nums[i];
            }
            else {
                result[1]^=nums[i];
            }
        }
        result[0]^=0;
        result[1]^=0;
        return result;
    }
    //leetcode question 283
    public void moveZeroes(int[] nums) {
        int start=0;//start position
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[start]=nums[i];
                start=start+1;
            }
        }
        for(int i=start;i<nums.length;i++){
            nums[i]=0;
        }
    }
	//leetcode question 292
	public boolean canWinNim(int n) {
        if (n<4) return true;
        if (n%4==0) return false;
        return true; 
    }
	
}
 