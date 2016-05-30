#include <stdio.h>
#include <algorithm>

using namespace std;

#define INF 1000000000
#define MAX 10001

int value[MAX][MAX];
int dp[MAX][MAX];
int sum[MAX];
int depots[MAX];

// f(i, a) -> min strategic value from [0, i], with a attacks (0 <= i < n, 0 <= a <= m)
// f(i, a) -> min_{0 <= j < i} {f(j, a-1) + value(j+1, i)}
// f(0, a) -> 0
// f(i, 0) -> value(0, i)
int doDp(int n, int m) {
    for (int a = 0; a <= m; ++a) dp[0][a] = 0;
    for (int i = 0; i < n; ++i) dp[i][0] = value[0][i];
		
    for (int i = 1; i < n; ++i) {
	for (int a = 1; a <= m; ++a) {
	    dp[i][a] = INF;
	    for (int j = 0; j < i; ++j) {
		dp[i][a] = min(dp[i][a], dp[j][a - 1] + value[j + 1][i]);
	    }
	}
    }
		
    return dp[n - 1][m];
}
	
// values(i, i) = 0
// values(i, j) = values(i, j - 1) + sum(i, j - 1) * depots[j]; j > i
void calcValues(int n) {
    for (int i = 0; i < n; ++i) {
	sum[i] = depots[i] + (i > 0 ? sum[i - 1] : 0);
	value[i][i] = 0;
    }
		
    for (int i = 0; i < n - 1; ++i) {
	for (int j = i + 1; j < n; ++j) {
	    value[i][j] = value[i][j - 1] + depots[j] * (sum[j - 1] - (i > 0 ? sum[i - 1] : 0));
	}
    }
}
	
int main() {
    while (true) {
	int n, m;
	scanf("%d %d", &n, &m);
			
	if (n == 0 && m == 0) break;
			
	for (int i = 0; i < n; ++i) {
	    scanf("%d", &depots[i]);
	}
	calcValues(n);

	printf("%d\n", doDp(n, m));
    }
    return  0;
}
