#include <stdio.h>

using namespace std;

const int MAXM = 21;
int len[MAXM], M, sidelen;
bool seen[1 << 20][4], dp[1 << 20][4];

bool go(int mask, int side) {
	if (side == 4) return mask == (1 << M) - 1;
	
	if (seen[mask][side]) return dp[mask][side];
	seen[mask][side] = true;
	
	int sum = 0;
	for (int i = 0; i < M; ++i)
		if (mask & (1 << i))
			sum += len[i];
	int curlen = sum - sidelen * side;
	
	if (curlen == sidelen)
		return dp[mask][side] = go(mask, side + 1);
			
	for (int i = 0; i < M; ++i)
		if (!(mask & (1 << i))) {
			if (curlen + len[i] <= sidelen)
				if (go(mask | (1 << i), side))
					return dp[mask][side] = true;
		}
	return dp[mask][side] = false;
}

int main() {
	int T;
    scanf("%d", &T);
	while (T--) {
        scanf("%d", &M);
		int sum = 0;
		for (int i = 0; i < M; ++i) {
			scanf("%d", &len[i]);
			sum += len[i];
		}

		bool ok = sum % 4 == 0;
		sidelen = sum / 4;
		
        for (int i = 0; i < (1 << 20); ++i)
            seen[i][0] = seen[i][1] = seen[i][2] = seen[i][3] = false;
		if (ok) {
			if (sum == 0) ok = true;
			else ok = go(0, 0);
		}
		printf("%s\n", ok ? "yes" : "no");
		
	}
	return 0;
}
