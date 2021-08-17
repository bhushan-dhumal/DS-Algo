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


## 1. Subset Sum
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/subset-...

Youtueb Video Link : https://www.youtube.com/watch?v=_gPcYovP7wc&t=4s


### Solution (Tabular) :
1. Problem Statement - DONE
2. Similarity
3. Code Variation
   1. Initialization
   2. Code
``` c++
class Solution{   
public:
    bool isSubsetSum(int N, int arr[], int sum){
        bool dp[N+1][sum+1];
        
        // initialization
        // If sum is 0, then answer is true
        for(int i = 0; i < N+1; i++)
            dp[i][0] = true;
        // If sum is not 0 and set is empty,
        // then answer is false
        // DO NOT MISS that we are starting with i = 1
        for(int i = 1; i < sum+1; i++)
            dp[0][i] = false;

        
        // code
        // Fill the dp table in botton up manner
        // DO NOT MISS that we are starting with i=1 and j=1 
        for(int i = 1; i < N+1; i++)
        {
            for(int j = 1; j < sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        /*   // uncomment this code to print table
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= sum; j++)
                printf ("%4d", dp[i][j]);
            printf("\n");
        }*/
        return dp[N][sum];
    }
};
```

