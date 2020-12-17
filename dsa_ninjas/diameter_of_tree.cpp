#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

pair<int, int> diameter(Node *root) {
    if(root == nullptr) {
        return pair<int, int>(0, 0);
    }
    // first element in pair is height, second is for diameter
    pair<int, int> left = diameter(root -> left);
    pair<int, int> right = diameter(root -> right);
    int left_height = left.first;
    int right_height = right.first;
    int left_diameter = left.second;
    int right_diameter = right.second;
    pair<int, int> fresh_pair;
    fresh_pair.first = 1 + max(left_height, right_height);
    fresh_pair.second = max((left_height + right_height), max(left_diameter, right_diameter));
    return fresh_pair;
}

int main() {
    Node *root = new Node(1, new Node(2, new Node(4, new Node(6, new Node(8), nullptr), nullptr), 
        new Node(5, nullptr, new Node(7, nullptr, new Node(9)))), new Node(3));
    cout << "Diameter:" << diameter(root).second;;
}