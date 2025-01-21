class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);  // Sort children's greeds in ascending order
        Arrays.sort(s);  // Sort cookie sizes in ascending order

        int i = 0, j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {  // If child's greed is less than or equal to cookie size
                count++;
                i++;  // Move to the next child
            }
            j++;  // Move to the next cookie (regardless of assignment)
        }

        return count;
    }
}
