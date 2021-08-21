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
