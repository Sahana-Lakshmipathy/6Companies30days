import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];

        int left = (n - 1) / 2; // End of the smaller half
        int right = n - 1; // End of the larger half
        for (int i = 0; i < n; i++) {
            result[i] = (i % 2 == 0) ? nums[left--] : nums[right--];
        }

        System.arraycopy(result, 0, nums, 0, n);
    }
}
