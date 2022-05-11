//package myself;
//
//import org.w3c.dom.Node;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Stack;
//
////二叉树中序非递归
////左根右
//class TreeNode {
//      int val;
//      treeNode left;
//      treeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, treeNode left, treeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//}
////94
//class Solution6 {
//    public List<Integer> inorderTraversal(treeNode root) {
//        List<Integer> res=new LinkedList<Integer>();
//        Stack<treeNode> stack = new Stack<>();
//        while (root!=null||!stack.isEmpty()){
//            while(root!=null){
//                stack.add(root);
//                root=root.left;
//            }
//            root=stack.pop();
//            res.add(root.val);
//            root=root.right;
//        }
//        return res;
//    }//左根右
//}


//层序遍历
//    public static void level(Node head) {
//        if (head == null) {
//            return;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(head);
//        while (!queue.isEmpty()) {
//            Node cur = queue.poll();
//            System.out.println(cur.value);
//            if (cur.left != null) {
//                queue.add(cur.left);
//            }
//            if (cur.right != null) {
//                queue.add(cur.right);
//            }
//        }
//    }