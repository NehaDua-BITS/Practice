package dsa.easy.linkedlist;

//delete duplicate nodes and return distinct elements
public class DeleteDuplicates {

    public static void main(String[] args) {
        DeleteDuplicates obj = new DeleteDuplicates();
        //[1,1,2,3,3]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        head = obj.deleteDuplicates(head);
        System.out.println("The unique elements linked list is : ");
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.next != null && (currNode.next.val == currNode.val)) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }
}
