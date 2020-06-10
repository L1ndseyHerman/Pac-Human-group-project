package PacHuman;

import java.awt.image.BufferedImage;

public class Candy extends Images {

	private BufferedImage candy;
	private int size = 30;
	private int xCandy, yCandy;

	public BufferedImage getCandy() {
		return candy;
	}

	public void setCandy(BufferedImage candy) {
		this.candy = candy;
	}

	public Candy(String classPathInputCandy, int xCandy, int yCandy) {
		this.candy = resizeImage(getImageInfo(classPathInputCandy), size, size);
		this.xCandy = xCandy;
		this.yCandy = yCandy;
	}

	public int getLeftSide() {
		return xCandy;
	}

	public int getRightSide() {
		return xCandy + size;
	}

	public int getTopSide() {
		return yCandy;
	}

	public int getBottomSide() {
		return yCandy + size;
	}

}
