package PacHuman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author linds
 *
 */
public class PacHumanGame extends JPanel implements ActionListener, KeyListener {

	private Walls onlyWall;
	MonsterEnergyDrink[] drinks = new MonsterEnergyDrink[4];
	int CageLocation = 275;
	// A Timer that gets called every x milliseconds on the Panel.
	private Timer t = new Timer(30, this);

	// 1 = left, 2 = right, 3 = up, 4 = down
	private int directionMoving = 0;

	private PacHuman pacHuman = new PacHuman("left.png", "right.png", "up.png", "down.png", 335, 350, 30, 30);
	private Bat bat1, bat2, bat3, bat4;

	private Candy[] candies = new Candy[120];
	private boolean[] isCandyVisible = new boolean[120];
	//	New
	int candyRemaining = 120;

	private boolean[] isMonsterVisible = new boolean[4];
	private int genericSize = 50;
	//private int genericSize = 30;

	//private int currentScore = 0;
	private int score;
	private double countOfTimerCalls = 0;
	//private int lives = 3;
	private int lives;
	//	Issue with like -78 lives if not this:
	private boolean checkBatsAgain = true;
	private int batSpeed;

	public PacHumanGame(int width, int height, Color bgColor, int batSpeed, int score, int lives) {
		//System.out.println(batSpeed);
		this.batSpeed = batSpeed;
		this.score = score;
		this.lives = lives;
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor);

		// The 3 things below are needed for keyboard input.
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		// Walls:
		onlyWall = new Walls(50, 50, 100, 50);

		//	The +2 is causing issues for checking the walls, x-value needs to be divisible by 5 if moving 5 pixels at a time
		//bat1 = new Bat("bat1.png", CageLocation + 2, CageLocation);
		bat1 = new Bat("Bat1Cropped.png", CageLocation+5, CageLocation+5);
		//bat2 = new Bat("bat2.png", CageLocation + genericSize + 2, CageLocation);
		bat2 = new Bat("Bat2Cropped.png", CageLocation + genericSize+5, CageLocation+5);
		//bat3 = new Bat("bat3.png", CageLocation + genericSize * 2 + 2, CageLocation);
		bat3 = new Bat("Bat3Cropped.png", CageLocation + genericSize * 2+5, CageLocation+5);
		//bat4 = new Bat("bat4.png", CageLocation + genericSize + 2, CageLocation + genericSize / 2);
		//bat4 = new Bat("Bat4Cropped.png", CageLocation + genericSize, CageLocation + genericSize / 2);
		bat4 = new Bat("Bat4Cropped.png", CageLocation + genericSize+5, CageLocation + genericSize / 2 + 15);

		// Top row on left:
		for (int index = 0; index < 6; index++) {
			candies[index] = new Candy("candy.png", 50 + index * 50, 10);
		}
		// Top row on right:
		// 6
		for (int index = 0; index < 6; index++) {
			// Adding the amount from the previous array to the index isn't the best
			// solution, but I can't think of a better one.
			candies[index + 6] = new Candy("candy.png", 370 + index * 50, 10);
		}
		// Single one on left:
		candies[12] = new Candy("candy.png", 0, 60);
		// Single one left-middle:
		candies[13] = new Candy("candy.png", 150, 60);
		// Single one very middle left:
		candies[14] = new Candy("candy.png", 300, 60);
		// Single one very middle right:
		candies[15] = new Candy("candy.png", 370, 60);
		// Single one right-middle
		candies[16] = new Candy("candy.png", 520, 60);
		// Single one on right:
		candies[17] = new Candy("candy.png", 670, 60);

