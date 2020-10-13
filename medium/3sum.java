import java.util.List;

class Solution {
    
    private ArrayList<Integer> srt (int a,int b,int c){
        int min,med,max;
        if( a > b ){
         if( a > c ){
          max = a;
          if( b > c ){
           med = b;
           min = c;
          }else{
           med = c;
           min = b;
          }
         }else{
          med = a;
          max = c;
          min = b;
         }
        }else{
         if( b > c ){
          max = b;
          if( a > c ){
           med = a;
           min = c;
          }else{
           med = c;
           min = a;
          }
         }else{
          med = b;
          max = c;
          min = a;
         }
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(min);
        temp.add(med);
        temp.add(max);
        return temp;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length<3) return new ArrayList<List<Integer>>();
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        HashMap<Integer,Integer> ints = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            ints.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                //System.out.println(i+" "+j);
                int t = -1*(nums[i]+nums[j]);
                Integer k = ints.get(t);
                if(k!=null && k!=i && k!=j){
                    ans.add(srt(nums[i],nums[j],t));
                }
            }   
        }  
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        for(List<Integer> sm : ans){
            a.add(sm);
        }
        return a;
    }
}