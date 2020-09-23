class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        ArrayList<Integer> dry_days = new ArrayList<Integer>();
        int[] impossible = new int[0];
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        for(int i=0;i<rains.length;i++){
            //System.out.println(dry_days);
            //System.out.println(rains[i]);
            if(rains[i]>0){
                
                ans[i]=-1;
                if(hmap.get(rains[i])==null){
                    hmap.put(rains[i],i);
                    continue;
                }
                else if(dry_days.size()==0) return impossible;
                else{
                    int flag=0;
                    for(int j=0;j<dry_days.size();j++){
                        if(dry_days.get(j)>hmap.get(rains[i])){
                            ans[dry_days.get(j)] = rains[i];
                            hmap.put(rains[i],i);
                            dry_days.remove(j);
                            flag=1;
                            break;
                        }    
                    }
                    if(flag==0) return impossible;
                }

            }
            else if(rains[i]==0){
                dry_days.add(i);
            }
        }
        return ans;
    }
}