		//	MAYBE ERROR HERE?!
		// Yay! A full third row that can just use a for-loop:
		for (int index = 0; index < 15; index++) {
			candies[index + 18] = new Candy("candy.png", index * 50, 110);
		}
		// 32
		// Fourth row leftmost:
		// Darn, spacing issues
		for (int index = 0; index < 4; index++) {
			candies[index + 32] = new Candy("candy.png", index * 50, 180);
		}
		// 36
		// Fourth row left weird wall
		for (int index = 0; index < 2; index++) {
			candies[index + 36] = new Candy("candy.png", 220 + index * 50, 180);
		}
		// 38
		// Fourth row right weird wall
		for (int index = 0; index < 2; index++) {
			candies[index + 38] = new Candy("candy.png", 390 + index * 50, 180);
		}
		// 40
		// Fourth row rightmost:
		for (int index = 0; index < 4; index++) {
			candies[index + 40] = new Candy("candy.png", 520 + index * 50, 180);
		}
		// 44
		// Fifth row single on left
		candies[44] = new Candy("candy.png", 150, 240);
		// Fifth row middle bit:
		for (int index = 0; index < 5; index++) {
			candies[index + 45] = new Candy("candy.png", 230 + index * 50, 240);
		}
		// 50
		// Fifth row single on right
		candies[50] = new Candy("candy.png", 520, 240);
		// Sixth row left of Ghost Box:
		for (int index = 0; index < 5; index++) {
			candies[index + 51] = new Candy("candy.png", 20 + index * 50, 310);
		}
		// 56
		// Sixth row right of Ghost Box:
		for (int index = 0; index < 5; index++) {
			candies[index + 56] = new Candy("candy.png", 450 + index * 50, 310);
		}
		// 61
		// Seventh row single on left:
		candies[61] = new Candy("candy.png", 160, 370);
		// 62
		// Seventh row middle bit:
		for (int index = 0; index < 5; index++) {
			candies[index + 62] = new Candy("candy.png", 230 + index * 50, 370);
		}
		// 67
		// Seventh row single on right:
		candies[67] = new Candy("candy.png", 510, 370);
		// Eighth row left of "T":
		for (int index = 0; index < 7; index++) {
			candies[index + 68] = new Candy("candy.png", index * 50, 440);
		}
		// 75
		// Eighth row right of "T":
		for (int index = 0; index < 7; index++) {
			candies[index + 75] = new Candy("candy.png", 370 + index * 50, 440);
		}
		// 82
		// Ninth row left of "L":
		for (int index = 0; index < 3; index++) {
			candies[index + 82] = new Candy("candy.png", index * 50, 510);
		}
		// 85
		// Ninth row middle bit:
		for (int index = 0; index < 8; index++) {
			candies[index + 85] = new Candy("candy.png", 160 + index * 50, 510);
		}
		// 93
		// Ninth row right of "L":
		for (int index = 0; index < 3; index++) {
			candies[index + 93] = new Candy("candy.png", 570 + index * 50, 510);
		}
		// 96
		// Tenth row left of weird walls:
		for (int index = 0; index < 4; index++) {
			candies[index + 96] = new Candy("candy.png", 10 + index * 50, 580);
		}
		// 100
		// Tenth row left-middle of weird walls:
		for (int index = 0; index < 2; index++) {
			candies[index + 100] = new Candy("candy.png", 240 + index * 50, 580);
		}
		// 102
		// Tenth row right-middle of weird walls:
		for (int index = 0; index < 2; index++) {
			candies[index + 102] = new Candy("candy.png", 380 + index * 50, 580);
		}
		// 104
		// Tenth row right of weird walls:
		for (int index = 0; index < 4; index++) {
			candies[index + 104] = new Candy("candy.png", 510 + index * 50, 580);
		}
		// 108
		// Eleventh full row, but minus left and right for Monster:
		for (int index = 0; index < 12; index++) {
			candies[index + 108] = new Candy("candy.png", 60 + index * 50, 650);
		}

		drinks[0] = new MonsterEnergyDrink("ultra.png", 0, 0);
		drinks[1] = new MonsterEnergyDrink("ultra.png", 650, 0);
		drinks[2] = new MonsterEnergyDrink("ultra.png", 0, 670);
		drinks[3] = new MonsterEnergyDrink("ultra.png", 650, 670);

