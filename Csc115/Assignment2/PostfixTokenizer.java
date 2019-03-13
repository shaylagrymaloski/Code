//import java.util.Iterator;

/*
* Name: Shayla Grymaloski
* ID: V00884262
* Date: Feb. 21, 2018
* Filename: PostfixTokenizer.java
* Details: \CSC115\ Assignment 2
*/



public class PostfixTokenizer extends Object implements Tokenizer{

   StringStack aStack = new StringStack();
   int current = 0;
   int count = 0;
   
   Operator op = new Operator();
   String[] array = new String[100];
   
   
   
 /*
   * Parameters: infixTokens - A tokenizer of infix-ordered operands, which may be any string, operators and parens.
   *Throws: IllegalExpressionException - if the parens are unbalanced. 
   *Does not check that the operands are valid variable names or numbers.
   *
   *
*/
   public PostfixTokenizer(OperatorTokenizer infixTokens)throws IllegalExpressionException{
    //iterates through the tokens
      while(infixTokens.hasNext()){
     
         String tok = infixTokens.next();
         
         
 //  System.out.println("This is the token num     "+tok);
     
     
   
         if(op.isOperator(tok)==false && !tok.equals("(")&& !tok.equals(")")){
           
            array[count] = tok;
          
            count++;
        
      
        } else if(tok.equals("(")){
        
        
      
               int countOfOperators = 0;
               while(!tok.equals(")")){
               
                  tok = infixTokens.next();
                  
                  if(op.isOperator(tok)){
                  
                     countOfOperators++;
                     aStack.push(tok);
                  
                  
                  
                  }else if(tok.equals(")")){
                  
                  
                     // don't do anything
                  
                  }else{
                  
                     array[count] = tok;
                      count++;
                  }// end of while loop
                  
                  
             
              
                  
               }
               array[count] = aStack.pop();
               count++;
            
            
      
        }else if(op.isOperator(tok)){
            
           pushOnStack(tok);
            
        }
        
           
       }//end of while loop
       
       while(!aStack.isEmpty()){
         
 //   System.out.println("Value of count when stack is not empty " +count);
               String popVal = aStack.pop();
               
         
               if(!popVal.equals("(")&&!popVal.equals(")")){
               
                  array[count] =popVal;
                  count++;
  //             System.out.println("array from stack " +popVal);  
               }
               
                   
             
       
       }
      
   
   }
   
   
   
   
 /*
 * Takes a string and pushed it onto the stack
 * 
 * 
 * 
*/
   
   public void pushOnStack(String tok){
   
   
      if(!aStack.isEmpty()){
          int compare = op.comparePrecedence(tok, aStack.peek());
          
          // System.out.println("comparing tok and peak     " + tok +"  "+aStack.peek());
           
           if (compare>0){
           
          // System.out.println("compar > 0    " + tok);
              
           array[count] =aStack.pop();
                count++;
                 
         
             }else if(compare<0){
         
          // System.out.println("compar < 0    " + tok);
    
            }else{
              
                array[count] =aStack.pop();
                count++;
                
         //  System.out.println("compar = 0    " + tok);
                
      
             }
      }
      
         aStack.push(tok);
      
   
   }
   
   
   
   /*
 *Checks to see if the array has a next 
  * returns true of there is another element
 * returns false if not
 *
*/
   public boolean hasNext(){
   
       if (next() == null){
         current --;
         return false;
       
       }
       current--;
       return true;
   }
   
/*
 * Finds the next element in the array
 * 
 * 
 * 
*/
   
   
   public String next(){
   
     int index = count;
     
     
    
      String element = array[current];
     
     
          current ++;
      
       return element;
   
   }
   
/*
 *finds the number of tokens in the array
 *returns that value
*/

   public int numTokens(){

      return count;

   }
   
   
/*
 * removes the top of the stack
 *
*/
   public void remove(){
      
      aStack.pop();  
   
   }
   
/*
 *  sets the array back to null
 *
*/
   public void reset(){
      
      
   for(int i = 0; i<numTokens(); i++){
   
      array[i] = null;
   
   }
  
   
   }


/*
 *Converts to a string
 *
*/
   public String toString(){
   

      StringBuffer sb = new StringBuffer(numTokens());
	   sb.append("as infix Tokens: "+numTokens());
	   for (int i=0; i<numTokens(); i++) {
	   //this will invoke the String’s toString method!!
	   sb.append("\n\t"+array[i]);
      }
       return sb.toString();
      
      
      }
      
   
   
   

   public static void main(String args[]){
      
  
       String asString = "3*(4+2)-4*(-6--3)";
     // String asString = "3*(4+2)";
      //String asString = "4+(3+2)-(3+4)";
       
       OperatorTokenizer asInfix = new OperatorTokenizer(asString);
       PostfixTokenizer postfix = new PostfixTokenizer(asInfix);
       System.out.print("as infix tokens: ");
       System.out.println(asInfix);
       System.out.println("By idividual postfix tokens:");
       while(postfix.hasNext()) {
              
            System.out.println("next token: "+ postfix.next());
               
               
      }
   
   }

}