class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head node to simplify the construction of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop as long as there are elements in l1, l2, or a remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from l1 if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate new carry (will be either 0 or 1)
            carry = sum / 10;

            // Create a new node with the single-digit value and attach it
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // Return the actual head of the resulting linked list
        return dummyHead.next;
    }
}