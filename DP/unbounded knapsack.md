# Unbounded Knapsack
Related Problems
1. Rod Cutting
2. Coin Change 1
3. Coin Change 2
4. Maximum Ribbon cut

## Unbounded Knapsack

Unbounded Knapsack (Repetition of items allowed)

Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate minimum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number  of instances of an item.

Examples:
Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}

Output : 100

There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
We get maximum value with option 2.

GFG Link : https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
YT Link : https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13

### Solution

In 0-1 knapsack we had two choices for any single item(provied its weight is less than equal to given weight arr[i-1] <=j). 
  if item weight is less than equal to given weight
  1. to include that item in bag
  2. to exclude that item from bag.
  else
  exclude that item from bag.

Whatever choice we make for that item , we considered that item as processed item and then never picked that item for further processing.
In unbounded knapsack we can consider that item for further processing.
But only when if that item is included in the bag . if that item is exclued from bag then we can consider it as proccessed item and then never picked that item for furthr processing.
Logic behind this approch is if item is eligible for bag then only it makes sense to consider it again and again if item is not eligible at first place then there is no point to consider it again and again.

So only change required in code is mentioned in comments.

``` c++ 
class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[N+1][W+1];
        for(int i = 0; i< N+1;i++)
        {
            for(int j = 0; j <W+1 ;j++)
            {
                if( i==0 || j ==0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j)
                    dp[i][j] = max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][W];
    }
};
```

## 1. Rod Cutting
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the  maximum value obtainable by cutting up the rod and selling the pieces. 
Example: 
if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
price    | 1   5   8   9  10  17  17  20

GFG Link : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

### Soultion
Variation of unbounded knapsack.
Replace weight to length, value to price

Few scenarios might not run. found few comments about it like - 
0-1/Fractional/Unbounded knapsack could be filled without reaching the capacity, but in rod cutting you need to reach the capacity (total length). 
``` c++
#include <iostream>
using namespace std;

int knapSack(int N, int W, int val[], int wt[])
{
    // code here
    int dp[N+1][W+1];
    for(int i = 0; i< N+1;i++)
    {
        for(int j = 0; j <W+1 ;j++)
        {
            if( i==0 || j ==0)
                dp[i][j] = 0;
            else if(wt[i-1] <= j)
                dp[i][j] = max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
            else
                dp[i][j] = dp[i-1][j];
        }
    }
    return dp[N][W];
}

/* Driver program to
test above functions */
int main()
{
	int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
	int n = sizeof(price) / sizeof(price[0]);
	int length[n];
	for (int i = 0; i < n; i++) {
		length[i] = i + 1;
	}
	int Max_len = n;

	// Function Call
	cout << "Maximum obtained value is "
		<< knapSack(n,Max_len,price,length) << endl;
}
```

### Similar problem like rod cutting :
GFG Link : https://www.geeksforgeeks.org/maximize-the-number-of-segments-of-length-p-q-and-r/ 
GFG Practice : https://practice.geeksforgeeks.org/problems/cutted-segments1642/1

## 1. Coin Change 1
