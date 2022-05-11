package myself;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class treeNode {
      int val;
      treeNode left;
      treeNode right;
      treeNode() {}
      treeNode(int val) { this.val = val; }
      treeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class Solution7 {
    public List<List<Integer>> levelOrder(treeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<treeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);
        while (!q.isEmpty()) {//队列不空
            int size = q.size();
            List<Integer> temp = new LinkedList<Integer>();
            for (int i = 1; i <= size; i++) {
                treeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            result.add(temp);
        }
        return result;
    }
    //leetcode102
    public List<Integer> LevelOrder(treeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<treeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        q.offer(root);
        while (!q.isEmpty()) {//队列不空
            treeNode cur = q.poll();
            result.add(cur.val);
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        return result;
    }

    public static void main(String[] args) {
        treeNode root = new treeNode(0);
        root.left=new treeNode(2);
        treeNode treeNode = new treeNode(5);
        root.left.right=treeNode;
        root.right=new treeNode(9);
        List<Integer> integers = new Solution7().LevelOrder(root);
        for(int p:integers){
            System.out.println(p);
        }
    }

}
