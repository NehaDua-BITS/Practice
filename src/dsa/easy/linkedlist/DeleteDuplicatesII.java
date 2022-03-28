package dsa.easy.linkedlist;

//Delete all nodes that have duplicate numbers
public class DeleteDuplicatesII {

    public static void main(String[] args) {
        DeleteDuplicatesII obj = new DeleteDuplicatesII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);

        head = obj.deleteDuplicates(head);
        System.out.println("The unique elements linked list is : ");
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    private ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        while (currNode != null) {
            if (currNode.next != null && currNode.next.val == currNode.val) {
                ListNode temp = currNode.next;
                while (temp.next != null && temp.next.val == currNode.val) {
                    temp = temp.next;
                }
                if (prevNode != null) {
                    prevNode.next = temp.next;
                } else {
                    head = temp.next;
                }
                currNode = temp.next;
            }
            else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
    }

}
