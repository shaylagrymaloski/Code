import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.*;
import java.util.Scanner.*;

public class Solution {
 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */  
        Scanner scan = new Scanner(System.in);
       
        String equation = scan.nextLine();
        int n = 0;
    
    
        String[] splitString = equation.split("=");
        
        
        StringBuilder stringValue = new StringBuilder(splitString[0]);
        stringValue.append("=");
        
        
        
        char[] characters = stringValue.toString().toCharArray();
        
        BigInteger rightResult  = new BigInteger(splitString[1]);
        BigInteger leftResult = new BigInteger("0");
        BigInteger  two = new BigInteger("2");
        BigInteger x = new BigInteger("0");
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        
        
        //sets the bounds of the x value
        BigInteger topRange = new BigInteger(splitString[1]);
        BigInteger bottomRange = new BigInteger("0");
        BigInteger buffer = new BigInteger("0");
        
       
        //divides the value of the answer
        x = rightResult.divide(two);
      
       
        
        //while loop calculates the 
        boolean ranOne = false;
        
        for(;;){
          //  System.out.println("left side = " +leftResult.toString());
          //   System.out.println("right side = " +rightResult.toString());
          //   System.out.println("topRange = "+topRange.toString());
          //   System.out.println("bottomRange = "+bottomRange.toString());
            
          //   System.out.println("x = " +x.toString());
           
            //calculate the left side with x value
            leftResult = zero;
            
            for(int i = 0; i < characters.length; i++){
               
           //    System.out.println("running (top)");
                //if the charaters is a '+'
                if(characters[i] == '+'){
                    
                }else if (characters[i] == 'x'){
                    //if next character is ^
                  // System.out.println("running with x");
                   
                     if(characters[i+1]== '^'){
                        BigInteger temp = new BigInteger("1");
                        
                        int val = Character.getNumericValue(characters[i+2]);
                        //multiplies n by the power value
                        for(int j = 0; j< val ; j++){
                              temp = temp.multiply(x);
                        
                        }
                    
                        leftResult = leftResult.add(temp);
                        i = i + 3;
                    }else{
                        i++;
                        leftResult = leftResult.add(x);
                        
                    }
               
                }else{
                   // System.out.println("constants");
                    //only runs if the code has run once to move any constants to the other side
                    if (ranOne == false){
                       //System.out.println("subtracting");
                     //   System.out.println("subtracts the constant");
                     
                        //subtract from right 
                        BigInteger temp;
                         
                        String tempString = Character.toString(characters[i]);
                        StringBuilder stringVal = new StringBuilder(tempString);
                        i++;
                      
                        while(characters[i] != '+'){
                           
                            if(characters[i]== '='){
                                break;
                            }
                            
                          //  System.out.printf(" "+characters[i]+ " ");
                            tempString = Character.toString(characters[i]);
                            stringVal.append(tempString);
                        
                            i++;
                        }
                         //   System.out.println(tempString);
                            temp = new BigInteger(stringVal.toString());
                            rightResult = rightResult.subtract(temp);
                    
                            topRange = rightResult;
                    }
                }
                
        
            }
            ranOne= true;
            
         
     
            //if the right side equals the right side so x value is correct
            if(rightResult.equals(leftResult) == true){
                break;
            }
            
            
            
             //if the left result when using x is too high  
            if(leftResult.compareTo(rightResult)== 1){
                
               
                topRange = x;
                buffer = x.subtract(bottomRange);
                buffer = buffer.divide(two);
        
                x = x.subtract(buffer);
         
            }else{
                
               //result is too low 
                buffer = topRange.subtract(x);
                buffer = buffer.divide(two);
                bottomRange = x;
                //if the left result is too low
            
                x = x.add(buffer);

            }
             
               
        }
        System.out.println(x.toString());
    
     //   System.out.println(result);
    }
}