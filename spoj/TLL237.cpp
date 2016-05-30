#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
    int N;
    cin >> N;
    string seq;
    cin >> seq;
    
    priority_queue<int> Q;
    for (int i = 0; i < N; ++i)
        Q.push(0);
    
    for (int i = 0; i < (int)seq.length(); ++i) {
        if (seq.at(i) == '1') {
            int less = -Q.top();
            Q.pop();
            ++less;
            Q.push(-less);
        } else {
            int less = -Q.top();
            Q.pop();
            int less2 = -Q.top();
            Q.pop();
            ++less2;
            Q.push(-less);
            Q.push(-less2);
        }
    }
    int less = -Q.top();
    Q.pop();
    int less2 = -Q.top();
    
    cout << less << " " << less2 << endl;
    
    return 0;
}
