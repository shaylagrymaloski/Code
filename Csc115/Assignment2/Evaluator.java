
/*
* Name: Shayla Grymaloski
* ID: V00884262
* Date: Feb. 21, 2018
* Filename: Evaluator.java
* Details: \CSC115\ Assignment 2
*/


public class Evaluator{

    int current = 0;
      
    int count = 0;

   public Evaluator(){
   
   
   
      
   
   }
   
   /*
 * Evaluates the postfix expression
 * throws IllegalExpressionException
 * 
 * 
*/
   
   
   static double evaluate(String expression) throws IllegalExpressionException {
      
      OperatorTokenizer asInfix = new OperatorTokenizer(expression);
       PostfixTokenizer postfix = new PostfixTokenizer(asInfix);
      
      
       Operator op = new Operator();
      
       StringStack aStack = new StringStack();
      char[] temp = expression.toCharArray();
      
      
      
       while(postfix.hasNext()){
       
        String tok = postfix.next();
     
         if(op.isOperator(tok)==false){
           
         //  Node temp = new Node(tok);
           aStack.push(tok);
          
       
      
        } else{
        
            String one = aStack.pop();
            String two = aStack.pop();
          
          
          double number1 = Double.valueOf(one);
          double number2 = Double.valueOf(two);
          
            
            double result = op.evaluate(number2, number1, tok);
            
          //  System.out.println("This is the result   " +result);
            
            String resultAsStr = String.valueOf(result);
               aStack.push(resultAsStr); 
         }
               
              
            
      
        
        
           

       
       
       
       }//end of while loop
     //      
       double result = Double.valueOf(aStack.peek());
      return result;
     }
     
     
      
      
   /*
 * main method
 * thows IllegalExpressionException
 * 
 * 
*/   
       
   public static void main(String args[]) throws IllegalExpressionException {
   
   
   
       String good = "3*(4+2)-4*(-6--3)";
       String badParens = "(4))";
       String toomanyOperands = "(4+6)12";
       String notEnough = "3--6+2*";
       System.out.println(good);
       System.out.println(evaluate(good));
       System.out.println(badParens);
       
      try{
               evaluate(badParens);
               
       } catch (Exception iee) {
     
               System.out.println(iee.getMessage());
       }
       System.out.println(toomanyOperands);
       try {
               evaluate(toomanyOperands);
       } catch (Exception iee) {
               System.out.println(iee.getMessage());

     }
       System.out.println(notEnough);
       try {
               evaluate(notEnough);
       } catch (Exception iee) {
               System.out.println(iee.getMessage());
}
   
   
   }





}