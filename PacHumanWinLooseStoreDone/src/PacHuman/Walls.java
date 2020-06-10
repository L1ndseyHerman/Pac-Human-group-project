package PacHuman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * The Design-Phase Algebros mentioned a "Walls" class in PacHumanGame, but did
 * not create one. I decided to rename my Block class to "Walls".
 * 
 * @author linds
 *
 */
public class Walls {
	// public is fine here
	public Rectangle2D.Double theWall;
	public double xWall, yWall, sizeXWall, sizeYWall;
	Walls[] wallArray = new Walls[35];

	public Walls(double xWall, double yWall, double sizeXWall, double sizeYWall) {
		this.xWall = xWall;
		this.yWall = yWall;
		this.sizeXWall = sizeXWall;
		this.sizeYWall = sizeYWall;
		theWall = new Rectangle2D.Double(xWall, yWall, sizeXWall, sizeYWall);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.blue);
		// g.fill(theWall);
		g.draw(theWall);

		// To make look like a continuous shape, getting rid of the black outline for
		// each Wall
		// g.setColor(Color.black);
		// g.draw(theBlock);
	}

	public Walls[] setWalls() {
		// Left-middle first row
		wallArray[0] = new Walls(200, 50, 100, 50);
		// Middle different first row
		wallArray[1] = new Walls(340, 0, 20, 100);
		// Right-middle first row
		wallArray[2] = new Walls(400, 50, 100, 50);
		// Right first row
		wallArray[3] = new Walls(550, 50, 100, 50);
		// Left second row
		wallArray[4] = new Walls(50, 150, 100, 20);
		// up-down of 2-part pointing right
		wallArray[5] = new Walls(200, 150, 20, 150);
		// left-right of 2-part pointing right
		wallArray[6] = new Walls(220, 215, 75, 20);
		// left-right of 2-part pointing down
		wallArray[7] = new Walls(275, 150, 150, 20);
		// up-down of 2-part pointing down
		wallArray[8] = new Walls(340, 170, 20, 65);
		// up-down of 2-part pointing left
		wallArray[9] = new Walls(475, 150, 20, 150);
		// left-right of 2-part pointing left
		wallArray[10] = new Walls(400, 215, 75, 20);
		// Right second row
		wallArray[11] = new Walls(550, 150, 100, 20);
		// Wall above portal left
		wallArray[12] = new Walls(0, 225, 150, 75);
		// Wall above portal right
		wallArray[13] = new Walls(550, 225, 150, 75);
		// THE GHOST BOX!
		wallArray[14] = new Walls(275, 275, 150, 75);
		// Wall below portal left
		wallArray[15] = new Walls(0, 350, 150, 75);
		// Left-middle wall by Ghost Box
		wallArray[16] = new Walls(200, 350, 20, 75);
		// Right-middle wall by Ghost Box
		wallArray[17] = new Walls(475, 350, 20, 75);
		// Wall below portal right
		wallArray[18] = new Walls(550, 350, 150, 75);
		// Left-right of two-part pointing down
		wallArray[19] = new Walls(275, 405, 150, 20);
		// Up-down of two-part pointing down
		wallArray[20] = new Walls(340, 425, 20, 65);
		// Left-right of left "L"
		wallArray[21] = new Walls(70, 475, 80, 20);
		// Up-down of left "L"
		wallArray[22] = new Walls(130, 495, 20, 75);
		// Left-middle wall
		wallArray[23] = new Walls(200, 475, 85, 20);
		// Right-middle wall
		wallArray[24] = new Walls(410, 475, 85, 20);
		// Left-right of right "L"
		wallArray[25] = new Walls(550, 475, 80, 20);
		// Up-down of right "L"
		wallArray[26] = new Walls(550, 495, 20, 75);
		// Little wall on left
		wallArray[27] = new Walls(0, 550, 70, 20);
		// Little wall on right
		wallArray[28] = new Walls(630, 550, 70, 20);
		// Left-right of weird one on left
		wallArray[29] = new Walls(70, 620, 205, 20);
		// Up-down of weird one on left
		wallArray[30] = new Walls(200, 550, 20, 70);
		// Left-right of weird on in middle
		wallArray[31] = new Walls(275, 550, 150, 20);
		// Up-down of weird on in middle
		wallArray[32] = new Walls(340, 570, 20, 65);
		// Left-right of weird one on right
		wallArray[33] = new Walls(425, 620, 205, 20);
		// Up-down of weird one on right
		wallArray[34] = new Walls(475, 550, 20, 70);
		return wallArray;
	}

	public double getLeftSide() {
		return xWall;
	}

	public double getRightSide() {
		return xWall + sizeXWall;
	}

	public double getTopSide() {
		return yWall;
	}

	public double getBottomSide() {
		return yWall + sizeYWall;
	}
}
