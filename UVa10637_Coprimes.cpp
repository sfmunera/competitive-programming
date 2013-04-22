#include <stdio.h>
#include <vector>

using namespace std;

int r, S;
vector<int> list;

int gcd(int a, int b) {
	return b == 0 ? a : gcd(b, a % b);
}

bool isCoprime(int x) {
	for (int i = 0; i < (int)list.size(); ++i)
		if (gcd(list[i], x) != 1)
			return false;
	return true;
}

void print() {
	bool first = true;
	for (int i = 0; i < (int)list.size(); ++i) {
		if (first) first = false; else printf(" ");
		printf("%d", list[i]);
	}
	printf("\n");
}

void go(int rem, int n) {
	if (n == r) {
		if (rem == 0) print();
		return;
	}
	
	int cur = 1;
	if (n > 0) cur = list[n - 1];
	for (int k = cur; k <= rem; ++k) {
		if (isCoprime(k)) {
			list.push_back(k);
			go(rem - k, n + 1);
			list.pop_back();
		}
	}
}

int main() {
	int T;
	scanf("%d", &T);
	for (int t = 1; t <= T; ++t) {
        scanf("%d %d", &S, &r);
		printf("Case %d:\n", t);
        
		list.clear();
		go(S, 0);
	}
	
	return 0;
}
