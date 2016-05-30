#include<stdio.h>
#include<algorithm>

using namespace std;

int INF = (int) 1e9;
				
int main() {
				  
  int n, m;
  scanf("%d %d", &n, &m);
  
  char mat[n][m];
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      scanf("%c", &mat[i][j]);
  
  bool valid = true;
  for (int i = 0; i < n && valid; ++i) {
    bool ok = false;
    for (int j = 0; j < m; ++j)
      ok |= mat[i][j] == '1';
    if (!ok)
      valid = false;
  }
  
  int ans = -1;
  if (valid) {
    ans = INF;
    for (int col = 0; col < m; ++col) {
      int cnt = 0;
      for (int i = 0; i < n; ++i) {
	int d = INF;
	for (int l = col; l >= 0; --l)
	  if (mat[i][l] == '1') {
	    d = min(d, col - l);
	    d = min(d, m - (col - l));
	    break;
	  }
	for (int r = col; r < m; ++r)
	  if (mat[i][r] == '1') {
	    d = min(d, r - col);
	    d = min(d, m - (r - col));
	    break;
	  }
	cnt += d;
      }
      ans = min(ans, cnt);
    }
  }
  printf("%d\n", ans);

  return 0;
}
