/* USER: 46724 (sfmunera) */
/* PROBLEM: 2733 (11686 - Pick up sticks) */
/* SUBMISSION: 10773986 */
/* SUBMISSION TIME: 2012-10-22 03:35:47 */
/* LANGUAGE: 3 */

#include <iostream>
#include <queue>

using namespace std;

int main() {
	while (true) {
        int M, N;
		cin >> N >> M;
		if (N == 0 && M == 0) break;
        
		int indegree[N];
		vector< vector<int> > G(N);
        
        for (int i = 0; i < N; ++i)
            indegree[i] = 0;

		for (int i = 0; i < M; ++i) {
			int from, to;
            cin >> from >> to;
            ++indegree[to - 1];
			G[from - 1].push_back(to - 1);
		}
		
		bool visited[N];
        vector<int> sort;
        queue<int> Q;
        
        for (int i = 0; i < N; ++i)
            visited[i] = false;
        
        for (int s = 0; s < N; ++s)
            if (indegree[s] == 0) {
                visited[s] = true;
                Q.push(s);
            }
        while (!Q.empty()) {
            int u = Q.front(); Q.pop();
            sort.push_back(u);
            for (int i = 0; i < (int)G[u].size(); ++i) {
                int v = G[u][i];
                --indegree[v];
                if (!visited[v] && indegree[v] == 0) {
                    visited[v] = true;
                    Q.push(v);
                }
            }
        }
		if ((int)sort.size() != N)
			cout << "IMPOSSIBLE" << "\n";
		else
			for (int i = 0; i < (int)sort.size(); ++i)
				cout << sort[i] + 1 << "\n";
	}
	return 0;
}
