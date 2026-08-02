class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // There's a bigger element to the right,
                // so a peak must exist in (mid, right]
                left = mid + 1;
            } else {
                // nums[mid] >= nums[mid + 1],
                // so a peak must exist in [left, mid]
                right = mid;
            }
        }
        
        return left; // left == right, pointing at a peak
    }
}