		for (int index = 0; index < isCandyVisible.length; index++) {
			isCandyVisible[index] = true;
		}
		for (int index = 0; index < isMonsterVisible.length; index++) {
			isMonsterVisible[index] = true;
		}
		// Starts the Timer
		t.start();
	}

	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g = (Graphics2D) arg0;
		for (int index = 0; index < onlyWall.setWalls().length; index++) {
			Walls wallArray[] = onlyWall.setWalls();
			wallArray[index].draw(g);
			onlyWall.draw(g);
		}

		for (int index = 0; index < candies.length; index++) {
			if (isCandyVisible[index] == true) {
				g.drawImage(candies[index].getCandy(), candies[index].getLeftSide(), candies[index].getTopSide(), this);
			}
		}
		for (int index = 0; index < drinks.length; index++) {
			if (isMonsterVisible[index] == true) {
				g.drawImage(drinks[index].getMonsterEnergyDrink(), drinks[index].getLeftSide(),
						drinks[index].getTopSide(), this);
			}
		}
		g.drawImage(bat1.getBat(), bat1.getBatX(), bat1.getBatY(), this);
		g.drawImage(bat2.getBat(), bat2.getBatX(), bat2.getBatY(), this);
		g.drawImage(bat3.getBat(), bat3.getBatX(), bat3.getBatY(), this);
		g.drawImage(bat4.getBat(), bat4.getBatX(), bat4.getBatY(), this);
		pacHuman.setCurrentImage(directionMoving);
		g.drawImage(pacHuman.getCurrentImage(), pacHuman.getLeftSide(), pacHuman.getTopSide(), this);
		repaint();
	}
	/**
	 * This would have a counter that, when it reaches 167 or whatever, lets the
	 * first bat come out
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		countOfTimerCalls++;
		if (countOfTimerCalls % 168 == 0) {
			
			//	Issue with like -78 lives if not this:
			checkBatsAgain = true;
			
			if (bat1.isInCage()) {
				//bat1.setBatY(bat1.getBatY() - genericSize);
				bat1.setBatY(bat1.getBatY() - genericSize/2-5);
				//bat1.setBatX(bat1.getBatX() + genericSize);
				bat1.setBatX(bat1.getBatX() + genericSize/2+5);
				bat1.setInCage(false);
				
				bat1.setDirection(1);
				
			} else if (bat2.isInCage()) {
				//bat2.setBatY(bat2.getBatY() - genericSize);
				bat2.setBatY(bat2.getBatY() - genericSize/2-5);
				bat2.setInCage(false);
				
				bat2.setDirection(1);
				
			} else if (bat3.isInCage()) {
				//bat3.setBatY(bat3.getBatY() - genericSize);
				bat3.setBatY(bat3.getBatY() - genericSize/2-5);
				//bat3.setBatX(bat3.getBatX() - genericSize);
				bat3.setBatX(bat3.getBatX() - genericSize/2-5);
				bat3.setInCage(false);
				
				bat3.setDirection(1);
				
			} else if (bat4.isInCage()) {
				//bat4.setBatY(bat4.getBatY() - genericSize * 1/2);
				//bat4.setBatY((bat4.getBatY() - genericSize * 3/2));
				//bat4.setBatY((bat4.getBatY() - genericSize));
				bat4.setBatY((bat4.getBatY() - genericSize - 15));
				bat4.setInCage(false);
				
				bat4.setDirection(1);
				
			}
			//	Ocasional random direction change when not bumping into wall
			/*else 
			{
				//bat1.setDirection((int)(Math.random()*4+1));
				//bat2.setDirection((int)(Math.random()*4+1));
				//bat3.setDirection((int)(Math.random()*4+1));
				//bat4.setDirection((int)(Math.random()*4+1));
				int tempDirection = ((int)(Math.random()*2));
				if (tempDirection == 0)
				{
					tempDirection = 1;
				}
				else
				{
					tempDirection = 3;
				}
				int newDirection;
				newDirection = bat1.getDirection()+tempDirection;
				if (newDirection > 4)
				{
					newDirection = newDirection - 4;
				}
				bat1.setDirection(newDirection);
				bat2.setDirection(newDirection);
				bat3.setDirection(newDirection);
				bat4.setDirection(newDirection);
			}*/
		}
		// Checks if Walls are impeding PacHuman's movement
		checkWalls();
		// Checks to see if PacHuman is touching candy, increases score by 10 and makes
		// candy invisible if so.
		if (directionMoving > 0) {
			checkCandy();
			checkMonster();
			checkBats();
		}
	}

	public void checkWalls() {
		Walls wallArray[] = onlyWall.setWalls();
		pacHuman.checkWalls(wallArray);
		if (bat1.isInCage() == false) {
			//bat1.checkWalls(wallArray, (int) (Math.random() * 3 + 1));
			bat1.checkWalls(wallArray, bat1.getDirection(), batSpeed);
		}
		if (bat2.isInCage() == false) {
			//bat2.checkWalls(wallArray, (int) (Math.random() * 3 + 1));
			bat2.checkWalls(wallArray, bat2.getDirection(), batSpeed);
		}
		if (bat3.isInCage() == false) {
			//bat3.checkWalls(wallArray, (int) (Math.random() * 3 + 1));
			bat3.checkWalls(wallArray, bat3.getDirection(), batSpeed);
			
		}
		if (bat4.isInCage() == false) {
			//bat4.checkWalls(wallArray, (int) (Math.random() * 3 + 1));
			bat4.checkWalls(wallArray, bat4.getDirection(), batSpeed);
		}
		repaint();
	}

	public void checkCandy() {
		for (int index = 0; index < candies.length; index++) {
			if (pacHuman.getRightSide() >= candies[index].getLeftSide()
					&& pacHuman.getLeftSide() <= candies[index].getRightSide()
					&& pacHuman.getTopSide() <= candies[index].getBottomSide()
					&& pacHuman.getBottomSide() >= candies[index].getTopSide() && isCandyVisible[index] == true) {
				isCandyVisible[index] = false;
				//currentScore = currentScore + 10;
				score = score + 10;
				//PacStore.setTitle(currentScore, lives);
				PacStore.setTitle(score, lives);
				
				candyRemaining--;
			}
		}
		
		if (candyRemaining == 0)
		{
			//checkBatsAgain = false;
			candyRemaining = 120;
			PacStore.pacHumanGameFrame.setVisible(false);
			PacStore.pacHumanGamePanel.setVisible(false);
			PacStore pacStore = new PacStore();
			pacStore.PanelExample(batSpeed+1, score, lives);
			//pacStore.PanelExample(batSpeed+1 + score + lives, CageLocation, CageLocation);
			//	Doesn't work, but the going back to store code above restarts the game with a faster bat speed,
			//	there is just the store in-between the game levels :(
			//new PacHumanGame(700, 700, Color.black, batSpeed+1);

		}
	}

	public void checkMonster() {
		for (int index = 0; index < drinks.length; index++) {
			if (pacHuman.getRightSide() >= drinks[index].getLeftSide()
					&& pacHuman.getLeftSide() <= drinks[index].getRightSide()
					&& pacHuman.getTopSide() <= drinks[index].getBottomSide()
					&& pacHuman.getBottomSide() >= drinks[index].getTopSide() && isMonsterVisible[index] == true) {
				isMonsterVisible[index] = false;
				score = score + 50;
				PacStore.setTitle(score, lives);
			}
		}
	}
	
	
	
	/**
	 * Uncomment the line at the bottom to quickly see how the batSpeed change works by dying a lot and seeing it.
	 */
	public void checkBats()
	{
			if (
					(pacHuman.getRightSide() >= bat1.getLeftSide()
					&& pacHuman.getLeftSide() <= bat1.getRightSide()
					&& pacHuman.getTopSide() <= bat1.getBottomSide()
					&& pacHuman.getBottomSide() >= bat1.getTopSide())
					||
					(pacHuman.getRightSide() >= bat2.getLeftSide()
					&& pacHuman.getLeftSide() <= bat2.getRightSide()
					&& pacHuman.getTopSide() <= bat2.getBottomSide()
					&& pacHuman.getBottomSide() >= bat2.getTopSide())
					||
					(pacHuman.getRightSide() >= bat3.getLeftSide()
					&& pacHuman.getLeftSide() <= bat3.getRightSide()
					&& pacHuman.getTopSide() <= bat3.getBottomSide()
					&& pacHuman.getBottomSide() >= bat3.getTopSide())
					||
					(pacHuman.getRightSide() >= bat4.getLeftSide()
					&& pacHuman.getLeftSide() <= bat4.getRightSide()
					&& pacHuman.getTopSide() <= bat4.getBottomSide()
					&& pacHuman.getBottomSide() >= bat4.getTopSide())
				)
			{
				checkBatsAgain = false;
				lives = lives - 1;
				PacStore.setTitle(score, lives);
				pacHuman.setX(335);
				pacHuman.setY(350);
				pacHuman.setDirection(0);
				
				//	New code for returning to store if game over:
				if (lives == 0)
				{
					PacStore.pacHumanGameFrame.setVisible(false);
					PacStore.pacHumanGamePanel.setVisible(false);
					PacStore pacStore = new PacStore();
					score = 0;
					lives = 3;
				
					pacStore.PanelExample(batSpeed, score, lives);
					//pacStore.PanelExample(batSpeed + 1);
				}
			}
	}

	/**
	 * The only one that will do things:
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		// Change to an integer for each direction
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_LEFT) {
			directionMoving = 1;
		}
		if (code == KeyEvent.VK_RIGHT) {
			directionMoving = 2;
		}
		if (code == KeyEvent.VK_UP) {
			directionMoving = 3;
		}
		if (code == KeyEvent.VK_DOWN) {
			directionMoving = 4;
		}
		pacHuman.setCurrentImage(directionMoving);
		pacHuman.setDirection(directionMoving);
	}

	/**
	 * Does nothing, PacHuman moves continuously
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Does nothing
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
