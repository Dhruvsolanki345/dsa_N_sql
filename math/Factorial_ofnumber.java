// just a Java program to get factorial of a number by sam-tripathi
 class Factorial_ofnumber { 
     public static void main(String args[]) { 
         int i, fact = 1; 
         int number = 5;// predefined value 
         for (i = 1; i <= number; i++) { 
             fact = fact * i; 
         } 
         System.out.println("Factorial of " + number + " is: " + fact); 
     } 
 }
