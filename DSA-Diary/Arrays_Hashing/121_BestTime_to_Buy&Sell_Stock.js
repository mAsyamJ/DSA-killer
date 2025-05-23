/**You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104 */

// USING AN ARRAY SOLUTION O(n^2) Complexity

var maxProfit = function(prices) {
    let maxProfit=0;
    for(let i=0;i<prices.length;i++){
        for(let j=i+1;j<prices.length;j++){
            if(prices[j]>prices[i]){
                profit=prices[j]-prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        } 
    }
    return maxProfit;
};

// USING O(n) and O{1}

var maxProfit = function(prices) {
    let maxProfit=0,
        minPrice=Infinity;
    for(let i=0;i<prices.length;i++){
        if(prices[i]<minPrice){
            minPrice=prices[i];
        } else {
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }
    }
    return maxProfit;
};

// by Utilizing Infinity, we can return new min price in iteration after loop, no matter what it is.
// And with maxProfit=Math.max(maxProfit, prices[i]-minPrice); function, we automatically search the largest gap number between prices[i
// and minPrice each iteration of loop
