class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> ans = new ArrayList<String>();
        String[] t = text.split(" ");
        for(int i=0;i<t.length-2;i++){
            if(t[i].equals(first) && t[i+1].equals(second)) ans.add(t[i+2]);
        }
        String[] a = new String[ans.size()];
        return ans.toArray(a);
    }
}