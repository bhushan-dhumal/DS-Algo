/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Approach #3 Using HashMap [Accepted]

**Complexity Analysis**
Time complexity : O(n)O(n). The entire array is traversed only once.

Space complexity : O(n)O(n). Maximum size of the HashMap mapmap will be \text{n}n, if all the elements are either 1 or 0.
*/
public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
