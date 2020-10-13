class Solution {
    public String frequencySort(String s) {
        int[] helper = new int[100];
        for(int i=0;i<s.length();i++){
            helper[s.charAt(i)-32]++;
        }
        String ans="";
        System.out.println(Arrays.toString(helper));
        for(int i=0;i<100;i++){
            int max=0;
            int ind = -1;
            for (int j=0;j<100;j++){
                if(helper[j]>max){
                    ind = j;
                    max = helper[j];
                }      
            }         
            if(max==0) break;
            //System.out.println(helperind]+32);
            for(int k=0;k<max;k++) ans = ans+(char)(ind+32);
            helper[ind]=0;
        }
        return ans;
    }
}