import pygame
import Snowman

BLACK = (0,0,0)
WHITE = (255,255,255)
GREEN = (0,255,0)
RED = (255,0,0)
BLUE = (0,0,255)
ORANGE = (255,165,0)
YELLOW = (255,255,0)
pi=3.141592653589793

pygame.init()

value = 1
y_offset= 0
score = 0
size = (700,500)
screen = pygame.display.set_mode(size)
font = pygame.font.SysFont('Calibri',25,True,False)
pygame.display.set_caption("Cool Window Title")
text = font.render("RAINBOW!",True,WHITE)




# Loop until user clicks the close button
done = False
# Used to manage how fast the screen updates
clock = pygame.time.Clock()

while not done:
    #-- Main event loop
    for event in pygame.event.get(): # User did something
        if event.type == pygame.QUIT: #If user clicked close
            done = True # Flag that that we are done so we exit
    screen.fill(WHITE)
    pygame.display.flip()
    


    
    def drawSnowman():
        pygame.draw.rect(screen, ORANGE, [100,100,100,100])
        print ("I drew a snowman")

    drawSnowman()
        
    # ---Limit to 60 frames per second
pygame.quit()





