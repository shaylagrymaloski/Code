/*
Decoding Functions:
  - places all of the int values of the file into an array
  - skips over the magic number in the file
  - goes through the array value by value
  - will add characters of a word together
  - then will take the address of the first letter and store it in the linked list
    if the word is unique

*/



#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char  magic_number_1[] = {0xBA, 0x5E, 0xBA, 0x11, 0x00};
char  magic_number_2[] = {0xBA, 0x5E, 0xBA, 0x12, 0x00};
int MAX_FILENAME_LEN = 100;

//this is the struct node that is used for the linked list
struct node {
    char *val;
    int index;
    struct node *head;
    struct node *next;

};

//this function will perform malloc and check to see if malloc returns null
void* doMalloc(size_t n){

      void *p;
      p = malloc(n);
      if (p == NULL) {
        printf("malloc failed");
        exit(1);
      }


    return p;

}



//this function will take a unique word and put it in the list
 void pushToList(struct node *head, char* val, int length) {

    char *word = (char*)doMalloc(sizeof(char)*length);

    strncpy(word, val, length);

     struct node * current = head;
     while (current->next != NULL) {

         current = current->next;

     }
       current->next = doMalloc(sizeof(struct node));
       current->next->val = &word[0];
       current->next->index = length;
       current->next->next = NULL;


}



//not needed for this assignment
int encode(FILE *input, FILE *output) {
    return 0;
}

//prints out the word char by char into the file
void printWordToFile(FILE *output, char* letters, int index){

  for(int i = 0; i< index; i++){

      fputc(*letters, output);
      letters ++;

    }

}

//removes a repeated word from the list and appends it to the end of the list
void removeAndAppend(struct node *head, int index, int sizeOfList){
      struct node *prev;
      struct node *current = head;
      struct node *temp = head;

        if(index == 0){
          //if we want to remove the first element
          if (sizeOfList == 1){

            head->head = head;
            return;
          }else{


          head->head = head->next;
          head = head->next;

        }


        }else if(index+1 == sizeOfList){

          //if we want to remove the last element
          head->head = head;
          return;

        }else{

            for(int i = 0; i< index-1; i++){
                current = current->next;

            }

            temp = current->next;
            prev = doMalloc(sizeof(current));
            prev = current;
            prev->next = prev->next->next;
            current = head;
            head->head = head;

        }

            while(current->next != NULL){
              current = current->next;

            }
            current->next = doMalloc(sizeof(temp));
            current->next = temp;
            temp->next = NULL;


  }

//gets a repeated word from the the list by using the number given by the mtf file
struct node getElement(struct node *head, int listLen, int number){

      //gets the index of the word to remove
      int index = listLen - number;

      struct node *current = head;

      if(index < 0|| index == listLen){
          while(current->next != NULL){

            current = current->next;
          }
          return *current;

      }

      //find the element in the list
      for(int i = 0; i< index; i++){
          current = current->next;

      }
      removeAndAppend(head, index, listLen);

      return *current;

}


//function used to decode the mtf file
int decode(FILE *input, FILE *output) {
  int ch;
  int magicDone = 4;
  int characterFlag = 0;

  int count = 0;
  int firstWord = 1;
  int sizeOfList = 0;
  char *word;
  int checkToSkip;
  int caseNum;
  int sizeOfFile = 1;


  int test = 0;
  int numberFlag;

  //variables for letter array
  char letters[100];
  int index = 0;

  struct node * head = NULL;
  head = doMalloc(sizeof(struct node));


  if (head == NULL) {
    return 1;
  }

//iterates through the file and counts how many characters are in the file
  while((ch = getc(input))!= EOF){
    sizeOfFile++;
  }
  //puts the file pointer back to the beginning of the file
  rewind(input);

  int array[sizeOfFile];

//puts all the contents of the file into and array of characters
  while( (ch = getc(input)) != EOF ){
      array[count] = ch;
      count++;
  }



//reads the array  charter by character
  for(int i = 0; i < count; i++) {

    char c = array[i];
    int value = array[i];
    //Skips over the magic numbers
    if(magicDone != 0){
      magicDone --;
      continue;
    }
    //skips this itteration of the loop, used for case 2 and 3 when there
    //is more than one number in front of a letter
    if(checkToSkip != 0){

        checkToSkip--;
        continue;
    }

    // if the value is a new line character
    if(value == 10){

      fputs("\n", output);
      continue;
    }


    if(array[i]== 128+121){
      //used to check for case 2
        caseNum = 2;
        checkToSkip = 1;
        numberFlag = 1;


    }else if(array[i]== 128+122){
      //checkfor case 3
        caseNum = 3;
        numberFlag = 1;
        checkToSkip = 2;

    }else if(array[i] > 128){
      //used for case 1
        caseNum = 1;
        numberFlag = 1;

    }

    //if the character flag has been activated
    if(characterFlag == 1){
      //if the next value is a character
          if(array[i+1] < 128 && array[i+1] != 10){
              letters[index] = c;
              index++;
          }else{
        //if the next value is a number or new line
              characterFlag = 0;
            //creates the head
            if(firstWord ==1){
                letters[index]= c;
                index++;
                word = (char*)doMalloc(sizeof(char)*index);
            //done ending
                strncpy(word, letters, index);
              //make the word the head of the list
                 head->val = &word[0];
                 head->index = index;
                 head->next = NULL;
                 head->head = head;
                 sizeOfList++;
                 firstWord = 0;

            //prints the word to the file
              printWordToFile(output, &letters[0], index);

            }else{
              //if the word is not the first word (therefore not the head)
              letters[index] = c;
              index++;

              printWordToFile(output, &letters[0], index);
              pushToList(head, &letters[0], index);
              sizeOfList++;

            }

                //checks to see if a space needs to be added
                if(array[i+1]!= 10){

                  fputs(" ", output);

                }

            }
          continue;

        }//end of character flag

    //if the next value is a number or new line
      if(array[i+caseNum] > 128 || array[i+caseNum] == 10){

        struct node element;

        if(caseNum == 2){
          //case 2
              element = getElement(head, sizeOfList, array[i+1]+121);

        }else if(caseNum == 3){
          //case 3
              int value = array[i+1]*256 +376;
              value = value + array[i+2];
              checkToSkip = 2;


              element = getElement(head, sizeOfList, value);
        }else if(caseNum == 1){
          //case 1
            element = getElement(head, sizeOfList, array[i]-128);

        }
          //makes sure that the head is the actul head of the list
          head = head->head;
          printWordToFile(output, element.val, element.index);


          if(array[i+caseNum]!= 10){

            fputs(" ", output);

          }

          continue;


      }else{
          //if the next character is a letter
          characterFlag = 1;
          index = 0;

        }


  }//end of for
//calls a function to free the list
  free(head);
  free(word);

    return 0;
}
