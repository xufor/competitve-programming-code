#include <bits/stdc++.h>

using namespace std;

void breadth_first_search(int g[][7], int start, int n) {
    int vertex;
    queue<int> q;
    vector<bool> visited(7, false);
    cout << start << " ";
    visited[start] = true;
    q.push(start);
    while(!q.empty()) {
        vertex = q.front();
        q.pop();
        for(int i = 1; i < n; i++) {
            if(g[vertex][i] && !visited[i]) {
                cout << i << " ";
                visited[i] = true;
                q.push(i);
            }
        }
    }
    cout << '\n';
}

void depth_first_search(int g[][7], int start, int n) {
    static vector<bool> visited(7, false);
    if(!visited[start]) {
        cout << start << " ";
        visited[start] = true;
        for(int j = 1; j < 7; j++) {
            if(g[start][j] && !visited[j])
                depth_first_search(g, j, n);
        }
    }
}

int main() {
    stack<int> s;
    int g[7][7] = {
            {0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0},
            {0,1,0,0,1,0,0},
            {0,1,0,0,1,0,0},
            {0,0,1,1,0,1,1},
            {0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0}
    };
    breadth_first_search(g, 1, 7);
    depth_first_search(g, 1, 7);
}