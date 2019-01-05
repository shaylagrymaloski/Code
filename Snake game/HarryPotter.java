/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houseCupTournament;

import environment.LocationValidatorIntf;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Shayla
 */
public class HarryPotter {

//<editor-fold defaultstate="collapsed" desc="Action Methods">
    public void move() {

        if ((!paused) && (alive)) {
//        moving the snake
            Point newHead = (Point) getHead().clone();

            if (direction == Direction.DOWN) {
                newHead.y++;

            } else if (direction == Direction.UP) {
                newHead.y--;

            } else if (direction == Direction.LEFT) {
                newHead.x--;

            } else if (direction == Direction.RIGHT) {
                newHead.x++;
            }

            if (locationValidator != null) {
                body.add(HEAD_POSITION, locationValidator.validateLocation(newHead));
            }

            //loses the tail
            if (growthCounter <= 0) {
                body.remove(body.size() - 1);
            } else {
                growthCounter--;
            }
        }

    }

    public boolean selfHit() {
        for (int i = 1; i < this.body.size(); i++) {
            if (this.getHead().equals(this.body.get(i))) {
                System.out.println("SELF HIT = " + getHead());
                return true;
            }
        }
        return false;
    }

   

    {
        segmentImage = ResourceTools.loadImageFromResource("resources/DarrenCriss.jpg");
    }

    public void draw(Graphics graphics) {
        Image segment = segmentImage.getScaledInstance(drawData.getCellWidth(), drawData.getCellHeight(), Image.SCALE_FAST);

        for (Point bodySegmentLocation : getSafeBody()) {
            Point topLeft = drawData.getCellSystemCoordinate(bodySegmentLocation);

            graphics.setColor(Color.RED);
//            graphics.fillOval(topLeft.x, topLeft.y,
//                    drawData.getCellWidth(), drawData.getCellHeight());
            graphics.drawImage(segment, topLeft.x, topLeft.y, null);
        }
    }
  

    public void grow(int length) {
        growthCounter += length;
    }
  
  
    
    
    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    static HarryPotter java;

    private final int HEAD_POSITION = 0;
    private LocationValidatorIntf locationValidator;
    private boolean paused;
    private Image segmentImage;
    private int growthCounter;

    private Score score;
    private boolean alive = true;
    

    private ArrayList<Point> body = new ArrayList<>();
    private Direction direction = Direction.RIGHT;
    private GridDrawData drawData;

    //drawing the snake with red circles
//    public void draw(Graphics graphics) {
//
//        for (Point bodySegmentLocation : getBody()) {
//            System.out.println("location ! =" + bodySegmentLocation);
//            System.out.print("System Loc =" + drawData.getCellSystemCoordinate(bodySegmentLocation));
//
//            Point topLeft = drawData.getCellSystemCoordinate(bodySegmentLocation);
//            graphics.setColor(Color.red);
//            graphics.fillOval(topLeft.x, topLeft.y, drawData.getCellWidth(), drawData.getCellHeight());
//
//        }
//
//
//    }
    //drawing the snake with pictures as the body
    /**
     * @return the body
     */
    public ArrayList<Point> getSafeBody() {
        ArrayList<Point> safeBody = new ArrayList<Point>();
        for (Point point : body) {
            safeBody.add(point);
        }
        return safeBody;
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    public Point getHead() {
        return body.get(HEAD_POSITION);
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the drawData
     */
    public GridDrawData getDrawData() {
        return drawData;
    }

    /**
     * @param drawData the drawData to set
     */
    public void setDrawData(GridDrawData drawData) {
        this.drawData = drawData;
    }

    /**
     * @return the locationValidator
     */
    public LocationValidatorIntf getLocationValidator() {
        return locationValidator;
    }

    /**
     * @param locationValidator the locationValidator to set
     */
    public void setLocationValidator(LocationValidatorIntf locationValidator) {
        this.locationValidator = locationValidator;
    }

    /**
     */
    public void togglePaused() {
        if (paused) {
            paused = false;
        } else {
            paused = true;
        }
    }

    public boolean isPaused() {
        return paused;
    }

    /**
     * @param paused the paused to set
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * @return the segmentImage
     */
    public Image getSegmentImage() {
        return segmentImage;
    }

    /**
     * @param segmentImage the segmentImage to set
     */
    public void setSegmentImage(Image segmentImage) {
        this.segmentImage = segmentImage;
    }

    /**
     * @return the growthCounter
     */
    public int getGrowthCounter() {
        return growthCounter;
    }

    /**
     * @param growthCounter the growthCounter to set
     */
    public void setGrowthCounter(int growthCounter) {
        this.growthCounter = growthCounter;
    }

    /**
     * @return true if the snake is dead (NOT ALIVE)
     */
    public boolean isDead() {
        return !alive;

    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
   
    
    public void resetSnake(Point headLocation, int size, Direction direction){
//  - delete all the locations from the snakes body;
        body.clear();
//  - add the headLocation to the body (as the first part of the snake);
        body.add(HEAD_POSITION, headLocation);
//  - set the direction of the snake;
        this.direction = direction;
//  - set the growthCounter to the value of the input parameter "size" - 1;
        this.growthCounter = size - 1;
        
    }

//</editor-fold>

  
  
}
