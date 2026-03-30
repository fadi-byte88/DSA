class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        int max = 0, countMax = 0;

        // find max frequency
        for (int f : freq) {
            if (f > max) {
                max = f;
                countMax = 1;
            } else if (f == max) {
                countMax++;
            }
        }

        int partCount = max - 1;
        int partLength = n - (countMax - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * countMax;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
