// https://leetcode.com/problems/integer-to-roman/

class Solution {
    Number[] numbers = {
        new Number(1000, "M"),
        new Number(900, "CM"),
        new Number(500, "D"),
        new Number(400, "CD"),
        new Number(100, "C"),
        new Number(90, "XC"),
        new Number(50, "L"),
        new Number(40, "XL"),
        new Number(10, "X"),
        new Number(9, "IX"),
        new Number(5, "V"),
        new Number(4, "IV"),
        new Number(1, "I"),
    };
    
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        
        for(Number number: numbers) {
            if(num == 0) break;
            
            int mul = num / number.val;
            
            if(mul > 0) roman.append(number.symbol.repeat(mul));
            num = num % number.val;            
        }
        
        return roman.toString();
    }
}

class Number {
    int val;
    String symbol;
    Number(int _val, String _symbol) {
        val = _val;
        symbol = _symbol;
    }
}
