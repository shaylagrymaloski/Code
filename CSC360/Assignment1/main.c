#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <readline/readline.h>
#include <readline/history.h>

struct Processes  
{  
    char *cmd;  
    int flag;   
    int pid;
    int paused;
};  

void printString(char *string){
    while(*string!='\0')
        printf("%c",*string++);
    
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

void ls_lCommand(char *cmd){
    int pid = fork();
    if (pid < 0){
        printf("fork failed");
    }else if (pid >0){
    //parent
        wait(NULL);
    }else{
    //child
        char *argv[4];
        argv[0] = "ls";
        argv[1] = "-l";
        argv[2] = cmd;
        argv[3] = NULL;
        execvp("ls", argv);
    }

}

void pwd(){
    char * currDir = currentDirectory();
    printString(currDir);
    printf("\n");
    free(currDir);
}

void runLs(char * param){
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
        argv[1] = param;
        argv[2] = NULL;
        execvp("ls", argv);
    }
}

int ls(char * token){

    // runs when only "ls" is entered
    if(strlen(token) == 2){
        runLs(NULL);
        return 0;
    }

    token = strtok(NULL, " ");
    if(strcmp(token, "-l") == 0){
        token = strtok(NULL, " ");
        // this may pass in NULL or a dir path
        ls_lCommand(token);
        
    }else{
        //this dir path
        runLs(token);
    }
    return 0;
}

void cd(char *token){
    token = strtok(NULL," ");
    if (strcmp(token, "..") == 0){
        mvUpDir();
    }else{
        changeCurrentDirectory(token);
    }
}

void addToProcess(struct Processes process[5], char * argv[15], int pid, char cmd[267]){
    for(int i = 0; i< 5; i++){
        
        if(process[i].flag == 0){
           // printf("\n in if statement\n");
            process[i].flag = 1;
            process[i].cmd = cmd;
            process[i].paused = 0;
            process[i].pid =  pid;
            i = 10;
        }
    }
 
}

void bg(char *token, struct Processes process[5], char orgCmd[267]){
   char *argv [15];
   int count = 0;

   printf("token: %s\n", token);

   token = strtok(NULL, " ");
   char * cmd = token;
   
    while( token != NULL ) {
      argv[count] = token;
      token = strtok(NULL, " ");
      count ++;
   }
    
   argv[count] = NULL;
    int pid = vfork();
    if (pid < 0){
        printf("fork failed");
    }else if (pid >0){
    
       addToProcess(process, argv, pid, orgCmd);  
    }else{
    //child
        execvp(cmd, argv);
        
    }
}

void bgkill(struct Processes process[5], char * token){
    int count = 0;
    token = strtok(NULL, " ");
   // printf("token %s\n ", token);
     int val = atoi(token);
    for (int i = 0; i < 5; i++){
        if(process[i].flag == 1){
            if(count == val){
                kill(process[i].pid, 1);
                process[i].flag = 0;
                process[i].paused = 0;
            }
            count++;
        }
    }
}

void bgList(struct Processes process[5]){
    int jobsCount = 0;
    for (int i = 0; i < 5; i++){
        if(process[i].flag == 1 || process[i].paused == 1){
            char run;
            if (process[i].paused == 1){
                run = 'S';
            }else{
                run = 'R';
            }
            printf("%d[%c]: %s \n",jobsCount,run, process[i].cmd);
            jobsCount++;
        }
       
    }
    printf("total background jobs: %d\n", jobsCount);
}

void checkCurrentProcess(struct Processes process[5]){
    
    for(int i = 0; i < 5; i++){
        int status;
        if(process[i].flag == 0 || process[i].paused == 1){
            continue;
        }
        int pid = process[i].pid;

        int return_pid = waitpid(pid, &status, WNOHANG);

        if (return_pid < 0){
            printf("process %d has ended ", pid);
            process[i].flag = 0;
            process[i].pid = 0;
            process[i].paused = 0;
          //  process[i].dir = NULL;  
        }
        
    }
}

void stop(struct Processes process[5], char * token){
    int count = 0;
    token = strtok(NULL, " ");
    int val = atoi(token);
    for (int i = 0; i < 5; i++){
        if(process[i].flag == 1){
            if(count == val){
                kill(process[i].pid, SIGSTOP);
                process[i].paused = 1;
                break;
            }
            count++;
        }
    }
}

void start(struct Processes process[5], char * token){
char *argv [15];
   int count = 0;
   token = strtok(NULL, " ");
   int val = atoi(token);
   for (int i = 0; i < 5; i++){
        if(process[i].flag == 1){
            if(count == val){
                kill(process[i].pid, SIGCONT);
                process[i].paused = 0;
                break;
            }
            count++;
        }
    }

}

int main ( void )
{
    struct Processes process[5]; 
    int count = 0;
    for(int i = 0; i< 5; i++){
            process[i].flag =0;
            process[i].paused = 0;
            process[i].cmd = "";
        }
    // while (1) {
    //     printf("\n");
    //     checkCurrentProcess(process);
    //     bgList(process);

    //     char *curr = currentDirectory();
    //     printString(curr);
    //     printf("> ");
    //     char cmd[267] = "bg ./loop";
    //     char orignalCmd[267];
    //     strncpy(orignalCmd, cmd, 267);
    //     printf("%s", cmd);
    //     printf("\n");
    //     char *token = strtok(cmd, " ");

    //     if (count == 1){
    //         bg(token, process, orignalCmd);
    //     }
        
    //     if (count == 2){
    //         bg(token, process, orignalCmd);
    //     }
    //      if (count == 3){
    //         bg(token, process, orignalCmd);
    //     }
     


    //     if(count == 4){
    //         printf("THIS SHOULD STOP 3\n");
    //         char otherCmd[267] = "stop 2";
    //         char *newToken = strtok(otherCmd, " ");
    //         stop(process, newToken);
    //     }
    //      if(count == 5){
    //          printf("THIS SHOULD START \n");
    //         char otherCmd[267] = "start 2";
    //         char *newToken = strtok(otherCmd, " ");
    //         start(process, newToken);
    //     }
    //     if (count == 7){
    //         printf("THIS SHOULD KILL 3");
    //        char otherCmd[267] = "bgkill 2";
    //         char *newToken = strtok(otherCmd, " ");
    //         bgkill(process, newToken);
    //     }

      
    //     sleep (1);
    //     count ++;
    // }

	for (;;)
	{
        checkCurrentProcess(process);
        bgList(process);
        char *curr = currentDirectory();
        printString(curr);
        printf("> ");
    //for testing
        // char cmd[267] = "bg cat ./hello.txt";
        // printf("%s", cmd);
        // printf("\n");
    //end testing
	    char *cmd = readline("> ");
        char originalCmd[267];
        strncpy(originalCmd, cmd, 267);
        char *token = strtok(cmd, " ");
        if (strcmp(token, "cd") == 0){ 
            cd(token);
        }else if (strcmp(token, "ls") == 0){
            ls(token);
        }else if(strcmp(token, "pwd") == 0){
            pwd();
        }else if(strcmp(token, "bg") == 0){
            bg(token, process, originalCmd);  
        }else if(strcmp(token, "bglist") == 0){
            bgList(process);
        }else if(strcmp(token, "stop") == 0){
            stop(process, token);
        }else if(strcmp(token, "start")== 0){
            start(process, token);
        }else{
            printf("cannot find the command");
        }
        printf("made it\n");
        bgList(process);
        // free(token);
		free (cmd);
        free(curr);
        

      //  break;
	}	
}