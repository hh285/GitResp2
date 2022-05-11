package myself;

import org.w3c.dom.Node;
class Node0{
    int val;
    Node0 next;
    public Node0(int val, Node0 next) {
        this.val = val;
        this.next = next;
    }
    public Node0(int val) {
        this.val = val;
    }
}

public class Solution9 {
    private boolean hasCycle(Node0 node) {
        if (node == null) {
            return false;
        }
        Node0 fast = node;
        Node0 slow = node;
        //此字段仅用来记录遍历次数
        int traverseCount = 0;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;//移动2步
            slow = slow.next;//移动1步
            traverseCount ++;
            if (fast == slow) {
                //如果碰面，就代表有环
                return true;
            }
        }
        return false;
    }
}
