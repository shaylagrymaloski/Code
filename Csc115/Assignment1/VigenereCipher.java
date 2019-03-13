/*
* Name: Shayla Grymaloski
* ID: V00884262
* Date: Jan. 26,2017
* Filename: VigenereCipher.java
* Details: \CSC 115\ Assignment 1
*/


public class VigenereCipher implements Cipher{
   //lab notes:
   private String key;
   
   
      //add numbers then take %26
   
   
   public VigenereCipher(String key){
   
      // this.key = key;
       setKey(key);
   }
   
   public String decrypt(String ciphertext){ 
       int [] intArray = new int[ciphertext.length()];
       int [] intKey = new int[ciphertext.length()];

  
       String ctext = ciphertext;
       intArray = stringToIntArray(ctext);
       intKey = stringToIntArray(key);
     
       for(int i=0; i < ctext.length(); i++){
             intArray[i] = (intArray[i] - intKey[i%key.length()]); 
             
         
       }
         ctext =  intArrayToString(intArray);
     
      return ctext;
        
   }
   
   

   private void dumpArray(int[] array, String text){


    System.out.println(text);

      for(int i = 0; i< array.length; i++){
      
         if(i!=0) {
             System.out.print(", ");
         }
       
          System.out.print(array[i]);
         
      }  
       
   }
   
   public String encrypt(String plaintext){
      
      int [] intArray = new int[plaintext.length()];
      int [] intKey = new int[plaintext.length()];
      
      
      String ptext = plaintext;
      intArray = stringToIntArray(ptext);
      intKey = stringToIntArray(key);
      
    
      for(int i=0; i < ptext.length(); i++){
            intArray[i] = (intArray[i] + intKey[i%key.length()])%26; 
         
      }
     
        ptext =  intArrayToString(intArray);
      
      return ptext;
   }
   
  
   private String intArrayToString(int[] encodedText){
     
  
      int[] intArray = new int[encodedText.length];
      intArray = encodedText;
      char[] charArray = new char[encodedText.length];
      
      
      
      for (int i = 0; i < encodedText.length; i++) {
          charArray[i] = (char)(intArray[i]+97);
      //    System.out.println(charArray[i]);
      }
      
       
      
      
      String result = String.valueOf(charArray);
      
      return result;  
   
   }
   
   public void setKey(String key){
   
      this.key = key;
      
   }
   private int[] stringToIntArray(String text){
      
      char[] charArray = new char[text.length()];
      charArray = text.toCharArray();
      int[] result = new int[text.length()];
      
      
      for (int i = 0; i < text.length(); i++) {
          result[i] = charArray[i]-97;
          
          
      }
      
         return result;  
           
      }
      
   

   public static void main(String[] args){
   
   
        VigenereCipher vc = new VigenereCipher("dd");
        System.out.println("converting 'blog' to an array of ints");
     
        
        int[] toNums = vc.stringToIntArray("blog");
        vc.dumpArray(toNums,"result: " );
       
    
  
   //using terminal...    
   //diff - w   then two file names
     
   }
   
   }
   