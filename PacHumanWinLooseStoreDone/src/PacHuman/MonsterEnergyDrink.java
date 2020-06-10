package PacHuman;

import java.awt.image.BufferedImage;

public class MonsterEnergyDrink extends Images {

	private BufferedImage MonsterEnergyDrink;
	private int size = 30;
	private int xMonster, yMonster;
	MonsterEnergyDrink[] drinks = new MonsterEnergyDrink[3];

	public BufferedImage getMonsterEnergyDrink() {
		return MonsterEnergyDrink;
	}

	public void setMonsterEnergyDrink(BufferedImage monsterEnergyDrink) {
		MonsterEnergyDrink = monsterEnergyDrink;
	}

	public MonsterEnergyDrink(String classPathInputMonsterEnergyDrink, int xMonster, int yMonster) {
		MonsterEnergyDrink = resizeImage(getImageInfo(classPathInputMonsterEnergyDrink), size, size);
		this.xMonster = xMonster;
		this.yMonster = yMonster;

	}

	public MonsterEnergyDrink[] setDrinks() {
		drinks[0] = new MonsterEnergyDrink("ultra.png", 650, 0);
		drinks[1] = new MonsterEnergyDrink("ultra.png", 0, 670);
		drinks[2] = new MonsterEnergyDrink("ultra.png", 650, 670);
		return drinks;
	}

	public int getLeftSide() {
		return xMonster;
	}

	public int getRightSide() {
		return xMonster + size;
	}

	public int getTopSide() {
		return yMonster;
	}

	public int getBottomSide() {
		return yMonster + size;
	}

}
