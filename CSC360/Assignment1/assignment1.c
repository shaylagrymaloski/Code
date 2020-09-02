#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void printString(char *string){
    while(*string!='\0')
        printf("%c",*string++);
    printf("\n");
}

char * currentDirectory(){
    char * dir;
    dir = (char*) malloc(257);
    getcwd(dir, 257);
    return dir;
}

void changeCurrentDirectory(char * dir){
    char * currDir = currentDirectory();
    strcat(currDir, "/");
    strcat(currDir, dir );
    if (chdir(currDir)){
        printf("could not find directory path");
    }
    free(currDir);
}

void mvUpDir(){
    char * currDir = currentDirectory();
    int len = strlen(currDir);
    int count = 0;
    char result[len];
    strncpy(result, currDir, len);
    free(currDir);

    for(int i = len-1; i > 0; i--){
        count ++;
        if(result[i] == '/'){
            result[i] = '\0';
            break;
        }
    }

    if (chdir(result)){
        printf("could not find directory path");
    }
}

void lsCommand(char *cmd){
    int pid = fork();
    if (pid < 0){
        printf("fork failed");
    }else if (pid >0){
    //parent
        wait(NULL);
    }else{
    //child
        char *argv[3];
        argv[0] = "ls";
        argv[1] = "-la";
        argv[2] = NULL;
        execvp(cmd, argv);
    }
}

int main() {
   char * curr;
   curr = currentDirectory();
   printString(currentDirectory());
   mvUpDir();
   printString(currentDirectory());
   changeCurrentDirectory("CSC360");
   printString(currentDirectory());
   lsCommand("ls");
   free(curr);
   return 0;
}