package dsa.medium.linkedlist;

import java.util.HashSet;

public class IntersectionNode {

    public static void main(String[] args) {
        IntersectionNode obj = new IntersectionNode();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = l1.next;

        ListNode result = obj.getIntersectionNode(l1, l2);
        System.out.println("Intersects node using space : " + (result!=null ? result.val : null));

        result = obj.getIntersectionNodeNoSpace(l1, l2);
        System.out.println("Intersection node using 0 space : " + (result!=null ? result.val : null));
    }

    //O(m+n) & using extra space O(m)
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectVal = null;
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                intersectVal = headB;
                break;
            }
            headB = headB.next;
        }

        return intersectVal;
    }

    //without using extra space -> //count number of nodes
    private ListNode getIntersectionNodeNoSpace(ListNode headA, ListNode headB) {

        ListNode result = null;

        if (headA == null || headB == null) {
            return null;
        }

        int countA = getNumberOfNodes(headA);
        int countB = getNumberOfNodes(headB);

        int diff = Math.abs(countA - countB);
        if (countA >= countB) {
            headA = skipDiffNodes(headA, diff);
        } else {
           headB = skipDiffNodes(headB, diff);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                result = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return result;
    }

    private ListNode skipDiffNodes(ListNode head, int diff) {
        for (int i = 0; i < diff && head!=null; i++) {
            head = head.next;
        }
        return head;
    }

    private int getNumberOfNodes(ListNode node) {
        int count = 0;
        ListNode temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
