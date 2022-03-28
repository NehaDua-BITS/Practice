package dsa.medium.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleII {
    public static void main(String[] args) {
        CycleII obj = new CycleII();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode result = obj.detectCycle(head);
        System.out.println("First node of loop = " + result.val);

        result = obj.detectCycleOptimised(head);
        System.out.println("First node of loop without extra memory = " + result.val);

    }

    // extra memory used
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

    //no extra memory used
    public ListNode detectCycleOptimised(ListNode head) {

        //find mid
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (fast == slow) {
                break;
            }
        }

        if (fast != null) {
            //slow is at mid and fast at end. So move it till end
            slow = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        return null;
    }
}
