#include <stdio.h>
#include <string.h>

using namespace std;

char s[5001];
int dp[5001][5001], dp2[5001][5001];

bool isPalindrome(int l, int r) {
	if (l >= r)
		return true;

	if (dp2[l][r] != -1)
		return dp2[l][r] == 1;

	return (dp2[l][r] = (s[l] == s[r] && isPalindrome(l + 1, r - 1)) ? 1 : 0) == 1;
}

int go(int l, int r) {
	if (l > r)
		return 0;
	if (l == r)
		return 1;
	if (dp[l][r] != -1)
    	return dp[l][r];
	return dp[l][r] = (isPalindrome(l, r) ? 1 : 0) + go(l + 1, r) + go(l, r - 1) - go(l + 1, r - 1);
}

int main() {
    scanf("%s", s);
    memset(dp, -1, sizeof (dp));
    memset(dp2, -1, sizeof (dp2));
    
    int q;
    scanf("%d", &q);
    
    for (int i = 0; i < q; ++i) {
        int l, r;
        scanf("%d %d", &l, &r);
        printf("%d\n", go(l - 1, r - 1));
    }

    return 0;
}
