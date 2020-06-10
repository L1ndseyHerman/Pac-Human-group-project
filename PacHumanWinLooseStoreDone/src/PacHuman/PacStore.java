package PacHuman;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PacStore extends JFrame {

	static boolean skin1 = false;
	static boolean skin2 = false;
	static boolean skin3 = false;
	static boolean skin4 = false;
	static boolean skin5 = false;
	static boolean skin6 = false;

	static BufferedImage s1;
	static BufferedImage s2;
	static BufferedImage s3;

	private JLabel lblDisplay, lblDisplay2, lblDisplay3, lblDisplay4, lblDisplay5, lblDisplay6;


	static JFrame pacHumanGameFrame;
	//	Needs to be here for loosing game:
	static PacHumanGame pacHumanGamePanel;
	static JPanel panel;
	static JFrame f;
	static int batSpeed = 5;
	static int score = 0;
	static int lives = 3;

	public void PanelExample(int batSpeed, int score, int lives) {

		this.batSpeed = batSpeed;
		this.score = score;
		this.lives = lives;
		//JFrame f = new JFrame("Panel Example");
		f = new JFrame("Panel Example");
		
		//JPanel panel = new JPanel();
		panel = new JPanel();
		
		panel.setBounds(40, 80, 1000, 1000);
		panel.setBackground(Color.black);
		panel.setLayout(null);
		JButton b1 = new JButton("PlayHuman");
		b1.setBounds(300, 100, 100, 30);
		b1.setBackground(Color.cyan);
		//	This was saying: "Open RAD... 
		//	A larger button width fixes it.
		JButton b2 = new JButton("Open RADICAL Store");
		b2.setBounds(450, 100, 170, 30);
		b2.setBackground(Color.yellow);

		java.net.URL imageURL = PacStoreTesting.class.getResource("pacHumanRightFlossNew.png");
		lblDisplay = new JLabel(new ImageIcon(imageURL));

		java.net.URL imageURL2 = PacStoreTesting.class.getResource("pacHumanRightEgyptianDance.png");
		lblDisplay2 = new JLabel(new ImageIcon(imageURL2));

		java.net.URL imageURL3 = PacStoreTesting.class.getResource("pacHumanRightDabNew.png");
		lblDisplay3 = new JLabel(new ImageIcon(imageURL3));
		
		panel.add(lblDisplay);
		panel.add(lblDisplay2);
		panel.add(lblDisplay3);
		lblDisplay.setBounds(300, 200, 100, 100);
		lblDisplay2.setBounds(450, 200, 100, 100);
		lblDisplay3.setBounds(600, 200, 100, 100);
		
		java.net.URL imageURL4 = PacStoreTesting.class.getResource("pacHumanRightTopHatNew.png");
		lblDisplay4 = new JLabel(new ImageIcon(imageURL4));

		java.net.URL imageURL5 = PacStoreTesting.class.getResource("pacHumanRightSoldierNew.png");
		lblDisplay5 = new JLabel(new ImageIcon(imageURL5));

		java.net.URL imageURL6 = PacStoreTesting.class.getResource("pacHumanRightGoldNew.png");
		lblDisplay6 = new JLabel(new ImageIcon(imageURL6));
		
		panel.add(lblDisplay4);
		panel.add(lblDisplay5);
		panel.add(lblDisplay6);
		lblDisplay4.setBounds(300, 400, 100, 100);
		lblDisplay5.setBounds(450, 400, 100, 100);
		lblDisplay6.setBounds(600, 400, 100, 100);
		
		lblDisplay.setVisible(false);
		lblDisplay2.setVisible(false);
		lblDisplay3.setVisible(false);
		lblDisplay4.setVisible(false);
		lblDisplay5.setVisible(false);
		lblDisplay6.setVisible(false);

		JButton p1 = new JButton("Floss");
		p1.setBounds(300, 300, 100, 30);
		p1.setBackground(Color.red);
		p1.setVisible(false);

		JButton p2 = new JButton("Egyptian");
		p2.setBounds(450, 300, 100, 30);
		p2.setBackground(Color.red);
		p2.setVisible(false);

		JButton p3 = new JButton("Dab");
		p3.setBounds(600, 300, 100, 30);
		p3.setBackground(Color.red);
		p3.setVisible(false);
		
		JButton p4 = new JButton("FancyMan");
		p4.setBounds(300, 500, 100, 30);
		p4.setBackground(Color.red);
		p4.setVisible(false);
		
		JButton p5 = new JButton("ArmyMan");
		p5.setBounds(450, 500, 100, 30);
		p5.setBackground(Color.red);
		p5.setVisible(false);
		
		JButton p6 = new JButton("GoldMan");
		p6.setBounds(600, 500, 100, 30);
		p6.setBackground(Color.red);
		p6.setVisible(false);

		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		panel.add(p6);
		
		JLabel c1 = new JLabel("added");
		c1.setBounds(300, 300, 100, 100);
		c1.setVisible(false);
		JLabel c2 = new JLabel("added");
		c2.setBounds(450, 300, 100, 100);
		c2.setVisible(false);
		JLabel c3 = new JLabel("added");
		c3.setBounds(600, 300, 100, 100);
		c3.setVisible(false);
		
		JLabel c4 = new JLabel("added");
		c4.setBounds(300, 500, 100, 100);
		c4.setVisible(false);
		JLabel c5 = new JLabel("added");
		c5.setBounds(450, 500, 100, 100);
		c5.setVisible(false);
		JLabel c6 = new JLabel("added");
		c6.setBounds(600, 500, 100, 100);
		c6.setVisible(false);
		
		panel.add(c1);
		panel.add(c2);
		panel.add(c3);
		panel.add(c4);
		panel.add(c5);
		panel.add(c6);
		
		JLabel payLabel = new JLabel("Your card has been declined pelease call card company or tell Mommy");
		payLabel.setBounds(350, 800, 400, 100);
		payLabel.setVisible(false);
		panel.add(payLabel);
		
		JButton b3 = new JButton("Pay");
		b3.setBounds(500, 800, 100, 30);
		b3.setBackground(Color.green);
		b3.setVisible(false);
		
		b1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			/**
			 * Launches PacHumanGame and makes PacStore invisible.
			 * 
			 * @param arg0
			 */
			@Override
			public void mousePressed(MouseEvent arg0) {

				//PacHumanGame pacHumanGamePanel = new PacHumanGame(700, 700, Color.black);
				//pacHumanGamePanel = new PacHumanGame(700, 700, Color.black);
				pacHumanGamePanel = new PacHumanGame(700, 700, Color.black, batSpeed, score, lives);
				pacHumanGameFrame = new JFrame("Score: " + score + "       Lives: " + lives);
				pacHumanGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pacHumanGameFrame.add(pacHumanGamePanel);
				pacHumanGameFrame.pack();
				pacHumanGameFrame.setVisible(true);

				// This will make the store invisible. If you want it to still be open
				// underneath the game, delete this.
				panel.setVisible(false);
				f.setVisible(false);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		b2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				lblDisplay.setVisible(true);
				lblDisplay2.setVisible(true);
				lblDisplay3.setVisible(true);
				lblDisplay4.setVisible(true);
				lblDisplay5.setVisible(true);
				lblDisplay6.setVisible(true);
				p1.setVisible(true);
				p2.setVisible(true);
				p3.setVisible(true);
				p4.setVisible(true);
				p5.setVisible(true);
				p6.setVisible(true);
				b3.setVisible(true);
				

				p1.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin1) {
							skin1 = true;
							c1.setVisible(true);
						} else {
							skin1 = false;
							c1.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});

				p2.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin2) {
							skin2 = true;
							c2.setVisible(true);
						} else {
							skin2 = false;
							c2.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});

				p3.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin3) {
							skin3 = true;
							c3.setVisible(true);
						} else {
							skin3 = false;
							c3.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});
				
				p4.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin4) {
							skin4 = true;
							c4.setVisible(true);
						} else {
							skin4 = false;
							c4.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});
				
				p5.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin5) {
							skin5 = true;
							c5.setVisible(true);
						} else {
							skin5 = false;
							c5.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});
				
				p6.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (!skin6) {
							skin6 = true;
							c6.setVisible(true);
						} else {
							skin6 = false;
							c6.setVisible(false);
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}

				});

				JTextField textField;
				textField = new JTextField();
				textField.setBounds(290, 600, 200, 30);
				panel.add(textField);

				JTextField textField2;
				textField2 = new JTextField();
				textField2.setBounds(290, 650, 200, 30);
				panel.add(textField2);
				
				JTextField textField3;
				textField3 = new JTextField();
				textField3.setBounds(290, 700, 200, 30);
				panel.add(textField3);

				// I just see "Please Enter" for both of these, I think you made the width too
				// small
				JLabel jlabel1 = new JLabel("Please Enter your Credit Card");
				jlabel1.setFont(new Font("ComicSans", 1, 10));
				panel.add(jlabel1);
				panel.setBorder(new LineBorder(Color.white));
				jlabel1.setBounds(500, 600, 500, 50);

				JLabel jlabel2 = new JLabel("Please Enter your Security Code");
				jlabel2.setFont(new Font("Verdana", 1, 10));
				panel.add(jlabel2);
				panel.setBorder(new LineBorder(Color.white));
				jlabel2.setBounds(500, 650, 500, 50);
				
				JLabel jlabel3 = new JLabel("Please Enter your Experation Date");
				jlabel3.setFont(new Font("Verdana", 1, 10));
				panel.add(jlabel3);
				panel.setBorder(new LineBorder(Color.white));
				jlabel3.setBounds(500, 700, 500, 50);

				b3.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {

					}

					@Override
					public void mousePressed(MouseEvent e) {
						payLabel.setVisible(true);
					}

					@Override
					public void mouseReleased(MouseEvent e) {

					}
				});
			}
		});
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		f.add(panel);
		f.setSize(1500, 1000);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method is needed to increase the score in PacHumanGame, because the
	 * JFrame gets created in this class. Can update the constructor to do the lives
	 * and other stuff
	 * 
	 * @param currentScore
	 */
	public static void setTitle(int currentScore, int lives) {
		pacHumanGameFrame.setTitle("Score: " + currentScore + "     Lives: " + lives);
	}

	public static void main(String args[]) {
		PacStore pacStore = new PacStore();
		pacStore.PanelExample(batSpeed, score, lives);
	}

}