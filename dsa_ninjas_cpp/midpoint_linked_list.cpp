#include <bits/stdc++.h>
#include "linked_list_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* mid_point(Node *head) {
    if(!head) {
        return nullptr;
    }
    Node *fast = head, *slow = head;
    while(fast -> next != nullptr && fast -> next -> next != nullptr) {
        fast = fast -> next -> next;
        slow = slow -> next;
    }
    return slow;
}

int main() {
    Node *head = new Node(50, new Node(70, new Node(90, new Node(110))));
    cout << mid_point(head) -> data;
}