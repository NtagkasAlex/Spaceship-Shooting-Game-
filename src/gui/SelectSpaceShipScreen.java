package gui;
import javax.swing.*;
import java.awt.*;
import spaceships.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sounds.*;

public class SelectSpaceShipScreen extends JPanel{
	private static final long serialVersionUID = 1L;
	private GameAudioPlayer sel_music=new GameAudioPlayer();
	SelectSpaceShipScreen(){
		this.setLayout( new BorderLayout());
		this.add(createNorthPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createSouthPanel(), BorderLayout.SOUTH);
	}
	private JPanel createNorthPanel(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		JLabel label = new JLabel("Please choose your Spaceship ");
		label.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
		label.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.add(label);
		return panel;
	}
	private JPanel createCenterPanel() { 
		JButton btnspaceShipZero=new JButton();
		JButton btnspaceShipAlpha=new JButton();
		JButton btnspaceShipBeta=new JButton();
		JButton btnspaceShipGama=new JButton();
		JButton btnspaceShipDelta=new JButton();
		btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SZERO"));
		btnspaceShipAlpha.addActionListener(new SpaceShipSelectionBtnHandler("SALPHA"));
		btnspaceShipBeta.addActionListener(new SpaceShipSelectionBtnHandler("SBETA"));
		btnspaceShipGama.addActionListener(new SpaceShipSelectionBtnHandler("SGAMA"));
		btnspaceShipDelta.addActionListener(new SpaceShipSelectionBtnHandler("SDELTA"));
		
		btnspaceShipZero.setIcon(new ImageIcon(SpaceShipZERO.img));
		btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipALPHA.img));
		btnspaceShipBeta.setIcon(new ImageIcon(SpaceShipBETA.img));
		btnspaceShipGama.setIcon(new ImageIcon(SpaceShipGAMA.img));
		btnspaceShipDelta.setIcon(new ImageIcon(SpaceShipDELTA.img)); 
		
		makeButtonTransparent(btnspaceShipZero);
		makeButtonTransparent(btnspaceShipAlpha);
		makeButtonTransparent(btnspaceShipBeta);
		makeButtonTransparent(btnspaceShipGama);
		makeButtonTransparent(btnspaceShipDelta);

		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.BLACK);
		panel.add(btnspaceShipZero);
		panel.add(btnspaceShipAlpha);
		panel.add(btnspaceShipBeta);
		panel.add(btnspaceShipGama);
		panel.add(btnspaceShipDelta);
		return panel;
	}
	private JPanel createSouthPanel() {
		JPanel panel=new JPanel();
		panel.setBackground(Color.BLACK);
		return panel;
	}
	private void makeButtonTransparent(JButton jbutton) {
		jbutton.setOpaque(false);
		jbutton.setContentAreaFilled(false);
		jbutton.setBorderPainted(false);
		return;
	}
	
	class SpaceShipSelectionBtnHandler implements ActionListener{
		private String SpaceShipName;
		public SpaceShipSelectionBtnHandler(String SpaceShipName) {
			this.SpaceShipName=SpaceShipName;
		}
		public void actionPerformed(ActionEvent ev) {
		
			SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
			SpaceFrame.gamePlayScreen.setFocusable(true);
			SpaceFrame.gamePlayScreen.requestFocus();
			sel_music.spaceShipSelection();

			if(SpaceShipName.equalsIgnoreCase("SZERO")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipZERO());
			if(SpaceShipName.equalsIgnoreCase("SALPHA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipALPHA());
			if(SpaceShipName.equalsIgnoreCase("SBETA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipBETA());
			if(SpaceShipName.equalsIgnoreCase("SGAMA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipGAMA());
			if(SpaceShipName.equalsIgnoreCase("SDELTA")) SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipDELTA());
			
		}


	}
	
}
