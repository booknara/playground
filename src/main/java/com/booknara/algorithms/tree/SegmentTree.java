package com.booknara.algorithms.tree;

/**
 * Sum of given range
 */
public class SegmentTree {
    int[] sg;
    public static void main(String[] args) {
//        solution1(new int[] {2, 3, -1, 5, -2, 4, 8, 10});
//        solution2(new int[] {2, 3, -1, 5, -2, 4, 8, 10});

        int[] nums = new int[] {2, 3, -1, 5, -2, 4, 8, 10};
        SegmentTree segmentTree = new SegmentTree(nums);

        System.out.println(segmentTree.getSum(0, nums.length - 1, 1, 5, 0));    // 9
        // nums[1] : 3 -> 4
        int newValue = 4;
        int diff = newValue - nums[1];
        nums[1] += diff;

        for (int i: segmentTree.sg) {
            System.out.print(i + ",");
        }
        System.out.println();
        segmentTree.updateValue(0, nums.length - 1, 1, diff, 0);
        for (int i: segmentTree.sg) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println(segmentTree.getSum(0, nums.length - 1, 1, 5, 0));    // 10
    }

    /**
     * sum T:O(logn)
     * update T:O(logn)
     * S:O(n) -> 2*n - 1, 2*2^(ceiling(logn) - 1
     */
    public SegmentTree(int[] nums) {
        int n = nums.length;
        // 2 * 2^ceiling(logs*n) - 1
        int sgHeight = (int) Math.ceil(Math.log(n) / Math.log(2));
        int sgSize = 2 * (int ) Math.pow(2, sgHeight) - 1;

        sg = new int[sgSize];
        buildSegmentTree(nums, 0, n - 1, 0);
    }

    /**
     *
     * @param ss start index of segment tree range
     * @param se end index of segment tree range
     * @param qs start index of query range
     * @param qe end index of query range
     * @param c current index
     * @return sum
     */
    public int getSum(int ss, int se, int qs, int qe, int c) {
        // case #1 segment range is included by query range
        if (qs <= ss && se <= qe) {
            return sg[c];
        }
        // case #2 segment range is not totally included by query range
        if (se < qs || ss > qe) {
            return 0;
        }
        // case #3 segment range is partly included by query range
        int mid = ss + (se - ss) / 2;
        int left = getSum(ss, mid, qs, qe, 2 * c + 1);
        int right = getSum(mid + 1, se, qs, qe, 2 * c + 2);

        return left + right;
    }

    /**
     *
     * @param ss start index of segment tree range
     * @param se end index of segment tree range
     * @param i updated index
     * @param diff different
     * @param c current index
     */
    public void updateValue(int ss, int se, int i, int diff, int c) {
        // base case
        if (i < ss || i > se) return;

        sg[c] += diff;

        // only range segment not leaf node
        if (ss != se) {
            int mid = ss + (se - ss) / 2;
            updateValue(ss, mid, i, diff, 2 * c + 1);   // left children
            updateValue(mid + 1, se, i, diff, 2 * c + 2);   // right children
        }
    }

    public int buildSegmentTree(int[] nums, int s, int e, int c) {
        // base case
        if (s == e) {
            sg[c] = nums[s];
            return sg[c];
        }

        int mid = s + (e - s) / 2;
        int left = buildSegmentTree(nums, s, mid, 2 * c + 1);
        int right = buildSegmentTree(nums, mid + 1, e, 2 * c + 2);

        sg[c] = left + right;
        return sg[c];
    }
    /**
     * The simplest solution : To run a loop from l to r and calculate the sum of elements in the given range.
     * sum T:O(n)
     * update T:O(1)
     * S:O(1)
     */
    public static void solution1(int[] nums) {
        // get sum[1,5]
        int l = 1, r = 5;
        int sum = 0;
        for (int i = l; i < r + 1; i++) {
            sum += nums[i];
        }
        System.out.println(sum);    // 9

        sum = 0;
        nums[1] = 4;    // 3 -> 4
        for (int i = l; i < r + 1; i++) {
            sum += nums[i];
        }
        System.out.println(sum);    // 10
    }

    /**
     * Another solution(Sub-array sum) : to create another array and store sum from start to i at the ith index in this array.
     * sum T:O(1)
     * update T:O(n)
     * S:O(n)
     */
    public static void solution2(int[] nums) {
        int[] subarraySum = new int[nums.length];
        subarraySum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subarraySum[i] = subarraySum[i - 1] + nums[i];
        }
        // get sum[1,5]
        int l = 1, r = 5;
        System.out.println(subarraySum[r] - subarraySum[l - 1]);    // 9

        int idx = 1;
        nums[idx] = 4;    // 3 -> 4
        for (int i = idx; i < nums.length; i++) {
            subarraySum[i] = subarraySum[i - 1] + nums[i];
        }
        System.out.println(subarraySum[r] - subarraySum[l - 1]);    // 10
    }
}
