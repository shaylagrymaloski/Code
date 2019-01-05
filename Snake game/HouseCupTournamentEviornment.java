 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houseCupTournament;

import audio.AudioEvent;
import audio.AudioEventListenerIntf;
import audio.AudioPlayer;
import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import audio.Track;
import environment.Environment;
import environment.LocationValidatorIntf;
import grid.Grid;
import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Shayla
 */
class HouseCupTournamentEviornment extends Environment implements GridDrawData, LocationValidatorIntf, AudioEventListenerIntf {

    Grid grid;
    private HarryPotter harryPotter;
    private Score score;
    private int level;
    private final int HEAD_POSITION = 0;

    private final int SLOW_SPEED = 3;
    private final int MEDIUM_SPEED = 2;
    private final int HIGH_SPEED = 1;

    private int slowSpeed = SLOW_SPEED;
    private int mediumSpeed = MEDIUM_SPEED;
    private int highSpeed = HIGH_SPEED;
    private int moveDelayCounter = 0;

    private ArrayList<GridObject> gridObjects;
 
    private Image segmentImage;

    private Image ladel;
    private Image guitar;
    private Image musicNote;
    private GameState gameState = GameState.PLAYING;

    private SoundManager soundManager;
    private Animator Animator;
    private Animator Animator2;
    private Animator Animator3;

    private String trackNameGameTimer;
    private static String HEY_DRAGON_LABEL = "HEY_DRAGON";
    private static String ACCIO_GUITAR_LABEL = "ACCIO_GUITAR";
    private static String GRANGER_DANGER_LABEL = "GRANGER_DANGER";
    private static String DANCE_AGAIN_LABEL = "DANCE_AGAIN";
    private static String I_WAS_LABEL = "I_WAS";
    private static String HARRY_FREAKIN_POTTER_LABEL = "HARRY_FREAKIN_POTTER";
    private static String DAYS_OF_SUMMER_LABEL = "DAYS_OF_SUMMER";
    private static String PORTKEY_LABEL = "PORTKEY";
//    private static String _LABEL = "";
//    private static String _LABEL = "";

    public HouseCupTournamentEviornment() {
    }

    @Override
    public void initializeEnvironment() {
        ImageManager im = new ImageManager();
        im.addImage("G", ResourceTools.loadImageFromResource("resources/GameOver_G.png"));
        im.addImage("GA", ResourceTools.loadImageFromResource("resources/GameOver_GA.png"));
        im.addImage("GAM", ResourceTools.loadImageFromResource("resources/GameOver_GAM.png"));
        im.addImage("GAME", ResourceTools.loadImageFromResource("resources/GameOver_GAME.png"));
        im.addImage("GAME_O", ResourceTools.loadImageFromResource("resources/GameOver_GAME_O.png"));
        im.addImage("GAME_OV", ResourceTools.loadImageFromResource("resources/GameOver_GAME_OV.png"));
        im.addImage("GAME_OVE", ResourceTools.loadImageFromResource("resources/GameOver_GAME_OVE.png"));
        im.addImage("GAME_OVER", ResourceTools.loadImageFromResource("resources/GameOver_GAME_OVER.png"));
        im.addImage("START", ResourceTools.loadImageFromResource("resources/Start.png"));
        im.addImage("START_PRESS_S", ResourceTools.loadImageFromResource("resources/Start_Press_s.png"));
        im.addImage("WHITE", ResourceTools.loadImageFromResource("resources/White.png"));
        im.addImage("BLACK", ResourceTools.loadImageFromResource("resources/Black.png"));

        ArrayList<String> gameOverScreens = new ArrayList<>();
        gameOverScreens.add("G");
        gameOverScreens.add("GA");
        gameOverScreens.add("GAM");
        gameOverScreens.add("GAME");
        gameOverScreens.add("GAME_O");
        gameOverScreens.add("GAME_OV");
        gameOverScreens.add("GAME_OVE");
        gameOverScreens.add("GAME_OVER");

        ArrayList<String> portkeyScreens = new ArrayList<>();
        portkeyScreens.add("WHITE");
        portkeyScreens.add("BLACK");

        Animator = new Animator(im, gameOverScreens, 500);

        Animator2 = new Animator(im, portkeyScreens, 500);

        this.trackNameGameTimer = ACCIO_GUITAR_LABEL;
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track(HEY_DRAGON_LABEL, Source.RESOURCE, "/resources/HeyDragonShort.wav"));
        tracks.add(new Track(ACCIO_GUITAR_LABEL, Source.RESOURCE, "/resources/AccioGuitar.wav"));
        tracks.add(new Track(GRANGER_DANGER_LABEL, Source.RESOURCE, "/resources/GrangerDangerShort.wav"));
        tracks.add(new Track(DANCE_AGAIN_LABEL, Source.RESOURCE, "/resources/DanceAgainShort.wav"));
        tracks.add(new Track(I_WAS_LABEL, Source.RESOURCE, "/resources/IWasShort.wav"));
        tracks.add(new Track(HARRY_FREAKIN_POTTER_LABEL, Source.RESOURCE, "/resources/HarryFreakinPotter.wav"));
        tracks.add(new Track(DAYS_OF_SUMMER_LABEL, Source.RESOURCE, "/resources/DaysOfSummer.wav"));
        tracks.add(new Track(PORTKEY_LABEL, Source.RESOURCE, "/resources/Portkey.wav"));
        //AudioPlayer.play("/resources/GrangerDanger.wav");

