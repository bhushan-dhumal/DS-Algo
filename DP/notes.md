# Dynamic Programming(DP)

## Common problems in DP :
1. 0-1 Knapsack (6)
1. Unbounded Knapsack (5)
1. Fibonaces (7)
1. LCS (15)
1. LIS (10)
1. Kadane's Algo (6)
1. Matrix Chain Multiplication (7)
1. DP on trees (4)
1. DP on grid (14)
1. Others(5)

## Types of Knapsack :
1. Fractional Knapsack ( can be solved by greedy approch)
1. 0-1 Knapsack( can be solved by DP/ recursive/memoization approch)
1. Unbounded Knapsack( can be solved by DP approch)

## 0-1 Knapsack
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack
``` C++
#include <bits/stdc++.h> 
using namespace std; 

// Driver code 
int main() 
{ 
	int val[] = { 60, 100, 120 }; 
	int wt[] = { 10, 20, 30 }; 
	int W = 50; 
	int n = sizeof(val) / sizeof(val[0]); 
	cout << knapSack(wt, val,W, n); 
	return 0; 
}
```
### Recursive
``` C++
int knapSack(int wt[], int val[], int W, int n) 
{ 
	if (n == 0 || W == 0) 
		return 0; 

	if (wt[n-1] <= W) 
		return max(val[n-1] + knapSack(wt, val, W - wt[n-1], n - 1), 
			knapSack(wt, val,W, n - 1)); 
	else
	    return knapSack(wt, val, W, n - 1); 
} 
```
### Memoization
``` C++
int knapSackRec(int wt[], int val[],int W, int n, int** dp) 
{ 
	if (n == 0 || W == 0) 
		return 0; 

	if (wt[n-1] <= W) 
		dp[n][W] = max(val[n-1] + knapSackRec(wt, val, W - wt[n-1], n - 1,dp), 
			knapSackRec(wt, val,W, n - 1,dp)); 
	else
	    dp[n][W] = knapSackRec(wt, val, W, n - 1,dp); 
	return dp[n][W];
} 
  
int knapSack(int wt[], int val[],int W, int n) 
{ 
    int** dp; 
    dp = new int*[n+1]; 
  
    for (int i = 0; i < n+1; i++) 
        dp[i] = new int[W + 1]; 
  
    for (int i = 0; i < n+1; i++)
        for(int j = 0; j< W+1;j++)
            dp[i][j] = -1;
  
    return knapSackRec(wt, val,W, n, dp); 
} 
```

## Common Problems related 0-1 Knapsack
1. Subset Sum
1. Equal Sum Partition
1. Count of Subset Sum
1. Minimum Subset Sum Difference
1. Target Sum(LeetCode)
1. Number Of Subset Sum given difference


