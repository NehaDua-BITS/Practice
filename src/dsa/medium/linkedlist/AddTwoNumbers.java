package dsa.medium.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        //[2,4,3]
        //[5,6,4]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sumHead = obj.addTwoNumbers(l1, l2);
        System.out.println("The list after adding numbers is : ");
        sumHead.printList();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode prev = null;
        ListNode head = null;
        int carry = 0;
        //iterate both the lists and add values
        for( ; l1 != null && l2 != null; l1=l1.next, l2=l2.next) {
            int sum = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }
            prev = newNode;
            carry = sum / 10;
        }

        //iterate remaining non-empty list
        ListNode currNode = l1 != null ? l1 : l2;
        while (currNode != null) {
            int sum = currNode.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            prev.next = newNode;
            prev = newNode;
            carry = sum/10;
            currNode = currNode.next;
        }

        //add extra node for carry if present
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }
}
