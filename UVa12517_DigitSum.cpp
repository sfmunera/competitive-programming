/* USER: 46724 (sfmunera) */
/* PROBLEM: 3962 (12517 - Digit Sum) */
/* SUBMISSION: 10771356 */
/* SUBMISSION TIME: 2012-10-21 14:43:48 */
/* LANGUAGE: 3 */

#include<iostream>

using namespace std;

#define ll long long

ll sum(ll n) {
	return n * (n + 1) / 2;
}

ll sumDigits(ll n) {
	ll ans = 0LL;
	ll pow10 = 1LL;
	
	while (true) {
		ll mod = n % (pow10 * 10LL);
		ll rem = n / (pow10 * 10LL);
		ll x = mod / pow10;
		ll mod2 = mod % pow10;
		ans += pow10 * (rem * sum(9LL)+ sum(x - 1)) + x * (mod2 + 1);
		pow10 *= 10LL;
		if (rem == 0) break;
	}
	
	return ans;
}
	
int main() {
    ll M, N;
    
	while (true) {
		cin >> M;
		cin >> N;
		if (M == 0LL && N == 0LL) break;
		
		cout << sumDigits(N) - sumDigits(M - 1) << "\n";
	}
	return 0;
}
