##import pygame, sys
##from pygame.locals import *
import random
import os
import pygame, sys
from pygame.locals import *




def practice1():
    i= 1
    for i in range (0,10):
        print ("*",end="")

def practice2():
    for i in range (0,10):
        print ("*",end="")
    print("")
    for i in range (0,5):
        print ("*",end="")
    print("")
    for i in range (0,20):
        print ("*",end="")

def practice3():
    for i in range (0,10):
        for i in range (0,10):
            print ("*",end="")
        print("")

def practice4():
    for i in range (0,7):
        x = 0
        for i in range (0,10):
            
            print (x,end="")
            x +=1
        print("")
def practice6():
    colum = 0
    for i in range (0,8):
        
        x = 0
        for i in range (0,colum):
            
            print (x,end="")
            x +=1
        colum+=1
        print("")
        
def practice8():
    y = 1
    x = 1
    interval = 1
    for i in range (0,5):
        
        
        for i in range (0,9):
           if (x <10):
               
               print (x,end="  ")
           else:
               print (x,end=" ")
           x += interval
        interval += 1
        y +=1
        x = y           
        print("")
def practice9():
    for i in range (1,10):
        for j in range (10 - i):
            print(" ", end = " ")
        for j in range (1,i):
            print (j,end = " ")
        for i in range (i,0,-1):
            print (i,end = " ")
        print("")
        
def practice9():
    for i in range (1,10):
        for j in range (10 - i):
            print(" ", end = " ")
        for j in range (1,i):
            print (j,end = " ")
        for i in range (i,0,-1):
            print (i,end = " ")
        print("")

def practice10():
    x = 9
    for i in range (1,10):
        for j in range (10 - i):
            print(" ", end = " ")
        for j in range (1,i):
            print (j,end = " ")
        for i in range (i,0,-1):
            print (i,end = " ")
        print("")
    for i in range(1,9):
        for j in range (1+i):
            print(" ", end = " ")
        for i in range (1,x):
            print(i, end = " ")
        x -=1
        print("")
        
def assignment1():
    x = 10
    colum = 0
    for i in range (0,8):
        
        for i in range (0,colum):
            
            print (x,end=" ")
            x +=1
        colum+=1
        print("")

def assignment2():
    run = 1
    while (run == 1):
        n = int(input("enter a number between 2 and 10... "))
        if (2<n<10):
     ## prints a square of dim. (n*2) xn          
            x = 1
            for i in range (0,n-1):
                if (i == 0):
                    for i in range(0, n*2):
                        print("o", end = "")
                
                else:
                   print("o", end = "")
               
                   for i in range (0,(n-1)*2):
                       print (" ", end = "")
                       x = 0


                   print("o", end = "")          
                print("")
            for i in range(0, n*2):
                    print("o", end = "")

            print("")
            run = 0
        else:
             print("not a value between 2 and 10")

def assignment3():
    run = 1
    while (run ==1):
        
        n = int(input("enter a number between 1 and 6... "))
        if (1<n<6):
            count = 1
            start = 1
            x = n
            spaceNumber = 0
    
    ## top left triangle
            for i in range (0,n):
                for i in range (0,x):
                    print(count, end = " ")
                    count += 2
                count -=2
    ##space inbetween
                for i in range (0,spaceNumber):
                    print (" ", end = " " )
                spaceNumber +=2
    ## top right
                for i in range (0,x):
                    print(count, end = " ")
                    count -=2
                start +=2
                count = start
                x -=1        
    
                print("")

        
    ## bottom left triangle
            x = 1
            count -=2
            start -=2
            spaceNumber -=2
            for i in range (0,n):       
                for i in range (0,x):
                    print(count, end = " ")
                    count += 2
                count -=2
    
                for i in range (0,spaceNumber):
                    print (" ", end = " " )
                spaceNumber -=2

    ## bottom right triangle
                for i in range (0,x):
                    print(count, end = " ")
                    count -=2

            
                start -=2
                count = start
                x +=1
            
        
                print("")
                run = 0
        else:
            print("Nat a value between 1 and 6")
def assignment4():
    pygame.init()

    DISPLAY=pygame.display.set_mode((700,400),0,32)
    BLACK = (0,0,0)
    BLUE = (135,206,250)
    WHITE = (255,255,255)
    
    DISPLAY.fill(WHITE)

    xBlue = 0
    yBlue = 0
    xBlue2 = 10
    yBlue2 = 10
    xBlack = 10
    yBlack = 0
   
    ##drawes a "grid"

    for i in range (0,20):
        
        for i in range (0,35):
            pygame.draw.rect(DISPLAY,BLUE,(xBlue,yBlue,10,10))
            xBlue+=20
        yBlue+=20
        xBlue = 0

        for i in range(0,35):
            pygame.draw.rect(DISPLAY,BLUE,(xBlue2,yBlue2,10,10))
            xBlue2 +=20
        yBlue2+=20
        xBlue2 = 10

    for i in range (0,20):
        
        for i in range (0,35):
            pygame.draw.rect(DISPLAY,BLACK,(xBlack,yBlack,10,10))
            xBlack+=20
        yBlack+=20
        xBlack =10

        
    while True:
        for event in pygame.event.get():
            if event.type==QUIT:
                pygame.quit()
                sys.exit()
        pygame.display.update()

    

        



                
##practice1()
##practice2()
##practice3()
##practice4()
##practice6()
##practice8()
##practice9()
##practice10()

    
#assignment1()
#assignment2()
assignment3()
#assignment4()

    
