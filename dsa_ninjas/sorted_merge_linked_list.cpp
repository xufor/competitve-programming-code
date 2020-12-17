#include <bits/stdc++.h>
#include "linked_list_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* merge(Node *head1, Node *head2) {
    if(!head1) {
        return head2;
    }
    if(!head2) {
        return head1;
    } 
    Node *final_head, *final_tail, *save;
    final_head = final_tail = (head1 -> data <= head2 -> data) ? head1 : head2;
    while(head1 != nullptr && head2 != nullptr) {
        if(head1 -> data <= head2 -> data) {
            save = head1;
            while(head1 != nullptr && (head1 -> data <= head2 -> data)) {
                save = head1;
                head1 = head1 -> next;
            }
            save -> next = final_tail = head2;
        }
        else {
            save = head2;
            while(head2 != nullptr && (head2 -> data < head1 -> data)) {
                save = head2;
                head2 = head2 -> next;
            }
            save -> next = final_tail = head1;
        }
    }
    return final_head;
}

int main() {
    Node *head1 = new Node(50, new Node(70, new Node(90, new Node(110))));
    Node *head2 = new Node(10, new Node(30));
    print_linked_list(merge(head1, head2));
}