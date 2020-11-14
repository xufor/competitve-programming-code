#include <bits/stdc++.h>
#define sp " "
using namespace std;

int main()
{
    string s;
    int p, i, d;
    cin >> s >> p;
    for(i = 0; i < s.length(); i++) {
        if(s[i] + p > 'z') {
            d = (s[i] + p) - 122;
            if(d % 26 == 0)
                s[i] = 'z';
            else
                s[i] = 96 + (d % 26);
        }
        else
            s[i] += p;
    }
    cout << s;
    return 0;
}
