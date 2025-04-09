/**
 * 169. Majority Element
Solved
Easy
Topics
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

// 1. My First Orginal Solution
var majorityElement = function(nums) {
    nums.sort(); 
    let n = nums.length;
    let target = Math.floor(n / 2);

    for (let i = 0; i <= n - target; i++) { //only loop from the amount of majority of an array
        let count = 1; // start from i it count as 1, never 0
        for (let j = i + 1; j < n; j++) { //iterate through second j=i+1
            if (nums[i] === nums[j]) { // if matches
                count++; // increase it count
            } else {
                break; //break and continue loop until we found the majority
            }
        }

        if (count > target) { // if its exceed to target than that is the majority
            return nums[i];
        }
    }
};

// 2. Boyer-Moore Voting Algorithm, which add 1 if same and -1 of not same, if its reach 0 then find another number in sorted array
var majorityElement = function(nums) {
    let count=0, //start from zero
        c=null; //null
    for(let num of nums){
        if(count===0) c=num; //if still 0 then add the value to change c=num as candidate
        count+=(num===c)?1:-1; //add 1 if its same and -1 if its not
    }
    return c; // return the majority
};