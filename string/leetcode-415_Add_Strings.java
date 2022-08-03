// https://leetcode.com/problems/add-strings/
import java.util.*;

class Solution {
    public String addStrings(String num1, String num2) {
        int sum = 0, carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        
        while(i >= 0 || j >= 0) {
            int cur1 = (i >= 0) ? toDecimal(num1.charAt(i--)) : 0;
            int cur2 = (j >= 0) ? toDecimal(num2.charAt(j--)) : 0;
            sum = cur1 + cur2 + carry;
            
            carry = sum > 9 ? 1 : 0;
            res.append(sum % 10);
        }
        
        if(carry == 1) res.append(carry);
        
        return res.reverse().toString();
    }
    
    private int toDecimal(char ch) {
        return ch - '0';
    }
}
