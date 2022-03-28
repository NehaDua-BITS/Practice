package dsa.easy.linkedlist;

public class ListIsPalindrome {

    public static void main(String[] args) {
        ListIsPalindrome obj = new ListIsPalindrome();
        int[] arr =  {2,2};
        ListNode head = ListNode.getSamplePalindromeList(arr);
        System.out.println("Original List : " + head);

        boolean isPalindrome = obj.isPalindromeUsingString(head);
        System.out.println("Is Palindrome = " + isPalindrome);
    }

    private boolean isPalindromeUsingString(ListNode head) {

        boolean isPalindrome = true;

        if (head != null && head.next != null) {
            //find middle
            ListNode fast = head;
            ListNode slow = head;

            StringBuilder sb = new StringBuilder().append(slow.val);
            int length = 1;
            while (fast != null && fast.next != null) {
                fast = fast.next;
                length++;
                if (fast.next != null) {
                    fast = fast.next;
                    length++;
                    slow = slow.next;
                    sb.append(slow.val);
                }
            }

            System.out.println("Partial string = " + sb + "; length = " + length);

            slow = slow.next;
            int i = length/2 - 1;
            while (slow != null) {
                if (slow.val != (sb.charAt(i) - '0')) {
                    isPalindrome = false;
                    break;
                }
                slow = slow.next;
                i--;
            }

        }

        return isPalindrome;
    }

}
