# sliding window
## fixed size

```
 while(j < size)
 {
    calculation
    
    if(window_size < k )
    {
      j++
    }
    else if(window_size == k)
    {
      ans calculation
      
      calculation to remove arr[i]
      
      window size maintain and slide
      
      j++  
     }
     
 }
```

### Max Sum Subarray of size K
https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

### First negative integer in every window of size k
https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#

### Count Occurences of Anagrams
https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#

### Maximum of all subarrays of size k 
https://leetcode.com/problems/sliding-window-maximum/
https://www.interviewbit.com/problems/sliding-window-maximum/#

## variable size

```
while(j < size)
{
  calculations
  if( condition < k)
  {
    j++
  }
  else if ( condition == k )
  {
    ans calculation
    j++
  }
  else if (condition > k )
  {
    while( condtion > k)
    {
      calculation to remove arr[i]
      i++
    }
    j++
  }
}
```
