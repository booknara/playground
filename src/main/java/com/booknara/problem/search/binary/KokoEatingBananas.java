package com.booknara.problem.search.binary;

/**
 * 875. Koko Eating Bananas (Medium)
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    // T:O(n*logw), n: the number of piles, w: the max number of piles, S:O(1)
    public int minEatingSpeed(int[] piles, int H) {
        // input check (integers are all posttive number)
        if (piles == null) return 0;

        // case #2: the number of piles (n <= H) impossible
        if (piles.length > H) return 0; // impossible
        int res = 0;
        // case #1: the number of piles (n == H) find the biggest value
        if (piles.length == H) {
            for (int p: piles) {
                res = Math.max(res, p);
            }

            return res;
        }

        // case #3: the number of piles (n > H) l = 1, biggest = r, binary search
        int min = 1, max = 0;
        for (int p: piles) {
            max = Math.max(max, p);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (isEatable(piles, mid, H)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }

    public boolean isEatable(int[] piles, int n, int h) {
        int count = 0;
        for (int p: piles) {
            count += p / n;
            if (p % n != 0) {
                count++;
            }
        }

        return count <= h;
    }
}

/**
 N - banaba
 1 ~ N
 piles[i] = the banana number of i-th piles

 H - hours
 K banana per hour
 1, 2, 3, ... H: pick one-th pile and eat K bananas (can be less than K if not enough)

 [3,6,7,11], H = 8, K = 4
 3 -> 0(1)
 6 -> 2(2) -> 0(3)
 7 -> 3(4) -> 0(5)
 11 -> 7(6) -> 3(7) -> 0(8)

 Using binary tree
 case #1: the number of piles (n == H) find the biggest value
 case #2: the number of piles (n <= H) impossible
 case #3: the number of piles (n > H) smallest = l, biggest = r, binary search
 while (l < r) {
 if mid is possiable -> decrease, r = mid
 else l = mid + 1
 }

 return r;
 */