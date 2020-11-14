class ListNode {
    public:
        int val;
        ListNode *next;
        ListNode() {
            val = 0;
            next = nullptr;
        }
        ListNode(int val) {
            this -> val = val;
        }
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
       int r, c = 0; 
       struct ListNode *l3 = nullptr, *save = nullptr, *cur = nullptr;
        while(l1 != nullptr && l2 != nullptr) {
            r = l1 -> val + l2 -> val + c;
            if(r > 9) {
                c = 1;
                cur = new ListNode(r - 10);
            } else {
                c = 0;
                cur = new ListNode(r);
            }
            if(l3 == nullptr) {
                l3 = save = cur;
            }
            else {
                save -> next = cur;
                save = cur;
            }
            l1 = l1 -> next;
            l2 = l2 -> next;
        }
        if(l2 == nullptr) {
            while(l1 != nullptr) {
                r = l1 -> val + c;
                if(r > 9) {
                    c = 1;
                    cur = new ListNode(r - 10);
                } else {
                    c = 0;
                    cur = new ListNode(r);
                }
                save -> next = cur;
                save = cur;
                l1 = l1 -> next;
            }
        }
        if(l1 == nullptr) {
            while(l2 != nullptr) {
                r = l2 -> val + c;
                if(r > 9) {
                    c = 1;
                    cur = new ListNode(r - 10);
                } else {
                    c = 0;
                    cur = new ListNode(r);
                }
                save -> next = cur;
                save = cur;
                l2 = l2 -> next;
            }
        }
        if(c == 1) {
            save -> next = new ListNode(1);
        }
        return l3;
    }
};