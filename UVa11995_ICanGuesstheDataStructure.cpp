#include <stdio.h>
#include <queue>
#include <stack>
#include <priority_queue>

using namespace std;

int main() {
  int N;
  queue<int> Q;
  stack<int> S;
  priority_queue<int> PQ;
  bool isQueue;
  bool isStack;
  bool isPQueue;
  
  while (scanf("%d", &N)) {
    Q.clear();
    S.clear();
    PQ.clear();
    
    isQueue = true;
    isStack = true;
    isPQueue = true;
    
    while (N-- > 0) {
      int command, value;
      scanf("%d %d", &command, &value);
      
      if (command == 1) {
	if (isQueue)
	  Q.push_back(value);
	if (isStack)
	  S.push_back(value);
	if (isPQueue)
	  PQ.push_back(-value);
      } else {
	if (isQueue) {
	  int x = Q.pop_front();
	  if (Q.empty() || x != value)
	    isQueue = false;
	}
	if (isStack) {
	  int x = S.pop_back();
	  if (S.empty() || x != value) 
	    isStack = false;
	}
	if (isPQueue) {
	  int x = PQ.pop_back();
	  if (PQ.empty() || PQ.back() != -value)
	    isPQueue = false;
	}
      }
    }
    if (isQueue && !isStack && !isPQueue)
      printf("queue\n");
    else if (!isQueue && isStack && !isPQueue)
      printf("stack\n");
    else if (!isQueue && !isStack && isPQueue)
      printf("priority queue\n");
    else if (!isQueue && !isStack && !isPQueue)
      printf("impossible\n");
    else 
      printf("not sure\n");
  }
  return 0;
}
