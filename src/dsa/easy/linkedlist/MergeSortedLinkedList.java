package dsa.easy.linkedlist;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        MergeSortedLinkedList obj = new MergeSortedLinkedList();
        ListNode head1 = ListNode.getSampleList(5);
        ListNode head2 = ListNode.getSampleList(3);
        System.out.println("Original List 1 : " + head1);
        System.out.println("Original List 2 : " + head2);

        ListNode head = obj.mergeTwoLists(head1, head2);
        System.out.println("Merged List = " + head);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = list1;
        ListNode prev = null;

        while (list1 != null && list2 != null) {

            ListNode selected;

            if (list1.val <= list2.val) {
                selected = list1;
                list1 = list1.next;
            } else {
                selected = list2;
                list2 = list2.next;
            }

            if (prev == null) {
                head = selected;
            } else {
                prev.next = selected;
            }

            prev = selected;
        }

        while (list1 != null) {
            prev.next = list1;
            prev = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            prev.next = list2;
            prev = list2;
            list2 = list2.next;
        }

        return head;
    }
}
