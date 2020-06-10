package PacHuman;

import java.awt.image.BufferedImage;

public class Bat extends Images {

	private BufferedImage bat;
	//private int size = 50;
	private int size = 30, direction = 0;
	private int batX, batY;

	private boolean inCage = true;

	public Bat(String classPathInputBat, int x, int y) {
		this.bat = resizeImage(getImageInfo(classPathInputBat), size, size);
		batX = x;
		batY = y;
	}

	public BufferedImage getBat() {
		return bat;
	}

	public void setBat(BufferedImage bat) {
		this.bat = bat;
	}

	public int getBatX() {
		return batX;
	}

	public void setBatX(int batX) {
		this.batX = batX;
	}

	public int getBatY() {
		return batY;
	}

	public void setBatY(int batY) {
		this.batY = batY;
	}

	public boolean isInCage() {
		return inCage;
	}

	public void setInCage(boolean inCage) {
		this.inCage = inCage;
	}

	public int getLeftSide() {
		return batX;
	}

	public int getRightSide() {
		return batX + size;
	}

	public int getTopSide() {
		return batY;
	}

	public int getBottomSide() {
		return batY + size;
	}
	
	
	
	
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	public int getDirection()
	{
		return direction;
	}

	public void checkWalls(Walls[] wallArray, int direction, int batSpeed) {
		if (inCage == false) {

			//if (direction == 1 && batX >= 1) {
			if (direction == 1) {
				boolean wallInWay = false;
				for (int index = 0; index < wallArray.length; index++) {
					if (batX-batSpeed <= wallArray[index].getRightSide() && batY + size > wallArray[index].getTopSide()
							&& batY < wallArray[index].getBottomSide() && batX-batSpeed + size > wallArray[index].getLeftSide()) {
						wallInWay = true;
					}
				}
				if (batX-batSpeed < 1)
				{
					wallInWay = true;
				}

				if (wallInWay == false) {
					setBatX(batX - batSpeed);
				}
				if (wallInWay == true)
				{
					int temporaryNumber = (int)(Math.random() * 2);
					if (temporaryNumber == 0)
					{
						//direction = 3;
						setDirection(3);
					}
					else 
					{
						//direction = 4;
						setDirection(4);
					}
				}

			} //else if (direction == 2 && batX + size <= 699) {
			else if (direction == 2) {
				boolean wallInWay = false;
				for (int index = 0; index < wallArray.length; index++) {
					if (batX+batSpeed + size >= wallArray[index].getLeftSide() && batY + size > wallArray[index].getTopSide()
							&& batY < wallArray[index].getBottomSide() && batX+batSpeed < wallArray[index].getRightSide()) {
						wallInWay = true;
					}
				}
				if (batX+batSpeed + size > 699)
				{
					wallInWay = true;
				}

				if (wallInWay == false) {
					setBatX(batX + batSpeed);
				}
				if (wallInWay == true)
				{
					int temporaryNumber = (int)(Math.random() * 2);
					if (temporaryNumber == 0)
					{
						//direction = 3;
						setDirection(3);
					}
					else 
					{
						//direction = 4;
						setDirection(4);
					}
				}
			}

			//else if (direction == 3 && batY >= 1) {
			else if (direction == 3) {
				boolean wallInWay = false;
				for (int index = 0; index < wallArray.length; index++) {
					if (batX + size > wallArray[index].getLeftSide() && batX < wallArray[index].getRightSide()
							&& batY-batSpeed <= wallArray[index].getBottomSide() && batY-batSpeed > wallArray[index].getTopSide()) {
						wallInWay = true;
					}
				}
				if (batY-batSpeed < 1)
				{
					wallInWay = true;
				}
				if (wallInWay == false) {
					setBatY(batY - batSpeed);
				}
				if (wallInWay == true)
				{
					int temporaryNumber = (int)(Math.random() * 2);
					if (temporaryNumber == 0)
					{
						//direction = 1;
						setDirection(1);
					}
					else 
					{
						//direction = 2;
						setDirection(2);
					}
				}
			}

			//else if (direction == 4 && batY + size <= 699) {
			else if (direction == 4) {
				boolean wallInWay = false;
				for (int index = 0; index < wallArray.length; index++) {
					/*if (batY + size == wallArray[index].getTopSide() && batX > wallArray[index].getLeftSide()
							&& batY < wallArray[index].getRightSide()) {
						wallInWay = true;
					}*/
					//batY-batSpeed <= wallArray[index].getBottomSide() && batY-batSpeed > wallArray[index].getTopSide()
					//if (batY+batSpeed + size == wallArray[index].getTopSide() && batX+size > wallArray[index].getLeftSide()
					if (batY+batSpeed + size >= wallArray[index].getTopSide() && batY+batSpeed < wallArray[index].getBottomSide()
						&& batX+size > wallArray[index].getLeftSide() && batX < wallArray[index].getRightSide()) {
						wallInWay = true;
					}
				}
				if (batY+batSpeed + size > 699)
				{
					wallInWay = true;
				}
				if (wallInWay == false) {
					setBatY(batY + batSpeed);
				}
				if (wallInWay == true)
				{
					int temporaryNumber = (int)(Math.random() * 2);
					if (temporaryNumber == 0)
					{
						//direction = 1;
						setDirection(1);
					}
					else 
					{
						//direction = 2;
						setDirection(2);
					}
				}
			}
			// New portal code: Locations of walls by portal
			else if (direction == 1 && batX-batSpeed < 1 && batY >= 300 && batY + size <= 350) {
				// Screen width 700 - pacHumanWidth 30 = 670
				setBatX(670);
			} else if (direction == 2 && batX+batSpeed + size > 699 && batY >= 300 && batY + size <= 350) {
				setBatX(0);
			}

		}

	}

}
