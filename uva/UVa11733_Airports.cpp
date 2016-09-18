/* USER: 46724 (sfmunera) */
/* PROBLEM: 2833 (11733 - Airports) */
/* SUBMISSION: 11563102 */
/* SUBMISSION TIME: 2013-04-05 19:29:28 */
/* LANGUAGE: 3 */

#include <stdio.h>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

#define MAXN 10005

vector<pair<int, pair<int, int> > > edges;
int p[MAXN], rank[MAXN];
int N, A, sets;

void init(int N) {
    sets = N;
    for (int i = 0; i < N; ++i) {
        rank[i] = 0;
        p[i] = i;
    }
}

int find(int u) {
    return u == p[u] ? u : (p[u] = find(p[u]));
}

void merge(int u, int v) {
    int pu = find(u);
    int pv = find(v);
    if (pu == pv) return;
			
    if (rank[pu] > rank[pv])
        p[pv] = pu;
    else
        p[pu] = pv;
    if (rank[pu] == rank[pv]) ++rank[pv];
    --sets;
}

int kruskal() {
    sort(edges.begin(), edges.end());

    init(N);
    int cost = 0;
    for (int i = 0; i < (int)edges.size(); ++i) {
        int w = edges[i].first;
        int u = edges[i].second.first;
        int v = edges[i].second.second;
        if (find(u) != find(v) && w < A) {
            cost += w;
            merge(u, v);
        }
    }
    return cost;
}

int main() {
    int T;
    scanf("%d", &T);

	for (int t = 1; t <= T; ++t) {
        int M;
        scanf("%d %d %d", &N, &M, &A);
        edges.clear();

        for (int i = 0; i < M; ++i) {
            int u, v, w;
            scanf("%d %d %d", &u, &v, &w);
            edges.push_back(make_pair(w, make_pair(u - 1, v - 1)));
        }

		int cost = kruskal();
		int ans = sets * A + cost;
        
        printf("Case #%d: %d %d\n", t, ans, sets);
    }
    
    return 0;		
}
