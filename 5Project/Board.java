//Main class where everything takes place on the board.
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.*;


public class Board extends JPanel implements ActionListener {

    private Timer t; //primary timer
    private Timer count = new Timer(500, this); //Used for countdown in between levels/deaths
    private int countdown = 3; //ie: 3:3, 2:2, 1:1, 0:GO!
    private Ship ship, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10; //one for each level
    private Start start;
    private double Level = 0.0;
    private double hlevel = 1.0; //hidden level for deaths to restart at Level 0.5
    private int Lives = 8;
    private boolean first = true; //ie: first time loading level
    private int Num_Enemies = 0;
    private ArrayList<Integer> Score = new ArrayList<Integer>();
    private boolean win = false;
    
    //Level1
    private Enemy1 enemy1,enemy2,enemy3,enemy4,enemy5; // can add as many enemies as I please
    private Enemy1[] E1array = {enemy1,enemy2,enemy3,enemy4,enemy5}; // have to add here too though

    //Level2
    private Enemy1 enemy21, enemy22, enemy23, enemy24, enemy25, enemy26, enemy27, enemy28, enemy29, enemy210;
    private Enemy1[] E2array = {enemy21, enemy22, enemy23, enemy24, enemy25, enemy26, enemy27, enemy28, enemy29, enemy210};

    //Level3
    private Enemy1 enemy31, enemy32, enemy33, enemy34, enemy35;
    private Enemy1[] E3array = {enemy31, enemy32, enemy33, enemy34, enemy35};
    private Enemy2 enemy36, enemy37, enemy38, enemy39, enemy310;
    private Enemy2[] E23array = {enemy36, enemy37, enemy38, enemy39, enemy310};

    //Level4
    private Enemy1 enemy41, enemy42, enemy43, enemy44, enemy45, enemy46, enemy47, enemy48, enemy49, enemy410;
    private Enemy1[] E4array = {enemy41, enemy42, enemy43, enemy44, enemy45, enemy46, enemy47, enemy48, enemy49, enemy410};
    private Enemy2 enemy411, enemy412, enemy413, enemy414, enemy415;
    private Enemy2[] E24array = {enemy411, enemy412, enemy413, enemy414, enemy415};

    //Level5
    private Enemy1 enemy51, enemy52, enemy53, enemy54, enemy55;
    private Enemy1[] E5array = {enemy51, enemy52, enemy53, enemy54, enemy55};
    private Enemy2 enemy56, enemy57, enemy58, enemy59, enemy510, enemy511, enemy512, enemy513, enemy514, enemy515, enemy516, enemy517;
    private Enemy2[] E25array = {enemy56, enemy57, enemy58, enemy59, enemy510, enemy511, enemy512, enemy513, enemy514, enemy515, enemy516, enemy517};

    //Level6
    private Enemy1 enemy61, enemy62, enemy63, enemy64, enemy65, enemy66, enemy67, enemy68, enemy69, enemy610;
    private Enemy1[] E6array = {enemy61, enemy62, enemy63, enemy64, enemy65, enemy66, enemy67, enemy68, enemy69, enemy610};
    private Enemy3 enemy611, enemy612, enemy613, enemy614, enemy615;
    private Enemy3[] E36array = {enemy611, enemy612, enemy613, enemy614, enemy615};

    //Level7
    private Enemy1 enemy714, enemy715, enemy716, enemy717;
    private Enemy1[] E7array = {enemy714, enemy715, enemy716, enemy717};
    private Enemy2 enemy71, enemy72, enemy73, enemy74;
    private Enemy2[] E27array = {enemy71, enemy72, enemy73, enemy74};
    private Enemy3 enemy76, enemy77, enemy78, enemy79, enemy710, enemy711, enemy712, enemy713;
    private Enemy3[] E37array = {enemy76, enemy77, enemy78, enemy79, enemy710, enemy711, enemy712, enemy713};

    //Level8
    private Enemy1 enemy81, enemy82, enemy83, enemy84, enemy85, enemy86, enemy87, enemy88, enemy89, enemy810;
    private Enemy1[] E8array = {enemy81, enemy82, enemy83, enemy84, enemy85, enemy86, enemy87, enemy88, enemy89, enemy810};
    private Enemy4 enemy811, enemy812, enemy813, enemy814, enemy815;
    private Enemy4[] E48array = {enemy811, enemy812, enemy813, enemy814, enemy815};

    //Level9
    private Enemy1 enemy91, enemy92, enemy93, enemy94, enemy95, enemy96, enemy97, enemy98, enemy99;
    private Enemy1[] E9array = {enemy91, enemy92, enemy93, enemy94, enemy95, enemy96, enemy97, enemy98, enemy99};
    private Enemy2 enemy910, enemy911, enemy912, enemy913, enemy914;
    private Enemy2[] E29array = {enemy910, enemy911, enemy912, enemy913, enemy914};
    private Enemy3 enemy915, enemy916, enemy917, enemy918;
    private Enemy3[] E39array = {enemy915, enemy916, enemy917, enemy918};
    private Enemy4 enemy919, enemy920;
    private Enemy4[] E49array = {enemy919, enemy920};

    //Level10
    private Enemy5 enemy101;
    private Enemy1 enemy102, enemy103, enemy104, enemy105, enemy106, enemy107, enemy108, enemy109, enemy1010, enemy1011, enemy1012, enemy1013, enemy1014, enemy1015, enemy1016, enemy1017;
    private Enemy1[] E10array = {enemy102, enemy103, enemy104, enemy105, enemy106, enemy107, enemy108, enemy109, enemy1010, enemy1011, enemy1012, enemy1013, enemy1014, enemy1015, enemy1016, enemy1017};
    
    private Image background;
    private Image title;
    private Image scorei;
    private Image over;
    private Image winner;
    private Image again;
    private Image spacebar;
    private Image space;
    private Image ilives;
    private Image L1;
    private Image L2;
    private Image L3;
    private Image L4;
    private Image L5;
    private Image L6;
    private Image L7;
    private Image L8;
    private Image L9;
    private Image L10;
    private Image L0;
    private Image three;
    private Image two;
    private Image one;
    private Image go;
    private Image Level1;
    private Image Level2;
    private Image Level3;
    private Image Level4;
    private Image Level5;
    private Image Level6;
    private Image Level7;
    private Image Level8;
    private Image Level9;
    private Image Level10;
    private Image Boss;

