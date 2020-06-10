package PacHuman;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PacStoreTesting extends JFrame {
	private JLabel lblDisplay, lblDisplay2, lblDisplay3;

	public PacStoreTesting() {
		// Search for it through all directories in the JAR
		java.net.URL imageURL = PacStoreTesting.class.getResource("pacHumanRightFloss.png");
		lblDisplay = new JLabel(new ImageIcon(imageURL));

		java.net.URL imageURL2 = PacStoreTesting.class.getResource("pacHumanRightSoldier.png");
		lblDisplay2 = new JLabel(new ImageIcon(imageURL2));

		java.net.URL imageURL3 = PacStoreTesting.class.getResource("pacHumanRightTopHat.png");
		lblDisplay3 = new JLabel(new ImageIcon(imageURL3));

		JPanel pan1 = new JPanel();
		pan1.add(lblDisplay);
		pan1.add(lblDisplay2);
		pan1.add(lblDisplay3);
		add(pan1, BorderLayout.CENTER);

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PacStoreTesting();

	}
}
