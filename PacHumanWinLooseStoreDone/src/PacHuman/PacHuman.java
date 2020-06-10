package PacHuman;

import java.awt.image.BufferedImage;

public class PacHuman extends Images {
	private int size = 30;

	private BufferedImage leftPH;
	private BufferedImage rightPH;
	private BufferedImage upPH;
	private BufferedImage downPH;
	private BufferedImage currentImage = leftPH;

	private int direction;

	private int pacHumanX, pacHumanY, pacHumanWidth, pacHumanHeight;

	// private int pacHumanX = 335, pacHumanY = 350, pacHumanWidth = 30,
	// pacHumanHeight = 30;

	// Sets all the Images to the right variable for use later.
	public PacHuman(String classPathInputLeft, String classPathInputRight, String classPathInputUp,
			String classPathInputDown, int pacHumanX, int pacHumanY, int pacHumanWidth, int pacHumanHeight) {

		this.leftPH = resizeImage(getImageInfo(classPathInputLeft), size, size);
		this.rightPH = resizeImage(getImageInfo(classPathInputRight), size, size);
		this.upPH = resizeImage(getImageInfo(classPathInputUp), size, size);
		this.downPH = resizeImage(getImageInfo(classPathInputDown), size, size);

		this.pacHumanX = pacHumanX;
		this.pacHumanY = pacHumanY;
		this.pacHumanWidth = pacHumanWidth;
		this.pacHumanHeight = pacHumanHeight;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public BufferedImage getLeftPH() {
		return leftPH;
	}

	public void setLeftPH(BufferedImage leftPH) {
		this.leftPH = leftPH;
	}

	public BufferedImage getRightPH() {
		return rightPH;
	}

	public void setRightPH(BufferedImage rightPH) {
		this.rightPH = rightPH;
	}

	public BufferedImage getUpPH() {
		return upPH;
	}

	public void setUpPH(BufferedImage upPH) {
		this.upPH = upPH;
	}

	public BufferedImage getDownPH() {
		return downPH;
	}

	public void setDownPH(BufferedImage downPH) {
		this.downPH = downPH;
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(int direction) {
		if (direction == 1 || direction == 0) {
			this.currentImage = leftPH;
		} else if (direction == 2) {
			this.currentImage = rightPH;
		} else if (direction == 3) {
			this.currentImage = upPH;
		} else {
			this.currentImage = downPH;
		}

	}

	public void checkWalls(Walls wallArray[]) {
		if (direction == 1 && getLeftSide() >= 1) {
			boolean wallInWay = false;
			for (int index = 0; index < wallArray.length; index++) {
				if (getLeftSide() == wallArray[index].getRightSide() && getBottomSide() > wallArray[index].getTopSide()
						&& getTopSide() < wallArray[index].getBottomSide()) {
					wallInWay = true;
				}
			}

			if (wallInWay == false) {
				setX(getLeftSide() - 5);
			}

		} else if (direction == 2 && getRightSide() <= 699) {
			boolean wallInWay = false;
			for (int index = 0; index < wallArray.length; index++) {
				if (getRightSide() == wallArray[index].getLeftSide() && getBottomSide() > wallArray[index].getTopSide()
						&& getTopSide() < wallArray[index].getBottomSide()) {
					wallInWay = true;
				}
			}

			if (wallInWay == false) {
				setX(getLeftSide() + 5);
			}
		}

		else if (direction == 3 && getTopSide() >= 1) {
			boolean wallInWay = false;
			for (int index = 0; index < wallArray.length; index++) {
				if (getRightSide() > wallArray[index].getLeftSide() && getLeftSide() < wallArray[index].getRightSide()
						&& getTopSide() <= wallArray[index].getBottomSide()
						&& getTopSide() > wallArray[index].getTopSide()) {
					wallInWay = true;
				}
			}
			if (wallInWay == false) {
				setY(getTopSide() - 5);
			}
		}

		else if (direction == 4 && getBottomSide() <= 699) {
			boolean wallInWay = false;
			for (int index = 0; index < wallArray.length; index++) {
				if (getBottomSide() == wallArray[index].getTopSide() && getRightSide() > wallArray[index].getLeftSide()
						&& getLeftSide() < wallArray[index].getRightSide()) {
					wallInWay = true;
				}
			}
			if (wallInWay == false) {
				setY(getTopSide() + 5);
			}
		}
		// New portal code: Locations of walls by portal
		else if (direction == 1 && getLeftSide() < 1 && getTopSide() >= 300 && getBottomSide() <= 350) {
			// Screen width 700 - pacHumanWidth 30 = 670
			setX(670);
		} else if (direction == 2 && getRightSide() > 699 && getTopSide() >= 300 && getBottomSide() <= 350) {
			setX(0);
		}

	}

	public int getLeftSide() {
		return pacHumanX;
	}

	public int getRightSide() {
		return pacHumanX + pacHumanWidth;
	}

	public int getTopSide() {
		return pacHumanY;
	}

	public int getBottomSide() {
		return pacHumanY + pacHumanHeight;
	}

	public void setX(int pacHumanX) {
		this.pacHumanX = pacHumanX;
	}

	public void setY(int pacHumanY) {
		this.pacHumanY = pacHumanY;
	}

}
