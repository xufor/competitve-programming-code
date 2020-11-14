#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
using namespace std;

typedef unordered_map<string, int> triplet;

triplet extended_gcd(int a, int b) {
    if(b == 0) {
        triplet base_case;
        base_case["gcd"] = a;
        base_case["x"] = 1;
        base_case["y"] = 0;
        return base_case;
    }
    triplet triplet_from_next_call = extended_gcd(b, a%b);
    triplet triplet_for_prev_call;
    triplet_for_prev_call["gcd"] = triplet_from_next_call["gcd"];
    triplet_for_prev_call["x"] = triplet_from_next_call["y"];
    triplet_for_prev_call["y"] = triplet_from_next_call["x"] - (a/b)*triplet_from_next_call["y"];
    return triplet_for_prev_call;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int a, b;
    cin >> a >> b;
    triplet answer_triplet = extended_gcd(a, b);
    cout << answer_triplet["gcd"] << sp << answer_triplet["x"] << sp << answer_triplet["y"];
    return 0;
}