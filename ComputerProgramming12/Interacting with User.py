import pygame

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
text = font.render("RAINBOW!",True,BLACK)



# Loop until user clicks the close button
done = False
# Used to manage how fast the screen updates
clock = pygame.time.Clock()

    
#------------Main Program Loop------------
while not done:
    #-- Main event loop
    for event in pygame.event.get(): # User did something
        if event.type == pygame.QUIT: #If user clicked close
            done = True # Flag that that we are done so we exit

    # ---Game Logic should go here
    text2 = font.render("Score:"+str(value),True,BLACK)

    # ---Drawing code should go here
    # First clear the screen to white. Don't put other drawing commands
    # above this, or they will be erased
    
    if value <=size[0]:
        screen.fill(WHITE)
        #pygame.draw.rect(screen, RED, [x,y,width,height])
        pygame.draw.rect(screen, ORANGE, [0,10,value,10])
        pygame.draw.rect(screen, YELLOW, [0,20,value,10])
        pygame.draw.rect(screen, GREEN, [0,30,value,10])
        pygame.draw.rect(screen, BLUE, [0,40,value,10])
        screen.blit(text,[250,20])
        screen.blit(text2,[250,120])
        
        value = value + 1
        pygame.draw.arc(screen, BLUE, [210, 75, 150, 150], pi,(value/100)*pi/2, 2)
        
        # ---Go ahead and update the screen with what we've drawn.
    pygame.display.flip()

    # ---Limit to 60 frames per second
pygame.quit()
