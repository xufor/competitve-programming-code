#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
typedef long long ll;
using namespace std;

class Node {
public: 
    Node * next;
    int data;

    Node(int data) {
        next = nullptr;
        this -> data = data;
    }

    ~Node() {
        delete next;
    }
};

void print(Node *head) {
    while(head != nullptr) {
        cout << head -> data << sp;
        head = head -> next;
    }
    cout << nl;
}

Node* reverse(Node *head) {
    Node *p = nullptr, *q = nullptr, *r = head;
    while(r != nullptr) {
        p = q;
        q = r;
        r = r -> next;
        q -> next = p; 
    }
    return q;
}

Node* reverse(Node *p, Node *q) {
    if(q != nullptr) {
        Node* temp = reverse(q, q->next);
        q -> next =  p;
        return temp;
    } 
    return p;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    Node *head = new Node(1);
    for(int i = 2; i <= 5; i++) {
        Node *temp = new Node(i*i);
        temp -> next = head;
        head = temp;
    }
    print(head);
    head = reverse(head);
    print(head);
    head = reverse(nullptr, head);
    print(head);
}