/* USER: 46724 (sfmunera) */
/* PROBLEM: 3778 (12356 - Army Buddies) */
/* SUBMISSION: 11512065 */
/* SUBMISSION TIME: 2013-03-26 20:55:30 */
/* LANGUAGE: 3 */

#include <iostream>
#include <stdio.h>

using namespace std;

struct Node {
    int prev;
    int next;
    int val;
};

int main() {
    while (true) {
        int S, B;
        scanf("%d %d", &S, &B);
        if (S == 0 && B == 0) break;
        
        Node army[S + 1];
        for (int i = 1; i <= S; ++i) {
            army[i].prev = i > 1 ? i - 1 : -1;
            army[i].next = i < S ? i + 1 : -1;
            army[i].val = i;
        }
        
        for (int i = 0; i < B; ++i) {
            int L, R;
            scanf("%d %d", &L, &R);
            if (army[L].prev == -1) cout << "*";
            else cout << army[army[L].prev].val;
            cout << " ";
            if (army[R].next == -1) cout << "*";
            else cout << army[army[R].next].val;
            cout << "\n";
            if (army[L].prev != -1)
                army[army[L].prev].next = army[R].next == -1 ? -1 : army[army[R].next].val;
            if (army[R].next != -1)
                army[army[R].next].prev = army[L].prev == -1 ? -1 : army[army[L].prev].val;
        }
        
        cout << "-" << "\n";
    }
    
    return 0;
}
