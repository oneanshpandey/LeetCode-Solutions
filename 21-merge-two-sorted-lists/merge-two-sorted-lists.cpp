/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // Create a dummy node to act as the starting anchor
        ListNode* dummy = new ListNode(0);
        ListNode* current = dummy;
        
        // Loop while both lists still have nodes to compare
        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val <= list2->val) {
                current->next = list1; // Link the smaller node
                list1 = list1->next;   // Move list1 forward
            } else {
                current->next = list2; // Link the smaller node
                list2 = list2->next;   // Move list2 forward
            }
            current = current->next;   // Move the merged list tracker forward
        }
        
        // If any elements remain in either list, append them to the end
        if (list1 != nullptr) {
            current->next = list1;
        } else {
            current->next = list2;
        }

        // The real head of the merged list is right after the dummy node
        ListNode* mergeHead = dummy->next;
        delete dummy; // Free the temporary memory to prevent a leak
        return mergeHead;
    }
};