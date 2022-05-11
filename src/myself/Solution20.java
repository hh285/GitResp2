package myself;

import java.util.HashMap;
import java.util.Map;

class Node {
      int val;
      Node left;
      Node right;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class Solution20 {
    int ans=0;
    public int pathSum(Node root, int targetSum) {
        if(root==null){
            return 0;
        }
        dfs(root,targetSum);
        return ans;
    }
    public void dfs(Node root, int targetSum){
        if(root==null){
            return ;
        }
        process(root,root.val,targetSum);
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }
    public void process(Node root,int cur,int targetsum){
        if(cur==targetsum){ans++;}
        if(root.left!=null){
            process(root.left,cur+root.left.val,targetsum);
        }
        if(root.right!=null){
            process(root.right,cur+root.right.val,targetsum);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
//        Node node4=new Node(4);
//        Node node5=new Node(5);
        node1.right=node2;
        node2.right=node3;
//        node3.right=node4;
//        node4.right=node5;
        int res = new Solution20().pathSum(node1, 3);
        System.out.println(res);
    }
//    class Solution {
//        public int pathSum(TreeNode root, int targetSum) {
//            Map<Long, Integer> prefix = new HashMap<Long, Integer>();
//            prefix.put(0L, 1);
//            return dfs(root, prefix, 0, targetSum);
//        }
//
//        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
//            if (root == null) {
//                return 0;
//            }
//
//            int ret = 0;
//            curr += root.val;//前缀和
//
//            ret = prefix.getOrDefault(curr - targetSum, 0);//差值刚好
//            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);//推入

//            ret += dfs(root.left, prefix, curr, targetSum);
//            ret += dfs(root.right, prefix, curr, targetSum);

//            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);//回退
//
//            return ret;
//        }
//    }

}
