package gui;
import javax.swing.*;
import java.awt.*;
import sounds.*;
public class SpaceFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private GameAudioPlayer intro=new GameAudioPlayer();
	static int width,height;
	static SelectSpaceShipScreen selectSpaceShipScreen=new SelectSpaceShipScreen();
	static GamePlayScreen gamePlayScreen=new GamePlayScreen();
	static CardLayout cardLayout=new CardLayout();
	static JPanel spaceFramePanel=new JPanel();
	static JPanel endScreen = new JPanel();
	public SpaceFrame(int width, int height) {
		SpaceFrame.width=width;
		SpaceFrame.height=height;
		intro.loadSpaceAmbient();
		this.setSize(width, height);

		this.setTitle("[ECE_Υ325] astra game simulation");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		end();
		setupMasterPanel();
		this.setResizable(false);
		this.setVisible(true);
		
	}
	void setupMasterPanel() {
		spaceFramePanel.setLayout(cardLayout);
		spaceFramePanel.add(selectSpaceShipScreen);
		spaceFramePanel.add(gamePlayScreen);
		spaceFramePanel.add(endScreen);

		this.add(spaceFramePanel);
	}
	public void end() {
		endScreen.setPreferredSize(new Dimension(200, 200));
		JLabel label = new JLabel("GAME OVER");
		label.setFont(new Font("Arcade Classic", Font.PLAIN, 50));
		endScreen.setForeground(Color.WHITE);
		endScreen.setBackground(Color.BLACK);
		endScreen.add(label);
		
	}
}