        Playlist playList = new Playlist(tracks);

        soundManager = new SoundManager(playList, this);

        score = new Score();
        score.setPosition(new Point(10, 50));
        guitar = ResourceTools.loadImageFromResource("resources/guitar.jpeg");
        musicNote = ResourceTools.loadImageFromResource("resources/MusicNote.png");
        ladel = ResourceTools.loadImageFromResource("resources/squert.jpeg");

        this.setBackground(ResourceTools.loadImageFromResource("resources/DragonChallenge.png").getScaledInstance(900, 525, Image.SCALE_FAST));
        soundManager.play(ACCIO_GUITAR_LABEL);

        grid = new Grid(35, 20, 25, 25, new Point(10, 20), Color.RED);

        harryPotter = new HarryPotter();
        harryPotter.setDirection(Direction.DOWN);
        harryPotter.setGrowthCounter(3);
        harryPotter.setDrawData(this);
        harryPotter.setLocationValidator(this);

        ArrayList<Point> body = new ArrayList<>();
        body.add(new Point(3, 1));
//        body.add(new Point(3, 2));
//        body.add(new Point(2, 2));
//        body.add(new Point(2, 3));

        harryPotter.setBody(body);

        gridObjects = new ArrayList<>();
//        gridObjects.add(new GridObject(GridObjectType.MUSIC_NOTE, getRandomPoint()));
//        gridObjects.add(new GridObject(GridObjectType.GUITAR, getRandomPoint()));

    }

    public void timerTaskHandler() {
        if (harryPotter != null) {
            //if counter > = limit then reset counter and move snake
            //else increment counter
            if (this.moveDelayCounter >= this.slowSpeed) {
                moveDelayCounter = 0;
                harryPotter.move();
            } else {
                moveDelayCounter++;
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_N) {
//            grid.setShowCellCoordinates(!grid.get  getShowCellCoordinates());

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            harryPotter.setDirection(Direction.UP);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            harryPotter.setDirection(Direction.DOWN);

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            harryPotter.setDirection(Direction.LEFT);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            harryPotter.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            harryPotter.togglePaused();
        } else if (e.getKeyCode() == KeyEvent.VK_G) {
            harryPotter.grow(2);
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            this.setLevel(1);
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            this.setLevel(2);
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            this.setLevel(3);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.setLevel(1);
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            this.setGameState(GameState.END);
        }
        
                

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        switch (gameState) {

            case TRAVEL:
                graphics.drawImage(Animator2.getCurrentImage().getScaledInstance(900, 600, Image.SCALE_FAST), 0, 0, this);

                break;
            case PLAYING:

                if (grid != null) {
//            grid.paintComponent(graphics);
                }

                if (harryPotter != null) {
                    harryPotter.draw(graphics);
                }

                if (gridObjects != null) {
                    for (GridObject gridObject : gridObjects) {
                        if (gridObject.getType() == GridObjectType.GUITAR) {
                            graphics.drawImage(guitar, grid.getCellSystemCoordinate(gridObject.getLocation()).x,
                                    grid.getCellSystemCoordinate(gridObject.getLocation()).y,
                                    getCellWidth(), getCellHeight(), this);

                        } else if (gridObject.getType() == GridObjectType.MUSIC_NOTE) {
                            graphics.drawImage(musicNote, grid.getCellSystemCoordinate(gridObject.getLocation()).x,
                                    grid.getCellSystemCoordinate(gridObject.getLocation()).y,
                                    getCellWidth(), getCellHeight(), this);

                        } else if (gridObject.getType() == GridObjectType.LADEL) {
                            graphics.drawImage(ladel, grid.getCellSystemCoordinate(gridObject.getLocation()).x,
                                    grid.getCellSystemCoordinate(gridObject.getLocation()).y,
                                    getCellWidth(), getCellHeight(), this);

                        }

                    }
                }

                if (score != null) {
                    score.draw(graphics);
                }

                break;
            case END:
                
                this.setBackground(ResourceTools.loadImageFromResource("resources/Start.png").getScaledInstance(900, 525, Image.SCALE_FAST));

                break;

            case OVER:
             
                
                
                graphics.drawImage(Animator.getCurrentImage().getScaledInstance(900, 600, Image.SCALE_FAST), 0, 0, this);

        }
    }

    public Point getRandomPoint() {
//        return new Point((int) (grid.getRows() * Math.random()), (int) (grid.getColumns() * Math.random()));
        return new Point((int) (grid.getColumns() * Math.random()), (int) (grid.getRows() * Math.random()));
    }

//<editor-fold defaultstate="collapsed" desc="GridDrawData Interface">
    @Override
    public int getCellHeight() {
        return grid.getCellHeight();

    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public Point getCellSystemCoordinate(Point cellCoordinate) {
        return grid.getCellSystemCoordinate(cellCoordinate);
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="LocationValidatorIntf">
    @Override
    public Point validateLocation(Point point) {

        if (harryPotter.selfHit()) {
            System.out.println("Self Hit");
               this.soundManager.stop(HEY_DRAGON_LABEL);
                this.soundManager.stop(GRANGER_DANGER_LABEL);
                this.soundManager.stop(DANCE_AGAIN_LABEL);
                harryPotter.togglePaused();
           soundManager.play(I_WAS_LABEL);
            this.setGameState(GameState.OVER);

        }

        if (point.x >= this.grid.getColumns()) {
            point.x = 0;
        } else if (point.x < 0) {
            point.x = this.grid.getColumns() - 1;
        }
        if (point.y >= this.grid.getRows()) {
            point.y = 0;
        } else if (point.y < 0) {
            point.y = this.grid.getRows() - 1;
        }
        //check if the snake hit a GridObhect, then take appropriate action
        //Guitar sound
        //Music notes grow snake
        //look at all the locations stored in the gridObject
        //for each compare it to the head location stored
        //in the point parameter
        int newNotes = 0;
//                    
///       for (int i = 0; i < newNotes; i++) {
//            gridObjects.add(new GridObject(GridObjectType.MUSIC_NOTE, getRandomPoint()));
//        }
// 
        for (GridObject object : gridObjects) {
            if (object.getLocation().equals(point)) {
                System.out.println("Hit = " + object.getType());
                HarryPotter HarryPotter = null;

//                object.getLocation().x = -200;
                if (object.getType() == GridObjectType.GUITAR) {
//                    object.setLocation(this.getRandomPoint());
                    object.getLocation().move(1000000000, 1000000000);
                    soundManager.play(HEY_DRAGON_LABEL);
                    newNotes++;
                } else if (object.getType() == GridObjectType.MUSIC_NOTE) {
                    harryPotter.grow(1);
                    object.setLocation(this.getRandomPoint());
                    this.score.addToValue(5);

                } else if (object.getType() == GridObjectType.LADEL) {
                    object.getLocation().move(1000000000, 1000000000);
                     harryPotter.togglePaused();
                    this.setGameState(gameState.TRAVEL);
                    soundManager.play(PORTKEY_LABEL);

                }
//                  

            }
        }

        for (int i = 0; i < newNotes; i++) {
            gridObjects.add(new GridObject(GridObjectType.MUSIC_NOTE, getRandomPoint()));
        }

        // check if the snake hit itself!!!!!
        return point;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {

        if (this.level != level) {
            this.level = level;
            if (level == 1) {
                this.setBackground(ResourceTools.loadImageFromResource("resources/DragonChallenge.png").getScaledInstance(900, 525, Image.SCALE_FAST));
                soundManager.play(ACCIO_GUITAR_LABEL);

            } else if (level == 2) {
                this.setBackground(ResourceTools.loadImageFromResource("resources/BallroomFloor.png").getScaledInstance(900, 525, Image.SCALE_FAST));
                soundManager.play(GRANGER_DANGER_LABEL);
               
            } else if (level == 3) {
                 harryPotter.togglePaused();
                 harryPotter.resetSnake(harryPotter.getHead(), 4, Direction.UP);
                this.setBackground(ResourceTools.loadImageFromResource("resources/Graveyard.png").getScaledInstance(900, 525, Image.SCALE_FAST));
                soundManager.play(DANCE_AGAIN_LABEL);
                
              
            } //START

        }

    }

    private GridObjectType getClass(HarryPotter harryPotter) {
        this.harryPotter = HarryPotter.java;
        return null;

    }

    /**
     * @return the GameState
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * @param GameState the GameState to set
     */
    public void setGameState(GameState GameState) {
        this.gameState = GameState;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="AudioEventListenerIntf methods">
    @Override
    public void onAudioEvent(AudioEvent event, String trackName) {
        System.out.println("Audio event = " + event.name() + "  on track " + trackName);

        if (event.equals(AudioEvent.ON_COMPLETE)) {

////    private static String HEY_DRAGON_LABEL = "HEY_DRAGON";
//    private static String ACCIO_GUITAR_LABEL = "ACCIO_GUITAR";
//    private static String GRANGER_DANGER_LABEL = "GRANGER_DANGER";
            if (trackName.equals(HEY_DRAGON_LABEL)) {
            if (this.gameState!= gameState.OVER){
                 this.setLevel(2);  
                }
                

            } else if (trackName.equals(DANCE_AGAIN_LABEL)) {
                if (this.gameState!= gameState.OVER){
                    this.setGameState(gameState.END);
                }

            } else if (trackName.equals(ACCIO_GUITAR_LABEL)) {
               if (this.gameState!= gameState.OVER){
                   gridObjects.add(new GridObject(GridObjectType.GUITAR, getRandomPoint()));
                } 

            } else if (trackName.equals(GRANGER_DANGER_LABEL)) {
                if (this.gameState!= gameState.OVER){
                    gridObjects.add(new GridObject(GridObjectType.LADEL, getRandomPoint()));
                } 
               
            } else if (trackName.equals(PORTKEY_LABEL)) {
                if (this.gameState!= gameState.OVER){
                  this.setGameState(GameState.PLAYING);
                this.setLevel(3);
                }else if (trackName.equals(I_WAS_LABEL)){
                    
                      this.soundManager.stop(DANCE_AGAIN_LABEL);
                }
                

            }


        }
    }
//</editor-fold>

    private boolean gameState(GameState gameState) {
        return false;

    }

}