    public Board() {
        addKeyListener(new TAdapter()); //essentially says to listen to key events
        setFocusable(true); //sets focus of keyboard input to this text field
        setDoubleBuffered(true); //will draw images in memory and then on board (more synced)
	// this.add(Score);
	// Score.setLocation(340, 550);
	// this.setLayout(null);
	start = new Start(); //for getting into level 1
        ImageIcon ii = new ImageIcon(this.getClass().getResource("background.png"));//creates Image Icon for background
        background = ii.getImage(); //gets image out of Image Icon
        ImageIcon iititle = new ImageIcon(this.getClass().getResource("Title.png"));
        title = iititle.getImage();
	ImageIcon iiscore = new ImageIcon(this.getClass().getResource("Score.png"));
        scorei = iiscore.getImage();
        ImageIcon iispace = new ImageIcon(this.getClass().getResource("Start.png"));
        space = iispace.getImage();
	ImageIcon iiover = new ImageIcon(this.getClass().getResource("gameover.png"));
        over = iiover.getImage();
	ImageIcon iiwinner = new ImageIcon(this.getClass().getResource("winner.png"));
        winner = iiwinner.getImage();
	ImageIcon iiagain = new ImageIcon(this.getClass().getResource("again.png"));
        again = iiagain.getImage();
      	ImageIcon iispacebar = new ImageIcon(this.getClass().getResource("space.png"));
        spacebar = iispacebar.getImage();
        ImageIcon iilives = new ImageIcon(this.getClass().getResource("Lives.png"));
        ilives = iilives.getImage();
        ImageIcon iiLi1 = new ImageIcon(this.getClass().getResource("L1.png"));
        L1 = iiLi1.getImage();
        ImageIcon iiLi2 = new ImageIcon(this.getClass().getResource("L2.png"));
        L2 = iiLi2.getImage();
        ImageIcon iiLi3 = new ImageIcon(this.getClass().getResource("L3.png"));
        L3 = iiLi3.getImage();
        ImageIcon iiLi4 = new ImageIcon(this.getClass().getResource("L4.png"));
        L4 = iiLi4.getImage();
        ImageIcon iiLi5 = new ImageIcon(this.getClass().getResource("L5.png"));
        L5 = iiLi5.getImage();
        ImageIcon iiLi6 = new ImageIcon(this.getClass().getResource("L6.png"));
        L6 = iiLi6.getImage();
        ImageIcon iiLi7 = new ImageIcon(this.getClass().getResource("L7.png"));
        L7 = iiLi7.getImage();
        ImageIcon iiLi8 = new ImageIcon(this.getClass().getResource("L8.png"));
        L8 = iiLi8.getImage();
        ImageIcon iiLi9 = new ImageIcon(this.getClass().getResource("L9.png"));
        L9 = iiLi9.getImage();
        ImageIcon iiLi10 = new ImageIcon(this.getClass().getResource("L10.png"));
        L10 = iiLi10.getImage();
	ImageIcon iiLi0 = new ImageIcon(this.getClass().getResource("L0.png"));
        L0 = iiLi0.getImage();
        ImageIcon ii3 = new ImageIcon(this.getClass().getResource("3.png"));
        three = ii3.getImage();
        ImageIcon ii2 = new ImageIcon(this.getClass().getResource("2.png"));
        two = ii2.getImage();
        ImageIcon ii1 = new ImageIcon(this.getClass().getResource("1.png"));
        one = ii1.getImage();
        ImageIcon iigo = new ImageIcon(this.getClass().getResource("Go.png"));
        go = iigo.getImage();
        ImageIcon iiL1 = new ImageIcon(this.getClass().getResource("Level1.png"));
        Level1 = iiL1.getImage();
        ImageIcon iiL2 = new ImageIcon(this.getClass().getResource("Level2.png"));
        Level2 = iiL2.getImage();
        ImageIcon iiL3 = new ImageIcon(this.getClass().getResource("Level3.png"));
        Level3 = iiL3.getImage();
        ImageIcon iiL4 = new ImageIcon(this.getClass().getResource("Level4.png"));
        Level4 = iiL4.getImage();
        ImageIcon iiL5 = new ImageIcon(this.getClass().getResource("Level5.png"));
        Level5 = iiL5.getImage();
        ImageIcon iiL6 = new ImageIcon(this.getClass().getResource("Level6.png"));
        Level6 = iiL6.getImage();
        ImageIcon iiL7 = new ImageIcon(this.getClass().getResource("Level7.png"));
        Level7 = iiL7.getImage();
        ImageIcon iiL8 = new ImageIcon(this.getClass().getResource("Level8.png"));
        Level8 = iiL8.getImage();
        ImageIcon iiL9 = new ImageIcon(this.getClass().getResource("Level9.png"));
        Level9 = iiL9.getImage();
        ImageIcon iiL10 = new ImageIcon(this.getClass().getResource("Level10.png"));
        Level10 = iiL10.getImage();
	ImageIcon iiboss = new ImageIcon(this.getClass().getResource("Boss.png"));
        Boss = iiboss.getImage();
        t = new Timer(12, this);
        t.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(background, 0, 0, null); //draws background
        if(Level != 0.0 && Level != 0.5 && Level != 1000){
	    g2d.drawImage(scorei, 160, 550, null);
            g2d.drawImage(ilives, 460, 550, null);
            if(Lives == 10) {
                g2d.drawImage(L10, 560, 550, null);
            }
            if(Lives == 9) {
                g2d.drawImage(L9, 560, 550, null);
            }
            if(Lives == 8) {
                g2d.drawImage(L8, 560, 550, null);
            }
            if(Lives == 7) {
                g2d.drawImage(L7, 560, 550, null);
            }
            if(Lives == 6) {
                g2d.drawImage(L6, 560, 550, null);
            }
            if(Lives == 5) {
                g2d.drawImage(L5, 560, 550, null);
            }
            if(Lives == 4) {
                g2d.drawImage(L4, 560, 550, null);
            }
            if(Lives == 3) {
                g2d.drawImage(L3, 560, 550, null);
            }
            if(Lives == 2) {
                g2d.drawImage(L2, 560, 550, null);
            }
            if(Lives == 1) {
                g2d.drawImage(L1, 560, 550, null);
            }
	    for(int i = 0; i < Score.size(); i++) {
		int x = 255 + ((Score.size()-1-i)*18);
		if(Score.get(i) == 9) {
		    g2d.drawImage(L9, x, 550, null);
		}
		if(Score.get(i) == 8) {
		    g2d.drawImage(L8, x, 550, null);
		}
		if(Score.get(i) == 7) {
		    g2d.drawImage(L7, x, 550, null);
		}
		if(Score.get(i) == 6) {
		    g2d.drawImage(L6, x, 550, null);
		}
		if(Score.get(i) == 5) {
		    g2d.drawImage(L5, x, 550, null);
		}
		if(Score.get(i) == 4) {
		    g2d.drawImage(L4, x, 550, null);
		}
		if(Score.get(i) == 3) {
		    g2d.drawImage(L3, x, 550, null);
		}
		if(Score.get(i) == 2) {
		    g2d.drawImage(L2, x, 550, null);
		}
		if(Score.get(i) == 1) {
		    g2d.drawImage(L1, x, 550, null);
		}
		if(Score.get(i) == 0) {
		    g2d.drawImage(L0, x, 550, null);
		}
	    }
        }
        if(Level == 0.0){
            g2d.drawImage(title, 25, 150, null); //draws title
            g2d.drawImage(space, 150, 200, null); //draws 'press space to start'
        }
	if(Level == 1000) {
	    if(!win){
		g2d.drawImage(over, 50, 200, null); //draws gameover
	    } else {
		g2d.drawImage(winner, 50, 170, null); //draws win message
	    }
	    g2d.drawImage(again, 160, 250, null);
	    g2d.drawImage(spacebar, 360, 250, null);
	    g2d.drawImage(scorei, 200, 300, null);
	    for(int i = 0; i < Score.size(); i++) {
		int x = 295 + ((Score.size()-1-i)*18);
		if(Score.get(i) == 9) {
		    g2d.drawImage(L9, x, 300, null);
		}
		if(Score.get(i) == 8) {
		    g2d.drawImage(L8, x, 300, null);
		}
		if(Score.get(i) == 7) {
		    g2d.drawImage(L7, x, 300, null);
		}
		if(Score.get(i) == 6) {
		    g2d.drawImage(L6, x, 300, null);
		}
		if(Score.get(i) == 5) {
		    g2d.drawImage(L5, x, 300, null);
		}
		if(Score.get(i) == 4) {
		    g2d.drawImage(L4, x, 300, null);
		}
		if(Score.get(i) == 3) {
		    g2d.drawImage(L3, x, 300, null);
		}
		if(Score.get(i) == 2) {
		    g2d.drawImage(L2, x, 300, null);
		}
		if(Score.get(i) == 1) {
		    g2d.drawImage(L1, x, 300, null);
		}
		if(Score.get(i) == 0) {
		    g2d.drawImage(L0, x, 300, null);
		}
	    }
	}
        if(Level == 0.5){
            t.stop();
            count.start();
            if(countdown == 3){
                g2d.drawImage(three, 225, 250, null);
                countdown--;
            }else if(countdown == 2) {
                g2d.drawImage(two, 225, 250, null);
                countdown--;
            }else if(countdown == 1) {
                g2d.drawImage(one, 225, 250, null);
                countdown--;
            }else if(countdown == 0) {
                g2d.drawImage(go, 175, 250, null);
                countdown = -1;
            }else if(countdown == -1) {
                countdown = 3;
		if(Level != hlevel) {
		    first = true;
		    if(hlevel == 2) {
			if(Score.size()>1000){
			    ship.resetCoor();
			    ship.setDead(false);
			    ship.resetMissiles();
			    for(int i = 0;i<E1array.length;i++){
				E1array[i].setDead(false);
				E1array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 3) {
			if(Score.size()>1000){
			    ship2.resetCoor();
			    ship2.setDead(false);
			    ship2.resetMissiles();
			    for(int i = 0;i<E2array.length;i++){
				E2array[i].setDead(false);
				E2array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 4) {
			if(Score.size()>1000){
			    ship3.resetCoor();
			    ship3.setDead(false);
			    ship3.resetMissiles();
			    for(int i = 0;i<E3array.length;i++){
				E3array[i].setDead(false);
				E3array[i].resetMissiles();
			    }
			    for(int i = 0;i<E23array.length;i++){
				E23array[i].setDead(false);
				E23array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 5) {
			if(Score.size()>1000){
			    ship4.resetCoor();
			    ship4.setDead(false);
			    ship4.resetMissiles();
			    for(int i = 0;i<E4array.length;i++){
				E4array[i].setDead(false);
				E4array[i].resetMissiles();
			    }
			    for(int i = 0;i<E24array.length;i++){
				E24array[i].setDead(false);
				E24array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 6) {
			if(Score.size()>1000){ //for skip
			    ship5.resetCoor();
			    ship5.setDead(false);
			    ship5.resetMissiles();
			    for(int i = 0;i<E5array.length;i++){
				E5array[i].setDead(false);
				E5array[i].resetMissiles();
			    }
			    for(int i = 0;i<E25array.length;i++){
				E25array[i].setDead(false);
				E25array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 7) {
			if(Score.size()>1000){
			    ship6.resetCoor();
			    ship6.setDead(false);
			    ship6.resetMissiles();
			    for(int i = 0;i<E6array.length;i++){
				E6array[i].setDead(false);
				E6array[i].resetMissiles();
			    }
			    for(int i = 0;i<E36array.length;i++){
				E36array[i].setDead(false);
				E36array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 8) {
			if(Score.size()>1000){
			    ship7.resetCoor();
			    ship7.setDead(false);
			    ship7.resetMissiles();
			    for(int i = 0;i<E7array.length;i++){
				E7array[i].setDead(false);
				E7array[i].resetMissiles();
			    }
			    for(int i = 0;i<E27array.length;i++){
				E27array[i].setDead(false);
				E27array[i].resetMissiles();
			    }
			    for(int i = 0;i<E37array.length;i++){
				E37array[i].setDead(false);
				E37array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 9) {
			if(Score.size()>1000){
			    ship8.resetCoor();
			    ship8.setDead(false);
			    ship8.resetMissiles();
			    for(int i = 0;i<E8array.length;i++){
				E8array[i].setDead(false);
				E8array[i].resetMissiles();
			    }
			    for(int i = 0;i<E48array.length;i++){
				E48array[i].setDead(false);
				E48array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 10) {
			if(Score.size()>1000){
			    ship9.resetCoor();
			    ship9.setDead(false);
			    ship9.resetMissiles();
			    for(int i = 0;i<E9array.length;i++){
				E9array[i].setDead(false);
				E9array[i].resetMissiles();
			    }
			    for(int i = 0;i<E29array.length;i++){
				E29array[i].setDead(false);
				E29array[i].resetMissiles();
			    }
			    for(int i = 0;i<E39array.length;i++){
				E39array[i].setDead(false);
				E39array[i].resetMissiles();
			    }
			    for(int i = 0;i<E49array.length;i++){
				E49array[i].setDead(false);
				E49array[i].resetMissiles();
			    }
			}
		    }
		    if(hlevel == 11) {
			if(Score.size()>1000){
			    ship10.resetCoor();
			    ship10.setDead(false);
			    ship10.resetMissiles();
			    enemy101.setDead(false);
			    enemy101.resetMissiles();
			    for(int i = 0;i<E10array.length;i++){
			        E10array[i].setDead(false);
			        E10array[i].resetMissiles();
			    }
			    // for(int i = 0;i<E29array.length;i++){
			    //     E29array[i].setDead(false);
			    //     E29array[i].resetMissiles();
			    // }
			    // for(int i = 0;i<E39array.length;i++){
			    //     E39array[i].setDead(false);
			    //     E39array[i].resetMissiles();
			    // }
			    // for(int i = 0;i<E49array.length;i++){
			    //     E49array[i].setDead(false);
			    //     E49array[i].resetMissiles();
			    // }
			}
		    }
		}
                Level = hlevel; //sets level back at what it should be
            }
        }
	//////////////////////For each level this method just draws
	//////////////////////everything and initializes variables
        if(Level == 1.0){
            count.stop();
            t.start();
	    g2d.drawImage(Level1, 8, 550, null);
            if(first){
                ship = new Ship();
                for(int i = 0;i<E1array.length;i++) {
                    E1array[i] = new Enemy1();
                }
                first = false;
		Num_Enemies = 5;
            }
            if(!ship.deceased()){//if not dead
                g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this); //draws ship
                ArrayList mcontainer = ship.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m1container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E1array.length;i++) { //for each enemy
                if(!E1array[i].deceased()){//if not dead
                    g2d.drawImage(E1array[i].getImage(), E1array[i].getX(), E1array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E1array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m1container.add(E1array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E1array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m1container.add(E1array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
		    }
		}
            }
            for (int i = 0; i< m1container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m1container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 2.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level2, 8, 550, null);
	    if(first){
                ship2 = new Ship();
                for(int i = 0;i<E2array.length;i++) {
                    E2array[i] = new Enemy1();
                }
                first = false;
		Num_Enemies = 10;
            }
            if(!ship2.deceased()){//if not dead
                g2d.drawImage(ship2.getImage(), ship2.getX(), ship2.getY(), this); //draws ship
                ArrayList mcontainer = ship2.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m2container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E2array.length;i++) { //for each enemy
                if(!E2array[i].deceased()){//if not dead
                    g2d.drawImage(E2array[i].getImage(), E2array[i].getX(), E2array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E2array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m2container.add(E2array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else { 
		    for(int j = 0;j<E2array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m2container.add(E2array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m2container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m2container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 3.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level3, 8, 550, null);
	    if(first){
                ship3 = new Ship();
                for(int i = 0;i<E3array.length;i++) {
                    E3array[i] = new Enemy1();
                }
		for(int j = 0;j<E23array.length;j++) {
                    E23array[j] = new Enemy2();
                }
                first = false;
		Num_Enemies = 10;
            }
            if(!ship3.deceased()){//if not dead
                g2d.drawImage(ship3.getImage(), ship3.getX(), ship3.getY(), this); //draws ship
                ArrayList mcontainer = ship3.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m3container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E3array.length;i++) { //for each enemy
                if(!E3array[i].deceased()){//if not dead
                    g2d.drawImage(E3array[i].getImage(), E3array[i].getX(), E3array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E3array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m3container.add(E3array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E3array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m3container.add(E3array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m3container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m3container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m23container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E23array.length;i++) { //for each enemy
                if(!E23array[i].deceased()){//if not dead
                    g2d.drawImage(E23array[i].getImage(), E23array[i].getX(), E23array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E23array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m23container.add(E23array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E23array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m23container.add(E23array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m23container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m23container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 4.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level4, 8, 550, null);
	    if(first){
                ship4 = new Ship();
                for(int i = 0;i<E4array.length;i++) {
                    E4array[i] = new Enemy1();
                }
		for(int j = 0;j<E24array.length;j++) {
                    E24array[j] = new Enemy2();
                }
                first = false;
		Num_Enemies = 15;
            }
            if(!ship4.deceased()){//if not dead
                g2d.drawImage(ship4.getImage(), ship4.getX(), ship4.getY(), this); //draws ship
                ArrayList mcontainer = ship4.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m4container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E4array.length;i++) { //for each enemy
                if(!E4array[i].deceased()){//if not dead
                    g2d.drawImage(E4array[i].getImage(), E4array[i].getX(), E4array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E4array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m4container.add(E4array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E4array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m4container.add(E4array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m4container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m4container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m24container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E24array.length;i++) { //for each enemy
                if(!E24array[i].deceased()){//if not dead
                    g2d.drawImage(E24array[i].getImage(), E24array[i].getX(), E24array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E24array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m24container.add(E24array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E24array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m24container.add(E24array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m24container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m24container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 5.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level5, 8, 550, null);
	    if(first){
                ship5 = new Ship();
                for(int i = 0;i<E5array.length;i++) {
                    E5array[i] = new Enemy1();
                }
		for(int j = 0;j<E25array.length;j++) {
                    E25array[j] = new Enemy2();
                }
                first = false;
		Num_Enemies = 17;
            }
            if(!ship5.deceased()){//if not dead
                g2d.drawImage(ship5.getImage(), ship5.getX(), ship5.getY(), this); //draws ship
                ArrayList mcontainer = ship5.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m5container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E5array.length;i++) { //for each enemy
                if(!E5array[i].deceased()){//if not dead
                    g2d.drawImage(E5array[i].getImage(), E5array[i].getX(), E5array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E5array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m5container.add(E5array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E5array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m5container.add(E5array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m5container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m5container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m25container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E25array.length;i++) { //for each enemy
                if(!E25array[i].deceased()){//if not dead
                    g2d.drawImage(E25array[i].getImage(), E25array[i].getX(), E25array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E25array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m25container.add(E25array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E25array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m25container.add(E25array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m25container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m25container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 6.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level6, 8, 550, null);
	    if(first){
                ship6 = new Ship();
                for(int i = 0;i<E6array.length;i++) {
                    E6array[i] = new Enemy1();
                }
		for(int j = 0;j<E36array.length;j++) {
                    E36array[j] = new Enemy3();
                }
                first = false;
		Num_Enemies = 15;
            }
            if(!ship6.deceased()){//if not dead
                g2d.drawImage(ship6.getImage(), ship6.getX(), ship6.getY(), this); //draws ship
                ArrayList mcontainer = ship6.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m6container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E6array.length;i++) { //for each enemy
                if(!E6array[i].deceased()){//if not dead
                    g2d.drawImage(E6array[i].getImage(), E6array[i].getX(), E6array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E6array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m6container.add(E6array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E6array[i].getMissiles().size();j++){ //if dead, still for each of each enemy's leftover missiles
                        m6container.add(E6array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m6container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m6container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m36container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E36array.length;i++) { //for each enemy
                if(!E36array[i].deceased()){//if not dead
                    g2d.drawImage(E36array[i].getImage(), E36array[i].getX(), E36array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E36array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m36container.add(E36array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E36array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m36container.add(E36array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m36container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB3 m = (MissileB3) m36container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 7.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level7, 8, 550, null);
	    if(first){
                ship7 = new Ship();
                for(int i = 0;i<E7array.length;i++) {
                    E7array[i] = new Enemy1();
                }
		for(int k = 0;k<E27array.length;k++) {
                    E27array[k] = new Enemy2();
                }
		for(int j = 0;j<E37array.length;j++) {
                    E37array[j] = new Enemy3();
                }
                first = false;
		Num_Enemies = 16;
            }
            if(!ship7.deceased()){//if not dead
                g2d.drawImage(ship7.getImage(), ship7.getX(), ship7.getY(), this); //draws ship
                ArrayList mcontainer = ship7.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m7container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E7array.length;i++) { //for each enemy
                if(!E7array[i].deceased()){//if not dead
                    g2d.drawImage(E7array[i].getImage(), E7array[i].getX(), E7array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E7array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m7container.add(E7array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E7array[i].getMissiles().size();j++){ //if dead, still for each of each enemy's leftover missiles
                        m7container.add(E7array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
	    for (int i = 0; i< m7container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m7container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m27container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E27array.length;i++) { //for each enemy
                if(!E27array[i].deceased()){//if not dead
                    g2d.drawImage(E27array[i].getImage(), E27array[i].getX(), E27array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E27array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m27container.add(E27array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E27array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m27container.add(E27array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m27container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m27container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m37container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E37array.length;i++) { //for each enemy
                if(!E37array[i].deceased()){//if not dead
                    g2d.drawImage(E37array[i].getImage(), E37array[i].getX(), E37array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E37array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m37container.add(E37array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E37array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m37container.add(E37array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m37container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB3 m = (MissileB3) m37container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 8.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level8, 8, 550, null);
	    if(first){
                ship8 = new Ship();
                for(int i = 0;i<E8array.length;i++) {
                    E8array[i] = new Enemy1();
                }
		for(int j = 0;j<E48array.length;j++) {
                    E48array[j] = new Enemy4();
                }
                first = false;
		Num_Enemies = 15;
            }
            if(!ship8.deceased()){//if not dead
                g2d.drawImage(ship8.getImage(), ship8.getX(), ship8.getY(), this); //draws ship
                ArrayList mcontainer = ship8.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m8container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E8array.length;i++) { //for each enemy
                if(!E8array[i].deceased()){//if not dead
                    g2d.drawImage(E8array[i].getImage(), E8array[i].getX(), E8array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E8array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m8container.add(E8array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E8array[i].getMissiles().size();j++){ //if dead, still for each of each enemy's leftover missiles
                        m8container.add(E8array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m8container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m8container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m48container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E48array.length;i++) { //for each enemy
                if(!E48array[i].deceased()){//if not dead
                    g2d.drawImage(E48array[i].getImage(), E48array[i].getX(), E48array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E48array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m48container.add(E48array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E48array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m48container.add(E48array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m48container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB4 m = (MissileB4) m48container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 9.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level9, 8, 550, null);
	    if(first){
                ship9 = new Ship();
                for(int i = 0;i<E9array.length;i++) {
                    E9array[i] = new Enemy1();
                }
		for(int k = 0;k<E29array.length;k++) {
                    E29array[k] = new Enemy2();
                }
		for(int j = 0;j<E39array.length;j++) {
                    E39array[j] = new Enemy3();
                }
		for(int n = 0;n<E49array.length;n++) {
                    E49array[n] = new Enemy4();
                }
                first = false;
		Num_Enemies = 20;
            }
            if(!ship9.deceased()){//if not dead
                g2d.drawImage(ship9.getImage(), ship9.getX(), ship9.getY(), this); //draws ship
                ArrayList mcontainer = ship9.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            ArrayList m9container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E9array.length;i++) { //for each enemy
                if(!E9array[i].deceased()){//if not dead
                    g2d.drawImage(E9array[i].getImage(), E9array[i].getX(), E9array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E9array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m9container.add(E9array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
		    for(int j = 0;j<E9array[i].getMissiles().size();j++){ //if dead, still for each of each enemy's leftover missiles
                        m9container.add(E9array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
	    for (int i = 0; i< m9container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m9container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m29container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E29array.length;i++) { //for each enemy
                if(!E29array[i].deceased()){//if not dead
                    g2d.drawImage(E29array[i].getImage(), E29array[i].getX(), E29array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m29container.add(E29array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m29container.add(E29array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m29container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m29container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m39container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E39array.length;i++) { //for each enemy
                if(!E39array[i].deceased()){//if not dead
                    g2d.drawImage(E39array[i].getImage(), E39array[i].getX(), E39array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m39container.add(E39array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m39container.add(E39array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m39container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB3 m = (MissileB3) m39container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    ArrayList m49container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E49array.length;i++) { //for each enemy
                if(!E49array[i].deceased()){//if not dead
                    g2d.drawImage(E49array[i].getImage(), E49array[i].getX(), E49array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m49container.add(E49array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else{ 
		    for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m49container.add(E49array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
		}
            }
            for (int i = 0; i< m49container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB4 m = (MissileB4) m49container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
        }
        if(Level == 10.0){
	    count.stop();
            t.start();
            g2d.drawImage(Level10, 8, 550, null);
	    g2d.drawImage(Boss, 6, 525, null);
	    if(first){
                ship10 = new Ship();
                for(int i = 0;i<E10array.length;i++) {
                    E10array[i] = new Enemy1();
                }
		// for(int k = 0;k<E210array.length;k++) {
                //     E210array[k] = new Enemy2();
                // }
		// for(int j = 0;j<E310array.length;j++) {
                //     E310array[j] = new Enemy3();
                // }
		// for(int n = 0;n<E410array.length;n++) {
                //     E410array[n] = new Enemy4();
                // }
		enemy101 = new Enemy5();
                first = false;
		Num_Enemies = 17;
            }
            
            ArrayList m10container = new ArrayList(); //New arraylist for enemy missiles created
            for(int i = 0;i<E10array.length;i++) { //for each enemy
                if(!E10array[i].deceased()){//if not dead
                    g2d.drawImage(E10array[i].getImage(), E10array[i].getX(), E10array[i].getY(), this); //draw that enemy's image at its location
                    for(int j = 0;j<E10array[i].getMissiles().size();j++){ //for each of each enemy's missiles
                        m10container.add(E10array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
                } else {
	    	    for(int j = 0;j<E10array[i].getMissiles().size();j++){ //if dead, still for each of each enemy's leftover missiles
                        m10container.add(E10array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
                    }
	    	}
            }
	    for (int i = 0; i< m10container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m10container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    // ArrayList m29container = new ArrayList(); //New arraylist for enemy missiles created
            // for(int i = 0;i<E29array.length;i++) { //for each enemy
            //     if(!E29array[i].deceased()){//if not dead
            //         g2d.drawImage(E29array[i].getImage(), E29array[i].getX(), E29array[i].getY(), this); //draw that enemy's image at its location
            //         for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m29container.add(E29array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
            //     } else{ 
	    // 	    for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m29container.add(E29array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
	    // 	}
            // }
            // for (int i = 0; i< m29container.size(); i++ ) { //for each in the enemy missile arraylist
            //     MissileB m = (MissileB) m29container.get(i); //m = that missile
            //     g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            // }
	    // ArrayList m39container = new ArrayList(); //New arraylist for enemy missiles created
            // for(int i = 0;i<E39array.length;i++) { //for each enemy
            //     if(!E39array[i].deceased()){//if not dead
            //         g2d.drawImage(E39array[i].getImage(), E39array[i].getX(), E39array[i].getY(), this); //draw that enemy's image at its location
            //         for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m39container.add(E39array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
            //     } else{ 
	    // 	    for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m39container.add(E39array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
	    // 	}
            // }
            // for (int i = 0; i< m39container.size(); i++ ) { //for each in the enemy missile arraylist
            //     MissileB3 m = (MissileB3) m39container.get(i); //m = that missile
            //     g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            // }
	    // ArrayList m49container = new ArrayList(); //New arraylist for enemy missiles created
            // for(int i = 0;i<E49array.length;i++) { //for each enemy
            //     if(!E49array[i].deceased()){//if not dead
            //         g2d.drawImage(E49array[i].getImage(), E49array[i].getX(), E49array[i].getY(), this); //draw that enemy's image at its location
            //         for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m49container.add(E49array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
            //     } else{ 
	    // 	    for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each of each enemy's missiles
            //             m49container.add(E49array[i].getMissiles().get(j)); //add them to the arraylist for enemy missiles
            //         }
	    // 	}
            // }
            // for (int i = 0; i< m49container.size(); i++ ) { //for each in the enemy missile arraylist
            //     MissileB4 m = (MissileB4) m49container.get(i); //m = that missile
            //     g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            // }
	    if(!ship10.deceased()){//if not dead
                g2d.drawImage(ship10.getImage(), ship10.getX(), ship10.getY(), this); //draws ship
                ArrayList mcontainer = ship10.getMissiles(); //gets missiles created in Ship.java
                for (int i = 0; i < mcontainer.size(); i++ ) { //basically for each missile in the ArrayList (used so it can grow)
                    MissileG m = (MissileG) mcontainer.get(i);   //it will tell the actionPerformed to draw it. 
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
	    ArrayList m51container = new ArrayList(); //New arraylist for enemy missileBs created
	    ArrayList m53container = new ArrayList(); //New arraylist for enemy missileB3s created
	    ArrayList m54container = new ArrayList(); //New arraylist for enemy missileB4s created
	    if(!enemy101.deceased()){//if not dead
		g2d.drawImage(enemy101.getImage(), enemy101.getX(), enemy101.getY(), this); //draw that enemy's image at its location
		for(int j = 0;j<enemy101.getMissiles1().size();j++){ //for each of each enemy's missileBs
		    m51container.add(enemy101.getMissiles1().get(j)); //add them to the arraylist for enemy missileBs
		}
		for(int k = 0;k<enemy101.getMissiles3().size();k++){ //for each of each enemy's missileB3s
		    m53container.add(enemy101.getMissiles3().get(k)); //add them to the arraylist for enemy missileB3s
		}
		for(int n = 0;n<enemy101.getMissiles4().size();n++){ //for each of each enemy's missileB4s
		    m54container.add(enemy101.getMissiles4().get(n)); //add them to the arraylist for enemy missileB4s
		}
	    } else{ 
		for(int j = 0;j<enemy101.getMissiles1().size();j++){ //for each of each enemy's missiles
		    m51container.add(enemy101.getMissiles1().get(j)); //add them to the arraylist for enemy missiles
		}
		for(int k = 0;k<enemy101.getMissiles3().size();k++){ //for each of each enemy's missileB3s
		    m53container.add(enemy101.getMissiles3().get(k)); //add them to the arraylist for enemy missileB3s
		}
		for(int n = 0;n<enemy101.getMissiles4().size();n++){ //for each of each enemy's missileB4s
		    m54container.add(enemy101.getMissiles4().get(n)); //add them to the arraylist for enemy missileB4s
		}
	    }
            for (int i = 0; i< m51container.size(); i++ ) { //for each in the enemy missile arraylist
                MissileB m = (MissileB) m51container.get(i); //m = that missile
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this); //draw m
            }
	    for (int j = 0; j< m53container.size(); j++ ) { //for each in the enemy missile arraylist
                MissileB3 m3 = (MissileB3) m53container.get(j); //m = that missile
                g2d.drawImage(m3.getImage(), m3.getX(), m3.getY(), this); //draw m
            }
	    for (int k = 0; k< m54container.size(); k++ ) { //for each in the enemy missile arraylist
                MissileB4 m4 = (MissileB4) m54container.get(k); //m = that missile
                g2d.drawImage(m4.getImage(), m4.getX(), m4.getY(), this); //draw m
            }
        }
        Toolkit.getDefaultToolkit().sync(); //syncs animation
        g.dispose(); //gets rid of spare data
    }


    public void actionPerformed(ActionEvent e) { //sets whole thing in motion
        if(Level == 0.0){
	    if(start.getGo()){
		Level = 0.5;
		start.resetGo();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip10()){
		Level = 0.5;
		hlevel = 10.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip1()){
		Level = 0.5;
		hlevel = 1.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip2()){
		Level = 0.5;
		hlevel = 2.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip3()){
		Level = 0.5;
		hlevel = 3.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip4()){
		Level = 0.5;
		hlevel = 4.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip5()){
		Level = 0.5;
		hlevel = 5.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip6()){
		Level = 0.5;
		hlevel = 6.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip7()){
		Level = 0.5;
		hlevel = 7.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip8()){
		Level = 0.5;
		hlevel = 8.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
	    if(start.getSkip9()){
		Level = 0.5;
		hlevel = 9.0;
		start.resetSkip();
		Score.add(0);
		Score.add(0);
	    }
        }
	if(start.getRestart() && Level == 1000){
	    Lives = 8;
	    Level = 0.0;
	    hlevel = 1;
	    win = false;
	    start.resetRestart();
	    Score = new ArrayList<Integer>();
	    // for(int i = 0;i<Score.size();i++){
	    // 	Score.remove(i);
	    // }
	}

	//////////////This is the method where interactions within
	//////////////the levels take place
        if(Level == 1.0) {
            ArrayList mcontainer = ship.getMissiles();
            if(!ship.deceased()){
                for (int i = 0; i < mcontainer.size(); i++) {
                    MissileG m = (MissileG) mcontainer.get(i);
                    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E1array.length;j++) {
                            Enemy1 e1 = (Enemy1) E1array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 1.0){
			Num_Enemies = 5;
			ship.resetCoor();
			ship.setDead(false);
			ship.resetMissiles();
			for(int i = 0;i<E1array.length;i++){
			    E1array[i].setDead(false);
			    E1array[i].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship.resetCoor();
                    ship.setDead(false);
                    ship.resetMissiles();
                    for(int i = 0;i<E1array.length;i++){
			E1array[i].setDead(false);
			E1array[i].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m1container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E1array.length;i++) { //for each in enemy array
		for(int j = 0;j<E1array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E1array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m1container.add(E1array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E1array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m1container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m1container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m1container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship.deceased()){
                ship.move(); //tells ship to move
            }
            for(int i = 0;i<E1array.length;i++) {
                if(!E1array[i].deceased()){
                    E1array[i].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship.setDead(true);
		Level = 0.5;
		hlevel = 2.0;
		points(10000);
		points(Lives * 100);
	    }
        }
	if(Level == 2.0) { 
            ArrayList mcontainer = ship2.getMissiles();
            if(!ship2.deceased()){
                for (int i = 0; i < mcontainer.size(); i++) {
                    MissileG m = (MissileG) mcontainer.get(i);
                    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E2array.length;j++) {
                            Enemy1 e1 = (Enemy1) E2array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 2.0){
			Num_Enemies = 10;
			ship2.resetCoor();
			ship2.setDead(false);
			ship2.resetMissiles();
			for(int i = 0;i<E2array.length;i++){
			    E2array[i].setDead(false);
			    E2array[i].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship2.resetCoor();
                    ship2.setDead(false);
                    ship2.resetMissiles();
                    for(int i = 0;i<E2array.length;i++){
			E2array[i].setDead(false);
			E2array[i].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m2container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E2array.length;i++) { //for each in enemy array
		for(int j = 0;j<E2array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E2array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m2container.add(E2array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E2array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m2container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m2container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship2; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m2container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship2.deceased()){
                ship2.move(); //tells ship to move
            }
            for(int i = 0;i<E2array.length;i++) {
                if(!E2array[i].deceased()){
                    E2array[i].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship2.setDead(true);
		Level = 0.5;
		hlevel = 3.0;
		points(20000);
		points(Lives * 500);
	    }
        }
	if(Level == 3.0) { 
            ArrayList mcontainer = ship3.getMissiles();
            if(!ship3.deceased()){
                for (int i = 0; i < mcontainer.size(); i++) {
                    MissileG m = (MissileG) mcontainer.get(i);
                    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E3array.length;j++) {
                            Enemy1 e1 = (Enemy1) E3array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int k = 0;k<E23array.length;k++) {
                            Enemy2 e2 = (Enemy2) E23array[k];
                            if(!e2.deceased()){
                                Rectangle r3 = e2.getArea();
                                if (r1.intersects(r3)) {
                                    m.setDead(true);
                                    e2.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(50);
                                }
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 3.0){
			Num_Enemies = 10;
			ship3.resetCoor();
			ship3.setDead(false);
			ship3.resetMissiles();
			for(int i = 0;i<E3array.length;i++){
			    E3array[i].setDead(false);
			    E3array[i].resetMissiles();
			}
			for(int j = 0;j<E23array.length;j++){
			    E23array[j].setDead(false);
			    E23array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship3.resetCoor();
                    ship3.setDead(false);
                    ship3.resetMissiles();
                    for(int i = 0;i<E3array.length;i++){
			E3array[i].setDead(false);
			E3array[i].resetMissiles();
                    }
		    for(int j = 0;j<E23array.length;j++){
			E23array[j].setDead(false);
			E23array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m3container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E3array.length;i++) { //for each in enemy array
		for(int j = 0;j<E3array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E3array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m3container.add(E3array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E3array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m3container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m3container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship3; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m3container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m23container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E23array.length;i++) { //for each in enemy array
		for(int j = 0;j<E23array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E23array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m23container.add(E23array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E23array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m23container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m23container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship3; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m23container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship3.deceased()){
                ship3.move(); //tells ship to move
            }
            for(int i = 0;i<E3array.length;i++) {
                if(!E3array[i].deceased()){
                    E3array[i].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E23array.length;j++) {
                if(!E23array[j].deceased()){
                    E23array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship3.setDead(true);
		Level = 0.5;
		hlevel = 4.0;
		points(30000);
		points(Lives * 1000);
	    }
        }
	if(Level == 4.0) { 
            ArrayList mcontainer = ship4.getMissiles();
            if(!ship4.deceased()){
                for (int i = 0; i < mcontainer.size(); i++) {
                    MissileG m = (MissileG) mcontainer.get(i);
                    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E4array.length;j++) {
                            Enemy1 e1 = (Enemy1) E4array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int k = 0;k<E24array.length;k++) {
                            Enemy2 e2 = (Enemy2) E24array[k];
                            if(!e2.deceased()){
                                Rectangle r3 = e2.getArea();
                                if (r1.intersects(r3)) {
                                    m.setDead(true);
                                    e2.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(50);
                                }
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 4.0){
			Num_Enemies = 15;
			ship4.resetCoor();
			ship4.setDead(false);
			ship4.resetMissiles();
			for(int i = 0;i<E4array.length;i++){
			    E4array[i].setDead(false);
			    E4array[i].resetMissiles();
			}
			for(int j = 0;j<E24array.length;j++){
			    E24array[j].setDead(false);
			    E24array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship4.resetCoor();
                    ship4.setDead(false);
                    ship4.resetMissiles();
                    for(int i = 0;i<E4array.length;i++){
			E4array[i].setDead(false);
			E4array[i].resetMissiles();
                    }
		    for(int j = 0;j<E24array.length;j++){
			E24array[j].setDead(false);
			E24array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m4container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E4array.length;i++) { //for each in enemy array
		for(int j = 0;j<E4array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E4array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m4container.add(E4array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E4array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m4container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m4container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship4; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m4container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m24container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E24array.length;i++) { //for each in enemy array
		for(int j = 0;j<E24array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E24array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m24container.add(E24array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E24array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m24container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m24container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship4; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m24container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship4.deceased()){
                ship4.move(); //tells ship to move
            }
            for(int i = 0;i<E4array.length;i++) {
                if(!E4array[i].deceased()){
                    E4array[i].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E24array.length;j++) {
                if(!E24array[j].deceased()){
                    E24array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship4.setDead(true);
		Level = 0.5;
		hlevel = 5.0;
		points(40000);
		points(Lives * 2000);
	    }
        }
	if(Level == 5.0) { 
            ArrayList mcontainer = ship5.getMissiles();
            if(!ship5.deceased()){
                for (int i = 0; i < mcontainer.size(); i++) {
                    MissileG m = (MissileG) mcontainer.get(i);
                    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E5array.length;j++) {
                            Enemy1 e1 = (Enemy1) E5array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int k = 0;k<E25array.length;k++) {
                            Enemy2 e2 = (Enemy2) E25array[k];
                            if(!e2.deceased()){
                                Rectangle r3 = e2.getArea();
                                if (r1.intersects(r3)) {
                                    m.setDead(true);
                                    e2.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(50);
                                }
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 5.0){
			Num_Enemies = 17;
			ship5.resetCoor();
			ship5.setDead(false);
			ship5.resetMissiles();
			for(int i = 0;i<E5array.length;i++){
			    E5array[i].setDead(false);
			    E5array[i].resetMissiles();
			}
			for(int j = 0;j<E25array.length;j++){
			    E25array[j].setDead(false);
			    E25array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship5.resetCoor();
                    ship5.setDead(false);
                    ship5.resetMissiles();
                    for(int i = 0;i<E5array.length;i++){
			E5array[i].setDead(false);
			E5array[i].resetMissiles();
                    }
		    for(int j = 0;j<E25array.length;j++){
			E25array[j].setDead(false);
			E25array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m5container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E5array.length;i++) { //for each in enemy array
		for(int j = 0;j<E5array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E5array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m5container.add(E5array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E5array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m5container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m5container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship5; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m5container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m25container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E25array.length;i++) { //for each in enemy array
		for(int j = 0;j<E25array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E25array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m25container.add(E25array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E25array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m25container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m25container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship5; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m25container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship5.deceased()){
                ship5.move(); //tells ship to move
            }
            for(int i = 0;i<E5array.length;i++) {
                if(!E5array[i].deceased()){
                    E5array[i].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E25array.length;j++) {
                if(!E25array[j].deceased()){
                    E25array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship5.setDead(true);
		Level = 0.5;
		hlevel = 6.0;
		points(50000);
		points(Lives * 5000);
	    }
	}
	if(Level == 6.0) { 
	    ArrayList mcontainer = ship6.getMissiles();
	    if(!ship6.deceased()){
		for (int i = 0; i < mcontainer.size(); i++) {
		    MissileG m = (MissileG) mcontainer.get(i);
		    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E6array.length;j++) {
                            Enemy1 e1 = (Enemy1) E6array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int k = 0;k<E36array.length;k++) {
                            Enemy3 e3 = (Enemy3) E36array[k];
                            if(!e3.deceased()){
				if(!m.deceased()){ //otherwise same missile will kill repeatedly
				    Rectangle r3 = e3.getArea();
				    if (r1.intersects(r3)) {
					m.setDead(true);	
					if(e3.getHealth() > 0){
					    mcontainer.remove(i);
					    e3.setHealth(e3.getHealth() - 1);
					} else {
					    e3.setDead(true);
					    mcontainer.remove(i);
					    Num_Enemies--;
					    points(200);
					}
				    }
				}
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 6.0){
			Num_Enemies = 15;
			ship6.resetCoor();
			ship6.setDead(false);
			ship6.resetMissiles();
			for(int i = 0;i<E6array.length;i++){
			    E6array[i].setDead(false);
			    E6array[i].resetMissiles();
			}
			for(int j = 0;j<E36array.length;j++){
			    E36array[j].setDead(false);
			    E36array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship6.resetCoor();
                    ship6.setDead(false);
                    ship6.resetMissiles();
                    for(int i = 0;i<E6array.length;i++){
			E6array[i].setDead(false);
			E6array[i].resetMissiles();
                    }
		    for(int j = 0;j<E36array.length;j++){
			E36array[j].setDead(false);
			E36array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m6container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E6array.length;i++) { //for each in enemy array
		for(int j = 0;j<E6array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E6array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m6container.add(E6array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E6array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m6container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m6container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship6; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m6container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m36container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E36array.length;i++) { //for each in enemy array
		for(int j = 0;j<E36array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB3 m1 = (MissileB3)E36array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m36container.add(E36array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E36array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m36container.size(); i++) { //for each in enemy missile container
                MissileB3 m1 = (MissileB3) m36container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship6; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m36container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship6.deceased()){
                ship6.move(); //tells ship to move
            }
            for(int i = 0;i<E6array.length;i++) {
                if(!E6array[i].deceased()){
                    E6array[i].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E36array.length;j++) {
                if(!E36array[j].deceased()){
                    E36array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship6.setDead(true);
		Level = 0.5;
		hlevel = 7.0;
		points(60000);
		points(Lives * 10000);
	    }
        }
	if(Level == 7.0) { 
	    ArrayList mcontainer = ship7.getMissiles();
	    if(!ship7.deceased()){
		for (int i = 0; i < mcontainer.size(); i++) {
		    MissileG m = (MissileG) mcontainer.get(i);
		    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E7array.length;j++) {
                            Enemy1 e1 = (Enemy1) E7array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int n = 0;n<E27array.length;n++) {
                            Enemy2 e2 = (Enemy2) E27array[n];
                            if(!e2.deceased()){
                                Rectangle r2 = e2.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e2.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(50);
                                }
                            }
                        }
			for (int k = 0;k<E37array.length;k++) {
                            Enemy3 e3 = (Enemy3) E37array[k];
                            if(!e3.deceased()){
				if(!m.deceased()){ //otherwise same missile will kill repeatedly
				    Rectangle r3 = e3.getArea();
				    if (r1.intersects(r3)) {
					m.setDead(true);	
					if(e3.getHealth() > 0){
					    mcontainer.remove(i);
					    e3.setHealth(e3.getHealth() - 1);
					} else {
					    e3.setDead(true);
					    mcontainer.remove(i);
					    Num_Enemies--;
					    points(200);
					}
				    }
				}
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 7.0){
			Num_Enemies = 16;
			ship7.resetCoor();
			ship7.setDead(false);
			ship7.resetMissiles();
			for(int i = 0;i<E7array.length;i++){
			    E7array[i].setDead(false);
			    E7array[i].resetMissiles();
			}
			for(int n = 0;n<E27array.length;n++){
			    E27array[n].setDead(false);
			    E27array[n].resetMissiles();
			}
			for(int j = 0;j<E37array.length;j++){
			    E37array[j].setDead(false);
			    E37array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship7.resetCoor();
                    ship7.setDead(false);
                    ship7.resetMissiles();
                    for(int i = 0;i<E7array.length;i++){
			E7array[i].setDead(false);
			E7array[i].resetMissiles();
                    }
		    for(int n = 0;n<E27array.length;n++){
			E27array[n].setDead(false);
			E27array[n].resetMissiles();
			}
		    for(int j = 0;j<E37array.length;j++){
			E37array[j].setDead(false);
			E37array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m7container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E7array.length;i++) { //for each in enemy array
		for(int j = 0;j<E7array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E7array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m7container.add(E7array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E7array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m7container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m7container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship7; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m7container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m27container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E27array.length;i++) { //for each in enemy array
		for(int j = 0;j<E27array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E27array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m27container.add(E27array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E27array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m27container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m27container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship7; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m27container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m37container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E37array.length;i++) { //for each in enemy array
		for(int j = 0;j<E37array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB3 m1 = (MissileB3)E37array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m37container.add(E37array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E37array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m37container.size(); i++) { //for each in enemy missile container
                MissileB3 m1 = (MissileB3) m37container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship7; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m37container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship7.deceased()){
                ship7.move(); //tells ship to move
            }
            for(int i = 0;i<E7array.length;i++) {
                if(!E7array[i].deceased()){
                    E7array[i].move(); //tells enemy to move
                }
            }
	    for(int k = 0;k<E27array.length;k++) {
                if(!E27array[k].deceased()){
                    E27array[k].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E37array.length;j++) {
                if(!E37array[j].deceased()){
                    E37array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship7.setDead(true);
		Level = 0.5;
		hlevel = 8.0;
		points(70000);
		points(Lives * 20000);
	    }
        }
	if(Level == 8.0) { 
	    ArrayList mcontainer = ship8.getMissiles();
	    if(!ship8.deceased()){
		for (int i = 0; i < mcontainer.size(); i++) {
		    MissileG m = (MissileG) mcontainer.get(i);
		    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E8array.length;j++) {
                            Enemy1 e1 = (Enemy1) E8array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int k = 0;k<E48array.length;k++) {
                            Enemy4 e4 = (Enemy4) E48array[k];
                            if(!e4.deceased()){
				if(!m.deceased()){ //otherwise same missile will kill repeatedly
				    Rectangle r3 = e4.getArea();
				    if (r1.intersects(r3)) {
					m.setDead(true);	
					if(e4.getHealth() > 0){
					    mcontainer.remove(i);
					    e4.setHealth(e4.getHealth() - 1);
					} else {
					    e4.setDead(true);
					    mcontainer.remove(i);
					    Num_Enemies--;
					    points(1000);
					}
				    }
				}
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 8.0){
			Num_Enemies = 15;
			ship8.resetCoor();
			ship8.setDead(false);
			ship8.resetMissiles();
			for(int i = 0;i<E8array.length;i++){
			    E8array[i].setDead(false);
			    E8array[i].resetMissiles();
			}
			for(int j = 0;j<E48array.length;j++){
			    E48array[j].setDead(false);
			    E48array[j].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship8.resetCoor();
                    ship8.setDead(false);
                    ship8.resetMissiles();
                    for(int i = 0;i<E8array.length;i++){
			E8array[i].setDead(false);
			E8array[i].resetMissiles();
                    }
		    for(int j = 0;j<E48array.length;j++){
			E48array[j].setDead(false);
			E48array[j].resetMissiles();
                    }
                    return;
                }
            }
            ArrayList m8container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E8array.length;i++) { //for each in enemy array
		for(int j = 0;j<E8array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E8array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m8container.add(E8array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E8array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m8container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m8container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship8; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m8container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m48container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E48array.length;i++) { //for each in enemy array
		for(int j = 0;j<E48array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB4 m1 = (MissileB4)E48array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m48container.add(E48array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E48array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m48container.size(); i++) { //for each in enemy missile container
                MissileB4 m1 = (MissileB4) m48container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship8; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m48container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship8.deceased()){
                ship8.move(); //tells ship to move
            }
            for(int i = 0;i<E8array.length;i++) {
                if(!E8array[i].deceased()){
                    E8array[i].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E48array.length;j++) {
                if(!E48array[j].deceased()){
                    E48array[j].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship8.setDead(true);
		Level = 0.5;
		hlevel = 9.0;
		points(80000);
		points(Lives * 50000);
	    }
        }
	if(Level == 9.0) { 
	    ArrayList mcontainer = ship9.getMissiles();
	    if(!ship9.deceased()){
		for (int i = 0; i < mcontainer.size(); i++) {
		    MissileG m = (MissileG) mcontainer.get(i);
		    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E9array.length;j++) {
                            Enemy1 e1 = (Enemy1) E9array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			for (int n = 0;n<E29array.length;n++) {
                            Enemy2 e2 = (Enemy2) E29array[n];
                            if(!e2.deceased()){
                                Rectangle r2 = e2.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e2.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(50);
                                }
                            }
                        }
			for (int k = 0;k<E39array.length;k++) {
                            Enemy3 e3 = (Enemy3) E39array[k];
                            if(!e3.deceased()){
				if(!m.deceased()){ //otherwise same missile will kill repeatedly
				    Rectangle r3 = e3.getArea();
				    if (r1.intersects(r3)) {
					m.setDead(true);	
					if(e3.getHealth() > 0){
					    mcontainer.remove(i);
					    e3.setHealth(e3.getHealth() - 1);
					} else {
					    e3.setDead(true);
					    mcontainer.remove(i);
					    Num_Enemies--;
					    points(200);
					}
				    }
				}
                            }
                        }
			for (int k = 0;k<E49array.length;k++) {
                            Enemy4 e4 = (Enemy4) E49array[k];
                            if(!e4.deceased()){
				if(!m.deceased()){ //otherwise same missile will kill repeatedly
				    Rectangle r4 = e4.getArea();
				    if (r1.intersects(r4)) {
					m.setDead(true);	
					if(e4.getHealth() > 0){
					    mcontainer.remove(i);
					    e4.setHealth(e4.getHealth() - 1);
					} else {
					    e4.setDead(true);
					    mcontainer.remove(i);
					    Num_Enemies--;
					    points(1000);
					}
				    }
				}
                            }
                        }
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 9.0){
			Num_Enemies = 20;
			ship9.resetCoor();
			ship9.setDead(false);
			ship9.resetMissiles();
			for(int i = 0;i<E9array.length;i++){
			    E9array[i].setDead(false);
			    E9array[i].resetMissiles();
			}
			for(int n = 0;n<E29array.length;n++){
			    E29array[n].setDead(false);
			    E29array[n].resetMissiles();
			}
			for(int j = 0;j<E39array.length;j++){
			    E39array[j].setDead(false);
			    E39array[j].resetMissiles();
			}
			for(int k = 0;k<E49array.length;k++){
			    E49array[k].setDead(false);
			    E49array[k].resetMissiles();
			}
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship9.resetCoor();
                    ship9.setDead(false);
                    ship9.resetMissiles();
                    for(int i = 0;i<E9array.length;i++){
			E9array[i].setDead(false);
			E9array[i].resetMissiles();
                    }
		    for(int n = 0;n<E29array.length;n++){
			E29array[n].setDead(false);
			E29array[n].resetMissiles();
			}
		    for(int j = 0;j<E39array.length;j++){
			E39array[j].setDead(false);
			E39array[j].resetMissiles();
                    }
		    for(int k = 0;k<E49array.length;k++){
			E49array[k].setDead(false);
			E49array[k].resetMissiles();
		    }
                    return;
                }
            }
            ArrayList m9container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E9array.length;i++) { //for each in enemy array
		for(int j = 0;j<E9array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E9array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m9container.add(E9array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E9array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m9container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m9container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship9; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m9container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m29container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E29array.length;i++) { //for each in enemy array
		for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB m1 = (MissileB)E29array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m29container.add(E29array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E29array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m29container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m29container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship9; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m29container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m39container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E39array.length;i++) { //for each in enemy array
		for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB3 m1 = (MissileB3)E39array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m39container.add(E39array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E39array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m39container.size(); i++) { //for each in enemy missile container
                MissileB3 m1 = (MissileB3) m39container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship9; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m39container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m49container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E49array.length;i++) { //for each in enemy array
		for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each missile in each enemy
		    MissileB4 m1 = (MissileB4)E49array[i].getMissiles().get(j); //Missile m1 equals that missile
		    if(m1.isVisible()){ //if is visible
			m49container.add(E49array[i].getMissiles().get(j)); //add that missile to the missile container
		    }else{
			E49array[i].getMissiles().remove(j); //remove the hidden missile
		    }
		}
            }
            for (int i = 0; i < m49container.size(); i++) { //for each in enemy missile container
                MissileB4 m1 = (MissileB4) m49container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship9; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m49container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship9.deceased()){
                ship9.move(); //tells ship to move
            }
            for(int i = 0;i<E9array.length;i++) {
                if(!E9array[i].deceased()){
                    E9array[i].move(); //tells enemy to move
                }
            }
	    for(int k = 0;k<E29array.length;k++) {
                if(!E29array[k].deceased()){
                    E29array[k].move(); //tells enemy to move
                }
            }
	    for(int j = 0;j<E39array.length;j++) {
                if(!E39array[j].deceased()){
                    E39array[j].move(); //tells enemy to move
                }
            }
	    for(int n = 0;n<E49array.length;n++) {
                if(!E49array[n].deceased()){
                    E49array[n].move(); //tells enemy to move
                }
            }
	    if(Num_Enemies == 0){
		ship9.setDead(true);
		Level = 0.5;
		hlevel = 10.0;
		points(90000);
		points(Lives * 100000);
	    }
        }
	if(Level == 10.0) { 
	    ArrayList mcontainer = ship10.getMissiles();
	    if(!ship10.deceased()){
		for (int i = 0; i < mcontainer.size(); i++) {
		    MissileG m = (MissileG) mcontainer.get(i);
		    if (m.isVisible()){
                        m.move();      //basically, for each missile, if onscreen, move
                        Rectangle r1 = m.getArea(); //area defined
                        for (int j = 0;j<E10array.length;j++) {
                            Enemy1 e1 = (Enemy1) E10array[j];
                            if(!e1.deceased()){
                                Rectangle r2 = e1.getArea();
                                if (r1.intersects(r2)) {
                                    m.setDead(true);
                                    e1.setDead(true);
                                    mcontainer.remove(i);
				    Num_Enemies--;
				    points(10);
                                }
                            }
                        }
			// for (int n = 0;n<E29array.length;n++) {
                        //     Enemy2 e2 = (Enemy2) E29array[n];
                        //     if(!e2.deceased()){
                        //         Rectangle r2 = e2.getArea();
                        //         if (r1.intersects(r2)) {
                        //             m.setDead(true);
                        //             e2.setDead(true);
                        //             mcontainer.remove(i);
			// 	    Num_Enemies--;
			// 	    points(50);
                        //         }
                        //     }
                        // }
			// for (int k = 0;k<E39array.length;k++) {
                        //     Enemy3 e3 = (Enemy3) E39array[k];
                        //     if(!e3.deceased()){
			// 	if(!m.deceased()){ //otherwise same missile will kill repeatedly
			// 	    Rectangle r3 = e3.getArea();
			// 	    if (r1.intersects(r3)) {
			// 		m.setDead(true);	
			// 		if(e3.getHealth() > 0){
			// 		    mcontainer.remove(i);
			// 		    e3.setHealth(e3.getHealth() - 1);
			// 		} else {
			// 		    e3.setDead(true);
			// 		    mcontainer.remove(i);
			// 		    Num_Enemies--;
			// 		    points(200);
			// 		}
			// 	    }
			// 	}
                        //     }
                        // }
			// for (int k = 0;k<E49array.length;k++) {
                        //     Enemy4 e4 = (Enemy4) E49array[k];
                        //     if(!e4.deceased()){
			// 	if(!m.deceased()){ //otherwise same missile will kill repeatedly
			// 	    Rectangle r4 = e4.getArea();
			// 	    if (r1.intersects(r4)) {
			// 		m.setDead(true);	
			// 		if(e4.getHealth() > 0){
			// 		    mcontainer.remove(i);
			// 		    e4.setHealth(e4.getHealth() - 1);
			// 		} else {
			// 		    e4.setDead(true);
			// 		    mcontainer.remove(i);
			// 		    Num_Enemies--;
			// 		    points(1000);
			// 		}
			// 	    }
			// 	}
                        //     }
                        // }
			Enemy5 e5 = (Enemy5) enemy101;
			if(!e5.deceased()){
			    if(!m.deceased()){ //otherwise same missile will kill repeatedly
				Rectangle r5 = e5.getArea();
				if (r1.intersects(r5)) {
				    m.setDead(true);	
				    if(e5.getHealth() > 0){
					mcontainer.remove(i);
					e5.setHealth(e5.getHealth() - 1);
				    } else {
					e5.setDead(true);
					mcontainer.remove(i);
					Num_Enemies--;
					points(10000);
				    }
				}
			    }
			}
                    } else {
                        mcontainer.remove(i); //if offscreen, delete missile
                    }
                }
            } else { //if dead remove all missiles
                for(int i = 0; i < mcontainer.size(); i++) {
                    mcontainer.remove(i);
                }
                if(Lives > 1){
                    Lives--;
                    Level = 0.5;
		    if(hlevel == 10.0){
			Num_Enemies = 17;
			ship10.resetCoor();
			ship10.setDead(false);
			ship10.resetMissiles();
			for(int i = 0;i<E10array.length;i++){
			    E10array[i].setDead(false);
			    E10array[i].resetMissiles();
			}
			// for(int n = 0;n<E29array.length;n++){
			//     E29array[n].setDead(false);
			//     E29array[n].resetMissiles();
			// }
			// for(int j = 0;j<E39array.length;j++){
			//     E39array[j].setDead(false);
			//     E39array[j].resetMissiles();
			// }
			// for(int k = 0;k<E49array.length;k++){
			//     E49array[k].setDead(false);
			//     E49array[k].resetMissiles();
			// }
			enemy101.setDead(false);
			enemy101.resetMissiles();
		    }
                    return; //exits the actionPerformed method
                }else{
                    Level = 1000; //end
		    ship10.resetCoor();
                    ship10.setDead(false);
                    ship10.resetMissiles();
                    // for(int i = 0;i<E9array.length;i++){
		    // 	E9array[i].setDead(false);
		    // 	E9array[i].resetMissiles();
                    // }
		    // for(int n = 0;n<E29array.length;n++){
		    // 	E29array[n].setDead(false);
		    // 	E29array[n].resetMissiles();
		    // 	}
		    // for(int j = 0;j<E39array.length;j++){
		    // 	E39array[j].setDead(false);
		    // 	E39array[j].resetMissiles();
                    // }
		    // for(int k = 0;k<E49array.length;k++){
		    // 	E49array[k].setDead(false);
		    // 	E49array[k].resetMissiles();
		    // }
		    enemy101.setDead(false);
		    enemy101.resetMissiles();
                    return;
                }
            }
            ArrayList m10container = new ArrayList(); //arraylist m1container is for the missiles
            for(int i = 0;i<E10array.length;i++) { //for each in enemy array
	    	for(int j = 0;j<E10array[i].getMissiles().size();j++){ //for each missile in each enemy
	    	    MissileB m1 = (MissileB)E10array[i].getMissiles().get(j); //Missile m1 equals that missile
	    	    if(m1.isVisible()){ //if is visible
	    		m10container.add(E10array[i].getMissiles().get(j)); //add that missile to the missile container
	    	    }else{
	    		E10array[i].getMissiles().remove(j); //remove the hidden missile
	    	    }
	    	}
            }
            for (int i = 0; i < m10container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m10container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship10; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m10container.remove(i); //remove missile
                    }
                }  
            }
	    // ArrayList m29container = new ArrayList(); //arraylist m1container is for the missiles
            // for(int i = 0;i<E29array.length;i++) { //for each in enemy array
	    // 	for(int j = 0;j<E29array[i].getMissiles().size();j++){ //for each missile in each enemy
	    // 	    MissileB m1 = (MissileB)E29array[i].getMissiles().get(j); //Missile m1 equals that missile
	    // 	    if(m1.isVisible()){ //if is visible
	    // 		m29container.add(E29array[i].getMissiles().get(j)); //add that missile to the missile container
	    // 	    }else{
	    // 		E29array[i].getMissiles().remove(j); //remove the hidden missile
	    // 	    }
	    // 	}
            // }
            // for (int i = 0; i < m29container.size(); i++) { //for each in enemy missile container
            //     MissileB m1 = (MissileB) m29container.get(i); //m1 equals current missile
            //     m1.move1();      //basically, for each missile, if onscreen, move
            //     Rectangle r1 = m1.getArea(); //area defined
            //     Ship s = (Ship)ship9; //ship shortened
            //     if(!s.deceased()){ //if ship isn't already dead
            //         Rectangle r2 = s.getArea(); //r2 is it's area
            //         if (r1.intersects(r2)) { //if missile is within range
            //             m1.setDead(true); //missile dead
            //             s.setDead(true); //ship dead
            //             m29container.remove(i); //remove missile
            //         }
            //     }  
            // }
	    // ArrayList m39container = new ArrayList(); //arraylist m1container is for the missiles
            // for(int i = 0;i<E39array.length;i++) { //for each in enemy array
	    // 	for(int j = 0;j<E39array[i].getMissiles().size();j++){ //for each missile in each enemy
	    // 	    MissileB3 m1 = (MissileB3)E39array[i].getMissiles().get(j); //Missile m1 equals that missile
	    // 	    if(m1.isVisible()){ //if is visible
	    // 		m39container.add(E39array[i].getMissiles().get(j)); //add that missile to the missile container
	    // 	    }else{
	    // 		E39array[i].getMissiles().remove(j); //remove the hidden missile
	    // 	    }
	    // 	}
            // }
            // for (int i = 0; i < m39container.size(); i++) { //for each in enemy missile container
            //     MissileB3 m1 = (MissileB3) m39container.get(i); //m1 equals current missile
            //     m1.move1();      //basically, for each missile, if onscreen, move
            //     Rectangle r1 = m1.getArea(); //area defined
            //     Ship s = (Ship)ship9; //ship shortened
            //     if(!s.deceased()){ //if ship isn't already dead
            //         Rectangle r2 = s.getArea(); //r2 is it's area
            //         if (r1.intersects(r2)) { //if missile is within range
            //             m1.setDead(true); //missile dead
            //             s.setDead(true); //ship dead
            //             m39container.remove(i); //remove missile
            //         }
            //     }  
            // }
	    // ArrayList m49container = new ArrayList(); //arraylist m1container is for the missiles
            // for(int i = 0;i<E49array.length;i++) { //for each in enemy array
	    // 	for(int j = 0;j<E49array[i].getMissiles().size();j++){ //for each missile in each enemy
	    // 	    MissileB4 m1 = (MissileB4)E49array[i].getMissiles().get(j); //Missile m1 equals that missile
	    // 	    if(m1.isVisible()){ //if is visible
	    // 		m49container.add(E49array[i].getMissiles().get(j)); //add that missile to the missile container
	    // 	    }else{
	    // 		E49array[i].getMissiles().remove(j); //remove the hidden missile
	    // 	    }
	    // 	}
            // }
            // for (int i = 0; i < m49container.size(); i++) { //for each in enemy missile container
            //     MissileB4 m1 = (MissileB4) m49container.get(i); //m1 equals current missile
            //     m1.move1();      //basically, for each missile, if onscreen, move
            //     Rectangle r1 = m1.getArea(); //area defined
            //     Ship s = (Ship)ship9; //ship shortened
            //     if(!s.deceased()){ //if ship isn't already dead
            //         Rectangle r2 = s.getArea(); //r2 is it's area
            //         if (r1.intersects(r2)) { //if missile is within range
            //             m1.setDead(true); //missile dead
            //             s.setDead(true); //ship dead
            //             m49container.remove(i); //remove missile
            //         }
            //     }  
            // }
	    //Boss missile containers
	    ArrayList m51container = new ArrayList(); //arraylist m1container is for the missiles
	    for(int j = 0;j<enemy101.getMissiles1().size();j++){ //for each missile in each enemy
		MissileB m1 = (MissileB)enemy101.getMissiles1().get(j); //Missile m1 equals that missile
		if(m1.isVisible()){ //if is visible
		    m51container.add(enemy101.getMissiles1().get(j)); //add that missile to the missile container
		}else{
		    enemy101.getMissiles1().remove(j); //remove the hidden missile
		}
	    }
            for (int i = 0; i < m51container.size(); i++) { //for each in enemy missile container
                MissileB m1 = (MissileB) m51container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship10; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m51container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m53container = new ArrayList(); //arraylist m1container is for the missiles
	    for(int j = 0;j<enemy101.getMissiles3().size();j++){ //for each missile in each enemy
		MissileB3 m1 = (MissileB3)enemy101.getMissiles3().get(j); //Missile m1 equals that missile
		if(m1.isVisible()){ //if is visible
		    m53container.add(enemy101.getMissiles3().get(j)); //add that missile to the missile container
		}else{
		    enemy101.getMissiles3().remove(j); //remove the hidden missile
		}
	    }
            for (int i = 0; i < m53container.size(); i++) { //for each in enemy missile container
                MissileB3 m1 = (MissileB3) m53container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship10; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m53container.remove(i); //remove missile
                    }
                }  
            }
	    ArrayList m54container = new ArrayList(); //arraylist m1container is for the missiles
	    for(int j = 0;j<enemy101.getMissiles4().size();j++){ //for each missile in each enemy
		MissileB4 m1 = (MissileB4)enemy101.getMissiles4().get(j); //Missile m1 equals that missile
		if(m1.isVisible()){ //if is visible
		    m54container.add(enemy101.getMissiles4().get(j)); //add that missile to the missile container
		}else{
		    enemy101.getMissiles4().remove(j); //remove the hidden missile
		}
	    }
            for (int i = 0; i < m54container.size(); i++) { //for each in enemy missile container
                MissileB4 m1 = (MissileB4) m54container.get(i); //m1 equals current missile
                m1.move1();      //basically, for each missile, if onscreen, move
                Rectangle r1 = m1.getArea(); //area defined
                Ship s = (Ship)ship10; //ship shortened
                if(!s.deceased()){ //if ship isn't already dead
                    Rectangle r2 = s.getArea(); //r2 is it's area
                    if (r1.intersects(r2)) { //if missile is within range
                        m1.setDead(true); //missile dead
                        s.setDead(true); //ship dead
                        m54container.remove(i); //remove missile
                    }
                }  
            }
            if(!ship10.deceased()){
                ship10.move(); //tells ship to move
            }
            for(int i = 0;i<E10array.length;i++) {
                if(!E10array[i].deceased()){
                    E10array[i].move(); //tells enemy to move
                }
            }
	    // for(int k = 0;k<E29array.length;k++) {
            //     if(!E29array[k].deceased()){
            //         E29array[k].move(); //tells enemy to move
            //     }
            // }
	    // for(int j = 0;j<E39array.length;j++) {
            //     if(!E39array[j].deceased()){
            //         E39array[j].move(); //tells enemy to move
            //     }
            // }
	    // for(int n = 0;n<E49array.length;n++) {
            //     if(!E49array[n].deceased()){
            //         E49array[n].move(); //tells enemy to move
            //     }
            // }
	    if(!enemy101.deceased()){
		enemy101.move(); //tells enemy to move
            }
	    if(Num_Enemies == 0){
		ship10.setDead(true);
		Level = 1000;
		win = true;
		hlevel = 11.0;
		points(100000);
		points(Lives * 1000000);
	    }
        }
        repaint(); //paints over previous
    }

    // private void drawString(Graphics g, String text, int x, int y) {
    //     for (String line : text.split("\n"))
    //         g.drawString(line, x, y += g.getFontMetrics().getHeight());
    // }

    //End of level gives bonus + (Lives * some amount)
    //Killing Enemy1's gives 10, Enemy2's gives 50

    private void points(int i){ //first in arraylist of #343486 is 6 and it will print on end
	int k = (i+"").length(); //k = length of int being added
	while(k > Score.size()) {
	    Score.add(0);
	}
	for(int j = 0;j<k;j++){ //for each number in int
	    int n = Score.get(j) + (i%10); //n = number trying to be added to place j
	    if (n >= 10.0) { //if number is >= 10
		Score.set(j, n%10); //replace the number with remainder
		if(((int)((n-n%10) * (Math.pow(10,j)))+"").length() > Score.size()) { //if it's bigger than Score's current size (int so no decimal)
		    Score.add(0); //add another 0
		}
		points((int)(((n-n%10)) * (Math.pow(10,j)))); //add part without remainder again. 
	    } else { //                                             otherwise,
		Score.set(j, Score.get(j) + (i%10)); //just replace number with that number + the end number
	    }
	    i = (i - (i%10))/10; //i is reduced an int once
	}
    }	
    
    private class TAdapter extends KeyAdapter { //class within which to set keyboard commands

        public void keyReleased(KeyEvent e) {
            if(Level == 1.0) {
                ship.keyReleased(e);
            }
	    if(Level == 2.0) {
                ship2.keyReleased(e);
            }
	    if(Level == 3.0) {
                ship3.keyReleased(e);
            }
	    if(Level == 4.0) {
                ship4.keyReleased(e);
            }
	    if(Level == 5.0) {
                ship5.keyReleased(e);
            }
	    if(Level == 6.0) {
                ship6.keyReleased(e);
            }
	    if(Level == 7.0) {
                ship7.keyReleased(e);
            }
	    if(Level == 8.0) {
                ship8.keyReleased(e);
            }
	    if(Level == 9.0) {
                ship9.keyReleased(e);
            }
	    if(Level == 10.0) {
                ship10.keyReleased(e);
            }
            if(Level == 0.0 || Level == 1000){
		start.keyPressed(e);//only starts when space key is released
	    }
        }

        public void keyPressed(KeyEvent e) {
            if(Level == 1.0){ //so that it won't fire when game is started. 
            ship.keyPressed(e);
	    }	
	    if(Level == 2.0) { 
            ship2.keyPressed(e);
            }
	    if(Level == 3.0) { 
            ship3.keyPressed(e);
            }
	    if(Level == 4.0) { 
            ship4.keyPressed(e);
            }
	    if(Level == 5.0) { 
            ship5.keyPressed(e);
            }
	    if(Level == 6.0) { 
            ship6.keyPressed(e);
            }
	    if(Level == 7.0) { 
            ship7.keyPressed(e);
            }
	    if(Level == 8.0) { 
            ship8.keyPressed(e);
            }
	    if(Level == 9.0) { 
            ship9.keyPressed(e);
            }
	    if(Level == 10.0) { 
            ship10.keyPressed(e);
            }
	}
    }
}