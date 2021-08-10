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
	{
	// you have choice to include item in knapsack(bag)
		return max(val[n-1] + knapSack(wt, val, W - wt[n-1], n - 1), 
			knapSack(wt, val,W, n - 1)); 
	}
	else
	{
	// you do not have choice to include item in knapsack(bag)
	    return knapSack(wt, val, W, n - 1);
	}
} 
```
### DP(Memoization)
``` C++
int knapSackRec(int wt[], int val[],int W, int n, int** dp) 
{ 
	if (n == 0 || W == 0) 
		return 0; 

	if (wt[n-1] <= W)
	{
	// you have choice to include item in knapsack(bag)
		dp[n][W] = max(val[n-1] + knapSackRec(wt, val, W - wt[n-1], n - 1,dp), 
			knapSackRec(wt, val,W, n - 1,dp));
	}
	else if(wt[n-1] > W)
	{
	// you do not have choice to include item in knapsack(bag)
	    dp[n][W] = knapSackRec(wt, val, W, n - 1,dp); 
	return dp[n][W];
	}
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

### DP(Tabular)
``` C++
int knapSack(int wt[], int val[],int W, int n) 
{ 
	int dp[n+1][W+1];
	for(int i = 0; i <n+1;i++)
	{
	    for(int j = 0;j <W+1;j++)
	    {
	        if (i == 0 || j == 0) 
	            dp[i][j]=0;
	        else if(wt[i-1] <= j)
	            dp[i][j] = max(val[i-1]+dp[i-1][j - wt[i-1]],dp[i-1][j]);
	        else
	            dp[i][j] = dp[i-1][j];
	    }
	}
	return dp[n][W];
}
```

## Common Problems related 0-1 Knapsack
1. Subset Sum
1. Equal Sum Partition
1. Count of Subset Sum
1. Minimum Subset Sum Difference
1. Target Sum(LeetCode)
1. Number Of Subset Sum given difference


