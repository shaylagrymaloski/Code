#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char  magic_number_1[] = {0xBA, 0x5E, 0xBA, 0x11, 0x00};
char  magic_number_2[] = {0xBA, 0x5E, 0xBA, 0x12, 0x00};
int MAX_FILENAME_LEN = 100;


struct node {
    char *val;
    int index;
    struct node *head;
    struct node *next;

};



 void pushToList(struct node *head, char* val, int length) {
  // printf("adding %c to list\n", *val);
    char *word = (char*)malloc(sizeof(char)*length);

    strncpy(word, val, length);

     struct node * current = head;
     while (current->next != NULL) {

         current = current->next;

     }

       current->next = malloc(sizeof(struct node));
       current->next->val = &word[0];
       current->next->index = length;
       current->next->next = NULL;


}
void printWord(char* letters, int index){
  printf("in print word\n");
  for(int i = 0; i< index; i++){
     printf("%c ", *letters);
      letters ++;


    }
    printf("\n");

}

void print_list(struct node *head) {
    struct node * current = head;

  printf("printing the list\n");
    while (current != NULL) {

        printWord(current->val, current->index);

        current = current->next;
    }

}

int encode(FILE *input, FILE *output) {
    return 0;
}


void printWordToFile(FILE *output, char* letters, int index){
  printWord(letters,index);

  for(int i = 0; i< index; i++){

      fputc(*letters, output);
      letters ++;

    }

}
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
            prev = malloc(sizeof(current));
            prev = current;
            prev->next = prev->next->next;
            current = head;
            head->head = head;

        }

            while(current->next != NULL){
              current = current->next;

            }
            current->next = malloc(sizeof(temp));
            current->next = temp;
            temp->next = NULL;


  }

struct node getElement(struct node *head, int listLen, int number){


  //    printf("getting element with this list used\n");
      print_list(head);

      //gets the index
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
//      printf("val that was removed %c\n", *current->val);
      return *current;

}



int decode(FILE *input, FILE *output) {
  int ch;
  int magicDone = 4;
  int characterFlag = 0;
  int array[7000];
  int count = 0;
  int firstWord = 1;
  int sizeOfList = 0;
  char *word;
  int checkToSkip;
  int caseNum;


int test = 0;
  int numberFlag;

  //variables for letter array
  char letters[100];
  int index = 0;

  struct node * head = NULL;
  head = malloc(sizeof(struct node));


  if (head == NULL) {
    return 1;
  }


//puts all the contents of the file into and array of characters
  while( (ch = getc(input)) != EOF ){
      array[count] = ch;
      count++;
  }

  // if(test == 0){
  //
  //   return 0;
  // }


//reads the file ASCII charter by character
  for(int i = 0; i < count; i++) {

  //  printf("size of list = %d\n", sizeOfList);
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
        printf("CASE 2\n");
        caseNum = 2;
        checkToSkip = 1;
        numberFlag = 1;

    }else if(array[i]== 128+122){
        printf("CASE 3\n");
        caseNum = 3;
        numberFlag = 1;
        checkToSkip = 2;

    }else if(array[i] > 128){
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
                word = (char*)malloc(sizeof(char)*index);
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

              letters[index] = c;
              index++;

              printWordToFile(output, &letters[0], index);
              pushToList(head, &letters[0], index);
              sizeOfList++;

            }

                if(array[i+1]!= 10){

                  fputs(" ", output);

                }
            //index = 0;
            }
          continue;

        }//end of character flag

        // if(numberFlag != 1){
        //   continue;
        // }

    //if the next value is a number or new line
      if(array[i+caseNum] > 128 || array[i+caseNum] == 10){

        struct node element;
        //case 2
        if(caseNum == 2){

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

          head = head->head;
          printWordToFile(output, element.val, element.index);


          if(array[i+caseNum]!= 10){

            fputs(" ", output);

          }

          continue;


      }else{

          characterFlag = 1;
          index = 0;

        }


  }//end of for

  free(head);
  free(word);

    return 0;
}
