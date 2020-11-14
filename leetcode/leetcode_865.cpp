#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

class TreeNode {
    public:
        int val;
        TreeNode *left;
        TreeNode *right;
};

void pre_order(TreeNode *p, int prev, TreeNode* parent, unordered_map<TreeNode*, pair<TreeNode*, int> > &store) {
    if(p) {
        store[p] = make_pair(parent, prev);
        pre_order(p -> left, prev+1, p, store);
        pre_order(p -> right, prev+1, p,  store);
    }
}

TreeNode* subtreeWithAllDeepest(TreeNode* root) {
    if(!root) {
        return nullptr;
    }
    unordered_map<TreeNode*, pair< TreeNode*, int> > store;
    pre_order(root, 1, root, store);
    int m = INT_MIN;
    TreeNode *t;
    for(auto p: store) {
        if(p.second.second > m) {
            m = p.second.second;
            t = p.first;
        }
    }
    unordered_set<TreeNode*> ls, nls;
    for(auto p: store) {
        if(p.second.second == m) {
            ls.insert(p.first);
        }
    }
    while(ls.size() != 1) {
        nls.clear();
        for(TreeNode* n: ls) {
            nls.insert(store[n].first);
        }
        ls = nls;
    }
    return *ls.begin();
}