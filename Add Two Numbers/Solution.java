/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry, sum;
        ListNode currentN = new ListNode(0);
        ListNode startN = currentN;

        while (currentN != null){
            sum = currentN.val;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            currentN.val = sum % 10;
            carry = sum / 10;

            if (carry > 0 || l1 != null || l2 != null)
                currentN.next = new ListNode(carry);
            else
                currentN.next = null;

            currentN = currentN.next;
        }
        return startN;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        num1 = new ListNode(0);
        num1.next = new ListNode(0);
        num1.next.next = new ListNode(9);

        num2 = new ListNode(9);
        num2.next = new ListNode(9);
        num2.next.next = new ListNode(9);

        ListNode ans = addTwoNumbers(num1, num2);

        while (ans != null)
        {
            System.out.print(ans.val);
            ans = ans.next;
        }
    }
}