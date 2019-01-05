import pygame, sys
from pygame.locals import *
import random
import os

pygame.init()

DISPLAY=pygame.display.set_mode((700,400),0,32)

WHITE=(255,255,255)
BLACK = (0,0,0)
BLUE = (135,206,250)
ORANGE = (255,165,0)
DISPLAY.fill(WHITE)


def drawBackground():
    pygame.draw.rect(DISPLAY,BLUE,(0,0,700,200)) 

def drawSnowman():

    ## body
    pygame.draw.circle(DISPLAY,BLACK,[100,100],38,1)
    pygame.draw.circle(DISPLAY,BLACK,[100,160],50,1)
    pygame.draw.circle(DISPLAY,BLACK,[100,215],63,1)
    pygame.draw.circle(DISPLAY,WHITE,[100,100,],37,0)
    pygame.draw.circle(DISPLAY,WHITE,[100,160,],49,0)
    pygame.draw.circle(DISPLAY,WHITE,[100,215,],62,0)

    ## eyes
    pygame.draw.circle(DISPLAY,BLACK,[85,85,],5,0)
    pygame.draw.circle(DISPLAY,BLACK,[115,85,],5,0)

    ## mouth
    pygame.draw.circle(DISPLAY,BLACK,[81,110,],5,0)
    pygame.draw.circle(DISPLAY,BLACK,[91,115,],5,0)
    pygame.draw.circle(DISPLAY,BLACK,[101,118,],5,0)
    pygame.draw.circle(DISPLAY,BLACK,[111,115,],5,0)
    pygame.draw.circle(DISPLAY,BLACK,[121,110,],5,0)

    ##hat
    pygame.draw.rect(DISPLAY,BLACK,(62,58,75,20))
    pygame.draw.rect(DISPLAY,BLACK,(74,38,50,20))

    ##nose
    pygame.draw.polygon(DISPLAY, ORANGE, [[100, 93], [100, 103],[115, 98]], 0)

    
def drawSnowflake():

    ## randomly draws snowflakes on the screen
    k = 1
    while k <= 45:
        x = random.randint(0,700)
        y = random.randint(0,400)
        pygame.draw.line(DISPLAY,BLACK,[x, y],[ x + 20, y + 20],1)
        pygame.draw.line(DISPLAY,BLACK,[x+10, y],[ x + 10, y + 20],1)
        pygame.draw.line(DISPLAY,BLACK,[x+20, y],[ x, y + 20],1)
        pygame.draw.line(DISPLAY,BLACK,[x, y+10],[ x + 20, y + 10],1)
	   
        k += 1

## main program here!!!
def main():
    drawBackground()
    drawSnowflake()
    drawSnowman()
    

    while True:
        for event in pygame.event.get():
            if event.type==QUIT:
                pygame.quit()
                sys.exit()
        pygame.display.update()

main()
