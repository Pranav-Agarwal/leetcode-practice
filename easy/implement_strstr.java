class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int ans=-1;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int flag=1;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(j+i)!=needle.charAt(j)){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                ans = i;
                break;
            }
        }
        return ans;
    }
}