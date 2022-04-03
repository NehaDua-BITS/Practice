package dsa.adobe;

public class FactorialForLargeNumbers {

    public static void main(String[] args) {
        int n = 100;
        FactorialForLargeNumbers obj = new FactorialForLargeNumbers();
        String result = obj.factorial(n);
        System.out.println("Factorial of " + n + " is = " + result);
    }

    private String factorial(int n) {
        if (n == 0 || n == 1) {
            return "1";
        }

        Node tail = new Node(1);
        for (int i = 2; i <= n; i++) {
            performMultiply(tail, i);
        }

        return iterateFactorialResultList(tail);
    }

    private void performMultiply(Node tail, int n) {
        int carry = 0;
        Node prevNode = null;
        while (tail != null) {
            int product = tail.val * n + carry;
            tail.val = product % 10;
            carry = product / 10;
            prevNode = tail;
            tail = tail.prev;
        }

        //if last element and carry is there
        if (prevNode != null && carry > 0) {
            while (carry > 0) {
                Node newNode = new Node(carry%10);
                carry = carry / 10;
                prevNode.prev = newNode;
                prevNode = newNode;
            }
        }
    }

    private String iterateFactorialResultList(Node tail) {

        StringBuilder sb = new StringBuilder();
        while (tail != null) {
            sb.append(tail.val);
            tail = tail.prev;
        }

        return sb.reverse().toString();
    }

    class Node {
        int val;
        Node prev;

        Node(int val) {
            this.val = val;
            this.prev = null;
        }
    }
}
