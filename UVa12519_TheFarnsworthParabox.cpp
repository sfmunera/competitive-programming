/* USER: 46724 (sfmunera) */
/* PROBLEM: 3964 (12519 - The Farnsworth Parabox) */
/* SUBMISSION: 10772328 */
/* SUBMISSION TIME: 2012-10-21 18:09:46 */
/* LANGUAGE: 3 */

#include <iostream>

using namespace std;

#define INF   (int)1e6


int main() {
	while (true) {
        int N, B;
		cin >> N >> B;
		if (N == 0 && B == 0) break;
		
		int adj[N][N];

		for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j) {
			    adj[i][j] = INF;
			    adj[i][i] = 0;
		    }
		
		for (int i = 0; i < B; ++i) {
            int u, v, t;
            cin >> u >> v >> t;
			adj[u - 1][v - 1] = t;
			adj[v - 1][u - 1] = -t;
		}
		
		for (int k = 0; k < N; ++k)
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);

		cout << (adj[0][0] < 0 ? "Y" : "N") << "\n";
	}
	return 0;
}
