package myself;

import org.w3c.dom.Node;

class treenode {
    int val;
    treenode left;
    treenode right;
    treenode() {}
    treenode(int val) { this.val = val; }
    treenode(int val, treenode left, treenode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Info{
    int height;//高度

    public Info(int height) {
        this.height = height;
    }
}
public class Solution10 {

    public int maxDepth(treenode root) {
        Info res = dfs(root);
        return res.height;
    }
    public Info dfs(treenode root) {
        if (root == null) {
            return new Info(0);
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        return new Info((left.height > right.height ? left.height : right.height) + 1);
    }
//    // 第一种方法
//    // 收集整棵树的高度h，和节点数n
//    // 只有满二叉树满足 : 2 ^ h - 1 == n
//    public static boolean isFull1(Node head) {
//        if (head == null) {
//            return true;
//        }
//        Info1 all = process1(head);
//        return (1 << all.height) - 1 == all.nodes;
//    }
//
//    public static class Info1 {
//        public int height;
//        public int nodes;
//        public Info1(int h, int n) {
//            height = h;
//            nodes = n;
//        }
//    }
//
//    public static Info1 process1(Node head) {
//        if (head == null) {
//            return new Info1(0, 0);
//        }
//        Info1 leftInfo = process1(head.left);
//        Info1 rightInfo = process1(head.right);
//        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
//        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
//        return new Info1(height, nodes);
//    }
}
