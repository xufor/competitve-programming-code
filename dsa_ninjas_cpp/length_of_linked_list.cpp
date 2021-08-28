#include <bits/stdc++.h>
#include "linked_list_template.h"
#define nl '\n'
#define sp " "
using namespace std;

int length(Node *head) {
    if(head == nullptr) {
        return 0;
    }
    return 1 + length(head -> next);
}

int main() {
    Node *head = new Node(50, new Node(70, new Node(90, new Node(110))));
    cout << length(head);
}