#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
using namespace std;

/*
    we know that there is only one possible BBT for if I have only 0 or 1 nodes
    now I also know that if my left subtree has height = A and right subtree has height = B
    then the no. of possible BT will be A*B, now since I need only BBTs so the values
    of A and B can be 
        1) both will be of height h-1
        2) first will be of h-1 and second of h-2
        3) first will be of h-2 and second will be of h-1 
    now all I have to do is multipy all these combos and pass it to the next height level
    this works bcoz the next i.e. greter height level will depend on the lower levels

    for validating the A*B logic lets take a tree of height 2
        (1)  => height = 2
       /   \
    (2)     (3) => heights are 1 and 1 respectively
    now another variant of this tree will be 
        (1)  => height = 2
           \
           (2) => heights are 1 and 1 respectively
    final variant of this tree will be   
        (1)  => height = 2
       /
    (2) => heights are 1 and 1 respectively
    the subtree have heights 1 and 1
    but we dont have to multiply this, this is the trick
    we have to multipy all the no. of subtrees that have heights of 1 and 1
    since this is base case for height 1 and 1 we have 1 combo for each
    do the result becomes 1 * 1 trees, note that this is h-1 and h-1 case
    for h-2 and h-1 case we know that for height 0 and 1, only 1 and 1 combos exist
    now for h-1 and h-2 is very similar, for both these 1 * 1 = 1
    and now finally 1*1 + 1*1 + 1*1 = 3
    this is actually correct, when you run the program for 2 height you get 3 possible trees
    and now we know that we have to multipy the complete no. of possible trees for height h and not heights themselves
*/
int balancedBTs(int h) {
    if(h == 0 || h == 1) {
        return 1;
    } 
    int x = balancedBTs(h-1);
    int y = balancedBTs(h-2);
    return ((1LL*x*x)%limit + (1LL*x*y*2)%limit)%limit;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int h;
    cin >> h;
    cout << balancedBTs(h);
    return 0;
}