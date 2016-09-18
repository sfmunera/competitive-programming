/* USER: 46724 (sfmunera) */
/* PROBLEM: 3142 (11991 - Easy Problem from Rujia Liu?) */
/* SUBMISSION: 10879998 */
/* SUBMISSION TIME: 2012-11-13 13:35:22 */
/* LANGUAGE: 3 */

#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    map<int, int> position;
	vector<vector<int> > adj;
    int N, M;

	while (cin >> N) {
        cin >> M;

		for (int i = 0; i < N; ++i) {
			int num;
            cin >> num;
			int pos = (int)adj.size();
			if (position.find(num) != position.end())
	    		pos = position[num];
			else {
                vector<int> p;
				adj.push_back(p);
				position[num] = pos;
			}
            adj[pos].push_back(i);
		}

		for (int i = 0; i < M; ++i) {
			int K, V;
            cin >> K >> V;
			int ans = 0;
			if (position.find(V) != position.end()) {
				int pos = position[V];
				if (K <= (int)adj[pos].size())
					ans = adj[pos][K - 1] + 1;
			}
			cout << ans << endl;
		}
	}
    return 0;
}
