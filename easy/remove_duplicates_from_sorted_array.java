class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int ans = 1;
        int first_slot = 1;
        int cur = nums[0];
        for (int x:nums){
            if(cur!=x){
                ans++;
                cur = x;
                nums[first_slot]=cur;
                first_slot++;
            }
        }
        return ans;
    }
}