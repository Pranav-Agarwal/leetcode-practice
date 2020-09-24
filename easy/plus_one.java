class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length==1 && digits[0]==0) return new int[] {1};
        
        int carry = 1;
        int temp = 0;
        for (int i=digits.length-1;i>=0;i--){
            temp = digits[i]+carry;
            inp =  = temp%10;
            carry = temp/10;
        }
        if(carry==1){
            int[] answer = new int[digits.length+1];
            answer[0]=1;
            for(int i=0;i<digits.length-1;i++) answer[i+1] = digits[i];
            return answer;

        }
        else return digits;
    }
}