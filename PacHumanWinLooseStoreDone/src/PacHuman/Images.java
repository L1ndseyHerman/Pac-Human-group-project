package PacHuman;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Images {

	private BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	public BufferedImage getImageInfo(String imagePath) {
		try {
			File classPathInput = new File(PacHumanGame.class.getResource(imagePath).getFile());
			return ImageIO.read(classPathInput);
		} catch (IOException ex) {
			return null;
		}
	}

	public BufferedImage resizeImage(BufferedImage imageToResize, int height, int width) {
		return resize(imageToResize, width, height);
	}
	// set visibility
	// check visibility
}
