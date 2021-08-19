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
GFG LINK:https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

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
    int knapSack(int W, int wt[], int val[], int n) 
    { 
        // Your code here
        int** dp; 
        dp = new int*[n+1]; 
        for (int i = 0; i < n+1; i++) 
            dp[i] = new int[W + 1]; 
  
        for (int i = 0; i < n+1; i++)
            for(int j = 0; j< W+1;j++)
                dp[i][j] = -1;
        int ret =  knapSackRec(W,wt,val,n,dp);
        /* // Uncomment below line to print dp
        for (int i = 0; i < n+1; i++)
        {
            for(int j = 0; j< W+1;j++)
            {
                cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }*/
        return ret;

    }
    
    int knapSackRec(int W, int wt[], int val[], int n, int** dp) 
    {
        if (n == 0 || W == 0) 
		return 0;
	if(dp[n][W] != -1)
		return dp[n][W];
        if(wt[n-1] <= W)
        {
            dp[n][W] = max(knapSackRec(W,wt,val,n-1,dp),val[n-1]+knapSackRec(W-wt[n-1],wt,val,n-1,dp));
        }
        else
        {
            dp[n][W] = knapSackRec(W,wt,val,n-1,dp);
        }
        return dp[n][W];        
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

GFGLINK:https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

YT Link : https://www.youtube.com/watch?v=_gPcYovP7wc&t=4s


### Solution (Tabular) :
1. Problem Statement - DONE
2. Similarity - 
In knapsack we have two arrays w[] and val[] array but they are ultimately represent one array which is item array here we have item array as arr[] and W which is total weight in knapsack problem here it represent as sum, and n is size of item array.
We can take knapsack code and igonore value array in it to get below code.
3. Code Variation
   1. Initialization
   2. Code
``` c++
class Solution{   
public:
    bool isSubsetSum(int N, int arr[], int sum){
        bool dp[N+1][sum+1];
        
        // 1. Initialization
        // If sum is 0, then answer is true
        for(int i = 0; i < N+1; i++)
            dp[i][0] = true;
        // If sum is not 0 and set is empty,
        // then answer is false
        // DO NOT MISS that we are starting with i = 1
        for(int i = 1; i < sum+1; i++)
            dp[0][i] = false;

        
        // 2. Code
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

## 2. Equal Sum Partition

Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
Examples:

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

GFG LINK:https://www.geeksforgeeks.org/partition-problem-dp-18/
LC LINK : https://leetcode.com/problems/partition-equal-subset-sum/
YT Explaination Link : https://www.youtube.com/watch?v=UmMh7xp07kY&t=5s

### Solution (Tabular/Bottom up DP approch) :
Flow
1. Problem statment
2. Similarity to Subset Sum : this problem is asking to find if sum(which is half of the total) is possible or not. so it is nothing but *subset sum* problem where sum is half of the total.
3. Odd/Even Significance : total of array should be even number then only we can array in equal partition i.e. if total of array is not even then we can directly return false.
4. Code Variation 

``` c++
class Solution{
public:
    int equalPartition(int N, int arr[])
    {
        // code here
        int total = 0;
        for(int i = 0; i < N;i++)
            total+=arr[i];
        if(total%2 == 1)
            return 0;
        int sum = total/2;
        int dp[N+1][sum+1];
        
        // initialize top row as true
        for(int i =0; i < N+1;i++)
            dp[i][0] = 1;
        
        // initialize leftmost column,
        // except part[0][0], as 0
        for(int i = 1; i < sum+1; i++)
            dp[0][i] = 0;
        // Fill the partition table in bottom up manner
        for(int i = 1; i < N+1;i++)
        {
            for(int j = 1; j <sum+1;j++)
            {
                if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
            }
        }
        // uncomment this code to print table
        /*for (int i = 0; i <= N; i++)
        {
            for (int j = 0; j <= sum; j++)
                printf ("%4d", dp[i][j]);
            printf("\n");
        }*/
        return dp[N][sum];
    }
};
```
## 3. Count of Subset Sum

Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

GFG LINK:https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
YT LINK: https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9

### Solution (Tabular/Bottom up DP approch) :
it is similar to subset sum . only couple of changes.
1. || changes to + because now we can not stop once we find the sum as we need count we need to continue searching for all counts.
2. return type changes from bool to int

Below solution is not tested. copied subset sum and did above two changes
``` c++
class Solution{   
public:
    int countSubsetSum(int N, int arr[], int sum){
        int dp[N+1][sum+1];
        
        // 1. Initialization
        // If sum is 0, then answer is true
        for(int i = 0; i < N+1; i++)
            dp[i][0] = 1;
        // If sum is not 0 and set is empty,
        // then answer is false
        // DO NOT MISS that we are starting with i = 1
        for(int i = 1; i < sum+1; i++)
            dp[0][i] = 0;

        
        // 2. Code
        // Fill the dp table in botton up manner
        // DO NOT MISS that we are starting with i=1 and j=1 
        for(int i = 1; i < N+1; i++)
        {
            for(int j = 1; j < sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
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

## 4. Minimum Subset Sum Difference

Sum of subset differences
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:
Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 

GFG :https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
YT : https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
### Solution (Tabular/Bottom up DP approch) :
- lets divide given array into two partitions P1 and P2 whose sums are S1 and S2 resepectively.
- we need to find minimum difference between S1 and S2 i.e. S2-S1 or S1-S2
  to get absolute difference we will pick S1 smaller than S2 so our solution is S2-S1
- We can calculate total sum by adding all elments of array lets call it total which is S1+S2
  so now we need to find total-S1-S1 (since S2 = total-S1) i.e. total - (2 * S1)
- our S1 and S2 both lie between 0 to total. for given example total is 23 so s1 and s2 are between 0 to 23
  and as S1 is smaller than S2, S1 can lie between 0 to total/2 so that S2 will be from other half(total/2 to total) . for given example S1 lie between 0 to 11
- To find S1,we can call subset sum method for total/2 and from last row of dp array we can find S1 for which difference is minimum.
