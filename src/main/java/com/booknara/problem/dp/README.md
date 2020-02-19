Dynamic Programming Patterns
===================================
This document explains several common patterns to solve DP problems

### Pattern list
1. Minimum (Maximum) Path to Reach a Target
2. Distinct Ways
3. Merging Intervals
4. DP on Strings
5. Decision Making

### Minimum (Maximum) Path to Reach a Target

#### Problem statements
Given a target find minimum (maximum) cost / path / sum to reach the target.

#### Approach
Choose minimum (maximum) path among all possible paths before the current state, then add value for the current state.

    routes[i] = min/max(routes[i-1], routes[i-2], ... , routes[i-k]) + cost[i]

Generate optimal solutions for all values in the target and return the value for the target.

```java
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] = min(dp[i], dp[i - ways[j]]) + cost / path / sum;
       }
   }
}

return dp[target]
```
#### Problem list
[746. Min Cost Climbing Stairs - Easy][100], [Solution][101]\
[64. Minimum Path Sum - Medium][102], [Solution][103]\
[322. Coin Change - Medium][104], [Solution][105]\
[931. Minimum Falling Path Sum - Medium][106]\
[983. Minimum Cost For Tickets - Medium][108]

[//]: <================================================================================================>

### Distinct Ways

#### Problem statements
Given a target find a number of distinct ways to reach the target.

#### Approach
Sum all possible ways to reach the current state.

    routes[i] = routes[i-1] + routes[i-2], ... , + routes[i-k]

Generate sum for all values in the target and return the value for the target.

```java
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] += dp[i - ways[j]];
       }
   }
}

return dp[target]
```

#### Problem list
[70. Climbing Stairs - Easy][200], [Solution][201]\
[62. Unique Paths - Medium][202], [Solution][203]\
[1155. Number of Dice Rolls With Target Sum][204]

[//]: <================================================================================================>

### Merging Intervals

#### Problem statements
Given a set of numbers, find an optimal solution for a problem considering the current number and the best you can get from the left and right sides.

#### Approach
Find all optimal solutions for every interval and return the best possible answer.

    // from i to j
    dp[i][j] = dp[i][k] + result[k] + dp[k+1][j]
    
Get the best from the left and right sides and add a solution for the current position.
```java
for(int l = 1; l< n; l++) {
   for(int i = 0; i< n-l; i++) {
       int j = i + l;
       for(int k = i; k < j; k++) {
           dp[i][j] = max(dp[i][j], dp[i][k] + result[k] + dp[k+1][j]);
       }
   }
}
 
return dp[0][n-1]
```

#### Problem list
[1130. Minimum Cost Tree From Leaf Values - Medium][300]\
[96. Unique Binary Search Trees - Medium][302], [Solution][303]\
[1039. Minimum Score Triangulation of Polygon - Medium][304]

[//]: <================================================================================================>

### DP on Strings
General problem statement for this pattern can vary but most of the time you are given two strings where lengths of those strings are not big
#### Problem statements
Given two strings s1 and s2, return some result.
#### Approach
Most of the problems on this pattern requires a solution that can be accepted in O(n^2) complexity.
```java
// i - indexing string s1
// j - indexing string s2
for (int i = 1; i <= n; ++i) {
   for (int j = 1; j <= m; ++j) {
       if (s1[i-1] == s2[j-1]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```
If you are given one string s the approach may little vary
```java
for (int l = 1; l < n; ++l) {
   for (int i = 0; i < n-l; ++i) {
       int j = i + l;
       if (s[i] == s[j]) {
           dp[i][j] = /*code*/;
       } else {
           dp[i][j] = /*code*/;
       }
   }
}
```
#### Problem list
[1143. Longest Common Subsequence - Medium][400]
[647. Palindromic Substrings - Medium][402]
[516. Longest Palindromic Subsequence - Medium][404]
[1092. Shortest Common Supersequence - Hard][406]
[712. Minimum ASCII Delete Sum for Two Strings - Medium][408]

[//]: <================================================================================================>

### Decision Making
The general problem statement for this pattern is forgiven situation decide whether to use or not to use the current state. So, the problem requires you to make a decision at a current state.
#### Problem statements
Given a set of values find an answer with an option to choose or ignore the current value.
#### Approach
If you decide to choose the current value use the previous result where the value was ignored; vice-versa, if you decide to ignore the current value use previous result where value was used.
```java
for (int i = 1; i < n; ++i) {
   dp[i][1] = max(dp[i-1][0] + nums[i], dp[i-1][1]);
   dp[i][0] = dp[i-1][1];
}
```
#### Problem list
[198. House Robber - Easy][500], [Solution][501]\
[714. Best Time to Buy and Sell Stock with Transaction Fee - Medium][504], [Solution][505]\
[309. Best Time to Buy and Sell Stock with Cooldown - Medium][506]\
[123. Best Time to Buy and Sell Stock III - Hard][508]\
[188. Best Time to Buy and Sell Stock IV - Hard][510]


### Credit & References
* [aatalyk][1000]
* [karansingh1559][1001]


License
-------
MIT License

Copyright (c) 2019 Daehee Han

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


[//]: <First_Pattern>
[100]: https://leetcode.com/problems/min-cost-climbing-stairs/
[101]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/MinCostClimbStairs.java
[102]: https://leetcode.com/problems/minimum-path-sum/
[103]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/MinimumPathSum.java
[104]: https://leetcode.com/problems/coin-change/
[105]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/CoinChange.java
[106]: https://leetcode.com/problems/minimum-falling-path-sum/
[108]: https://leetcode.com/problems/minimum-cost-for-tickets/

[//]: <Second_Pattern>
[200]: https://leetcode.com/problems/climbing-stairs/
[201]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/ClimbingStairs.java
[202]: https://leetcode.com/problems/unique-paths/
[203]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/UniquePaths.java 
[204]: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

[//]: <Third_Pattern>
[300]: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
[302]: https://leetcode.com/problems/unique-binary-search-trees/
[303]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/tree/UniqueBinarySearchTree.java
[304]: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

[//]: <Fourth_Pattern>
[400]: https://leetcode.com/problems/longest-common-subsequence/
[402]: https://leetcode.com/problems/palindromic-substrings/ 
[404]: https://leetcode.com/problems/longest-palindromic-subsequence/
[406]: https://leetcode.com/problems/shortest-common-supersequence/
[408]: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 
[//]: <Fifth_Pattern>
[500]: https://leetcode.com/problems/house-robber/
[501]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/HouseRobber.java
[504]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
[505]: https://github.com/booknara/playground/blob/master/src/main/java/com/booknara/problem/dp/BestTimeBuySellStockTransactionFee.java
[506]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
[508]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
[510]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/


[//]: <Pattern_reference>
[1000]: https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns 
[1001]: https://leetcode.com/discuss/general-discussion/491522/dynamic-programming-questions-thread
