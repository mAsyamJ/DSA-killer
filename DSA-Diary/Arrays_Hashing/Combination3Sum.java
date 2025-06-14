// MY SOLUTION
package Arrays_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// LeetCode Problem: https://leetcode.com/problems/3sum/
// Problem Statement: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

public class Combination3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}

// Time Complexity: O(n^2) - The outer loop runs n times, and the inner while
// loop runs at most n times in total.
// Space Complexity: O(1) - The space used for the result list is not counted in
// the space complexity analysis, as it depends on the input size.
// Note: The solution avoids duplicates by skipping over elements that are the
// same as the previous element in the sorted array.
// This ensures that we do not count the same triplet multiple times.
// Example Usage:
// Combination3Sum solution = new Combination3Sum();
// int[] nums = {-1, 0, 1, 2, -1, -4};
// List<List<Integer>> triplets = solution.threeSum(nums);
// System.out.println(triplets); // Output: [[-1, -1, 2], [-1, 0, 1]]
// The code defines a method to find all unique triplets in an array that sum to
// zero.
// It uses a two-pointer technique after sorting the array to efficiently find
// the triplets.
// The result is a list of lists, where each inner list contains three integers
// that form a valid triplet.
// The solution is efficient and handles duplicates by skipping over repeated
// elements in the sorted array.
// The example usage demonstrates how to call the method and print the resulting
// triplets.
// The code is structured to be reusable and can be easily integrated into
// larger applications or tested independently.
// The Combination3Sum class provides a method to find all unique triplets in an
// integer array that sum to zero.
// The method sorts the array and uses a two-pointer technique to find the
// triplets efficiently.
// The solution avoids duplicates by skipping over repeated elements in the
// sorted array.
// The time complexity is O(n^2), and the space complexity is O(1) for the
// algorithm itself, excluding the output list.
// The example usage shows how to create an instance of the Combination3Sum
// class, call the threeSum method with an input array, and print the resulting
// triplets.

// BACKTRACK SOLUTION
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // 🎯 Found a valid combination!
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return; // ❌ Over target, stop here

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            current.add(num); // 🔧 Choose this number
            backtrack(candidates, target - num, i, current, result); // 🔁 Recurse (can reuse same index!)
            current.remove(current.size() - 1); // 🔙 Backtrack: undo last step
        }
    }
}
// Example Usage:
// Solution solution = new Solution();
// int[] candidates = {2, 3, 6, 7};
// int target = 7;
// List<List<Integer>> combinations = solution.combinationSum(candidates,
// target);
// System.out.println(combinations); // Output: [[2, 2, 3], [7]]
// The code defines a method to find all unique combinations of numbers in an

// array that sum to a target value.
// It uses a backtracking approach to explore all possible combinations.
// The result is a list of lists, where each inner list contains integers that
// form a valid combination.
// The solution is efficient and handles duplicates by ensuring that the same
// number can be reused in the same combination.
// The time complexity is O(2^n) in the worst case, where n is the number of
// candidates, as each candidate can either be included or excluded in a
// combination.
// The space complexity is O(n) for the recursion stack and the result list.
// The example usage demonstrates how to call the method and print the resulting
// combinations.
// The code is structured to be reusable and can be easily integrated into
// larger applications or tested independently.