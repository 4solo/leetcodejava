package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
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
	//leetcode question 2
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode current=head;
        int carry=0;
        while(l1!=null||l2!=null){
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            current.next=new ListNode(carry%10);
            carry=carry/10;
            current=current.next;
        }
        if(carry!=0){
            current.next=new ListNode(carry);
        }
        return head.next;
    }
	//leetcode question 9
	public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int start=0;
        int end=temp.length()-1;
        while(start<end){
            if(temp.charAt(start)!=temp.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
	//leetcode question 75
	public void sortColors(int[] nums) {
        int [] test=new int[3];
        for(int i=0;i<3;i++){
            test[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            test[nums[i]]++;
        }
        int sum=0;
        for(int i=0;i<3;i++){
            for(int j=sum;j<sum+test[i];j++){
                nums[j]=i;
            }
            sum=sum+test[i];
        }
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
    //leetcode question 144
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        Stack<TreeNode> mystack=new Stack<TreeNode>();
        TreeNode current=root;
        while(!mystack.empty()||current!=null){
            if(current!=null){
                mystack.push(current);
                result.add(current.val);
                current=current.left;
            }
            else{
                current=mystack.pop();
                current=current.right;
            }
        }
        return result;
 }
    //leetcode question 169
    public int majorityElement(int[] nums) {
        int count=0;
        int currentnum=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                currentnum=nums[i];
                count=1;
            }
            else {
                if(nums[i]==currentnum){
                    count=count+1;
                }
                else{
                    count=count-1;
                }
            }
        }
        return currentnum;
    }
    //leetcode question 171
    public int titleToNumber(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result=(s.charAt(i)-'A'+1)+result*26;
        }
        return result;
    }
    //leetcode question 191
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1) count+=1;
            n>>>=1;
        }
        return count;
    }
    //leetcode question 200
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    Explore(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void Explore(char[][]grid,int i,int j){
        int x=grid.length;
        int y=grid[0].length;
        if(i<0||j<0||i>x-1||j>y-1){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        Explore(grid,i+1,j);
        Explore(grid,i-1,j);
        Explore(grid,i,j-1);
        Explore(grid,i,j+1);
    }
    //leetcode question 206
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    //leetcode question 217
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> myset=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(myset.contains(nums[i])) return true;
            else myset.add(nums[i]);
        }
        return false;
    }
    //leetcode question 226 
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
    //leetcode question 235
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>=p.val&&root.val<=q.val) return root;
        else if(root.val>=q.val&&root.val<=p.val) return root;
        else if(root.val>q.val&&root.val>p.val) return lowestCommonAncestor(root.left,p,q);
        else return lowestCommonAncestor(root.right,p,q);
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
  	//leetcode question 238
  	public int[] productExceptSelf(int[] nums) {
        int [] left=new int[nums.length];
        int [] right=new int[nums.length];
        left[0]=1;
        for(int i =1 ;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        int [] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=left[i]*right[i];
        }
        return result;
    }
  	//leetcode question 242
  	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mymap=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(mymap.containsKey(s.charAt(i))){
                mymap.put(s.charAt(i),mymap.get(s.charAt(i))+1);
            }
            else{
                mymap.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(mymap.containsKey(t.charAt(i))){
                mymap.put(t.charAt(i),mymap.get(t.charAt(i))-1);
                if(mymap.get(t.charAt(i))==0){
                    mymap.remove(t.charAt(i));
                }
            }
            else{
                return false;
            }
        }
        return mymap.isEmpty();
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
    //leetcode question 263
    public boolean isUgly(int num) {
        if(num==0) return false;
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
    }
    //leetcode question 268
    public int missingNumber(int[] nums) {
        int result=-1;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        for(int i=0;i<nums.length+1;i++){
            result^=i;
        }
        result^=-1;
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
	//leetcode question 319
	public int bulbSwitch(int n) {
	       return (int)Math.sqrt(n);
	    }
}
 