/*
* Name: Shayla Grymaloski
* ID: V00884262
* Date: Feb. 21, 2018
* Filename: StringStack.java
* Details: \CSC115\ Assignment 2
*/



public class StringStack{


   private Node top;
   public StringStack(){
   top = null;
   
   }
   
   
   
/*
 * 
 * checks to see if the stack is empty
 * returns bool value
 * 
*/
 
   public boolean isEmpty(){
   
      if(top == null){
      
         return true;
      }
      
      return false;
   
   }
   
 /*
 * 
 * 
 * returns the top of the stack 
 * 
*/  

   public String peek(){
   
      if (!isEmpty()){
         return top.item;
      
      }
      else{
          
         throw new StackException("error on peek");
       
      
      }
   }
   
  /*
 * 
 * 
 * removes the top of the stack
 *returns that value
 *
*/  
   
   

   public String pop(){
   
   
      if(!isEmpty()){
      
         Node temp = top;
         top = top.next;
         return temp.item;
         
      
      
      }else{
   
        throw new StackException("error on pop");
        
      }
   }
   
 
 /*
 * 
 * 
 * emptys the stack
 *
 *
*/  
   public void popAll(){
   
     top = null;
      
      }
   
   
   
   
 /*
 * 
 * 
 * pushes onto the stack
 *
 *
*/  
   public void push(String newItem){
   
      top = new Node(newItem, top);
   }

}