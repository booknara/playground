package com.booknara.problem.hash;

/**
 * 2671. Frequency Tracker (Medium)
 * https://leetcode.com/problems/frequency-tracker
 */
class FrequencyTracker {
  Map<Integer, Integer> map;
  int[] freq;

  public FrequencyTracker() {
    map = new HashMap<>();
    freq = new int[100_000 + 1];
  }

  // T:O(1)
  public void add(int number) {
    int count = map.getOrDefault(number, 0);
    map.put(number, count + 1);
    if (count != 0) {
      freq[count]--;
    }
    freq[count + 1]++;
  }

  // T:O(1)
  public void deleteOne(int number) {
    int count = map.getOrDefault(number, 0);
    if (count != 0) {
      map.put(number, count - 1);
      freq[count]--;
      if (count - 1 != 0) {
        freq[count - 1]++;
      }
    }
  }

  // T:O(1)
  public boolean hasFrequency(int frequency) {
    return freq[frequency] > 0;
  }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);

 ["FrequencyTracker", "add", "add", "hasFrequency"]
 [[], [3], [3], [2]]

 [3:2]
 [2:1]

 [0,1,2,3,4,5,....]
 [0,1,1,0,0,0,....]
 */
