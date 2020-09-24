class Solution {
    
    public String plusN(String str,int offset,int n) {
        //System.out.println(str+" "+offset+" "+n);
        int carry = n;
        int temp = 0;
        int flag = 0;
        for (int i=str.length()-offset-1;i>=0 && i<str.length();i--){
            flag=1;
            temp = str.charAt(i)-48+carry;
            str = str.substring(0, i) + Integer.toString(temp%10) + str.substring(i + 1);
            carry = temp/10;
            if(carry==0) break;
        }
        if(carry!=0 || flag==0){
            str = Integer.toString(carry)+str;
        }
        return str;
    }
    
    public String multiply(String num1, String num2) {
        String ans= "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int n1 = 0;
        int n2 = 0;
        for(int i=l1-1;i>=0;i--){
            for(int j=l2-1;j>=0;j--){
                //System.out.println(i+" "+l1+" "+j+" "+l2);
                n1 = (num1.charAt(i)-48)*(num2.charAt(j)-48);
                n2 = n1%10;
                n1 = n1/10;
                ans = plusN(ans,l1+l2-i-j-2,n2);
                ans = plusN(ans,l1+l2-i-j-1,n1);
            }
        }
        while(ans.charAt(0)=='0' && ans.length()>1) ans = ans.substring(1);
        return ans;
    }
}