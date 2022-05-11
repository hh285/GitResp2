package myself;

import java.util.*;
import java.util.logging.Level;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode() {
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution12 {
    public int[] diff(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int cur = 0;
        for (int i = 1; i <= len - 1; i++) {
            if (nums[i] != nums[cur]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        int[] ints = new int[cur + 1];
        for (int i = 0; i <= cur; i++) {
            ints[i] = nums[i];
        }
        return ints;
    }
    TreeNode createNode(int[] diff,int index){
        int len=diff.length;
        if(len==0){return null;}
        if(index<0||index>=len){
            return null;
        }
        TreeNode root=new TreeNode(diff[index]);
        root.left=createNode(diff,2*index+1);
        root.right=createNode(diff,2*index+2);
        return root;
    }
    public void LevelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            TreeNode cur=treeNodes.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null){
                treeNodes.add(cur.left);
            }
            if (cur.right!=null){
                treeNodes.add(cur.right);
            }
        }
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder1(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            System.out.print(root.val+" ");
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }

        }
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public void inOrder2(TreeNode root){//左根右
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.pop();
            System.out.print(root.val+" ");
            root=root.right;
        }
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val+" ");
    }

    public void postOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null) {
                System.out.println(top.val);
                pre = stack.pop();
            } else if (top .right == pre) {
                System.out.println(top.val);
                pre = stack.pop();
            } else {
                cur = top.right;//没问题
            }
        }
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len=scanner.nextInt();
        int[] nums=new int[len];
        for(int i=0;i<len;i++){
            nums[i]=scanner.nextInt();
        }
        int[] diff = new Solution12().diff(nums);
        for(int p:diff){
            System.out.print(p+" ");
        }
        System.out.println();
        TreeNode root=new Solution12().createNode(diff,0);
        new Solution12().LevelOrder(root);
        System.out.println();
        new Solution12().preOrder(root);
        System.out.println();
        new Solution12().preOrder1(root);
        System.out.println();
        new Solution12().inOrder(root);
        System.out.println();
        new Solution12().inOrder2(root);
        System.out.println();
        new Solution12().postOrder(root);
    }
}
