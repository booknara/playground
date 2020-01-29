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
[983. Minimum Cost For Tickets][108]

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
[70. Climbing Stairs - Easy][200]\, [Solution][201]\
[62. Unique Paths - Medium][202]\, [Solution][203]\
[1155. Number of Dice Rolls With Target Sum][204]


### Merging Intervals

### DP on Strings

### Decision Making


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

[//]: <Pattern_reference>
[1000]: https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns 
[1001]: https://leetcode.com/discuss/general-discussion/491522/dynamic-programming-questions-thread
