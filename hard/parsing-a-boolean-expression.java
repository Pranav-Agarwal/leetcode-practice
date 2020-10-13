class Solution {
    
    private char logic(char a,char b,char op){
        char ans = '0';
        if(op=='!'){
            if(a=='t') ans='f';
            if(a=='f') ans='t';
        }
        if(op=='&'){
            if(a=='t' && b=='t') ans='t';
            else ans='f';
        }
        if(op=='|'){
            if(a=='t' || b=='t') ans='t';
            else ans='f';
        }
        return ans;
    }
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Character> nums = new Stack<>();
        //boolean ans = false;
        for(int i=0;i<expression.length();i++){
            char t = expression.charAt(i);
            if(t=='f' || t=='t' || t=='(') nums.push(t);
            if(t=='!' || t=='&' || t=='|') ops.push(t);
            if(t==')'){
                //System.out.println(ops.peek());
                //System.out.println(nums.peek());
                char op = ops.pop();
                if(op=='!'){
                    char num = nums.pop();
                    while(num!='('){
                        System.out.println(num);
                        char ans = logic(num,num,'!');
                        num = nums.pop();
                        nums.push(ans);
                    }  
                }
                if(op=='|'){
                    char num = nums.pop();
                    while(num!='('){
                        char ans = '0';
                        if(nums.peek()!='(') ans = logic(num,nums.pop(),'|');
                        else ans = logic(num,num,'|');
                        num = nums.pop();
                        nums.push(ans);
                    }                
                }
                if(op=='&'){
                    char num = nums.pop();
                    while(num!='('){
                        char ans = '0';
                        if(nums.peek()!='(') ans = logic(num,nums.pop(),'&');
                        else ans = logic(num,num,'&');
                        num = nums.pop();
                        nums.push(ans);
                    }
                    
                }
            }
        }
        char ans = nums.pop();
        if(ans=='f') return false;
        else return true;
    }
}