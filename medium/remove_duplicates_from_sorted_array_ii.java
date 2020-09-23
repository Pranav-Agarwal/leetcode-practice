class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        if(nums.length==2) return 2;
        int ans = 1;
        int first_slot = 1;
        int rep_counter=0;
        boolean moved = false;
        int cur = nums[0];
        for (int x:nums){
            if(cur!=x){
                //System.out.println(x+" "+cur+" "+first_slot);
                rep_counter=1;
                cur = x;
                nums[first_slot]=cur;
                first_slot++;
                ans++;
                moved=true;
            }
            else{
                rep_counter++;
                if(rep_counter==2){
                    ans++;
                    if(moved==true){
                        moved=false;
                        //System.out.println(x+" "+cur+" "+first_slot);
                        nums[first_slot]=cur;
                    }
                    first_slot++;
                }
            }
        }
        return ans;
    }
}