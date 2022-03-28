package dsa.easy.linkedlist;

public class LoopInList {

    public static void main(String[] args) {
        LoopInList obj = new LoopInList();
        ListNode head = ListNode.getSampleList(4);
        head.next.next.next = head; //tail connected to 2nd node

        boolean hasLoop = obj.hasLoop(head);
        System.out.println("Has Loop = " + hasLoop);
    }

    boolean hasLoop(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast.next == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
