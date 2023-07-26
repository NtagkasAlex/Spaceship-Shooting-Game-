package gui;
import javax.swing.*;
import spaceships.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.LinkedList;
import java.util.Timer;
import sounds.*;
import effects.*;
import main.MainClass;
public class GamePlayScreen extends JPanel implements KeyListener{
	public SpaceShip userSpaceShip;
	public SpaceShipENEMY enemySpaceShip= new SpaceShipENEMY();
	private GameAudioPlayer beam= new GameAudioPlayer();
	public Explosion explosion=new Explosion();
	public LinkedList <Image> explosions=new LinkedList<Image>();
	static int enemy_losed=0;
	static int my_losed=0;

	GamePlayScreen(){
		addKeyListener(this);
		this.setVisible(true);
		this.setBackground( Color.BLACK);
		createDeamon();
	}
	private void createDeamon() {
		Timer timer = new Timer();
		TimerTask task= new monitorDeamonGame();
		timer.schedule(task,100,100);
	}
	class monitorDeamonGame extends TimerTask{
		public void run() {repaint();}
	}
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Healthbar(g,0,0);
		enemySpaceShip.huntUserSpaceShip(userSpaceShip);	
		enemySpaceShip.getIcon().paintIcon(this, g,enemySpaceShip.getX(),
				enemySpaceShip.getY());
		userSpaceShip.getIcon().paintIcon(this, g, userSpaceShip.getX(),
				userSpaceShip.getY());
		showLaserShooting(g);


		
	}
	private void showLaserShooting(Graphics g) {
		userSpaceShip.gun.laserShootersLinkedList.forEach((tmp)->{
		g.setColor(userSpaceShip.gun.lasercolor);
		g.drawLine(tmp.x,tmp.y,tmp.x,tmp.y-15);
		if(tmp.y-15>=enemySpaceShip.getY() && tmp.y-15<=enemySpaceShip.getY()+main.MainClass.spaceShipHeight && tmp.x>=enemySpaceShip.getX() && tmp.x<=enemySpaceShip.getX() +main.MainClass.spaceShipWidth) {
			explosion(g,enemySpaceShip.getX()+main.MainClass.spaceShipWidth/2-10,enemySpaceShip.getY()+main.MainClass.spaceShipHeight);
			if(enemy_losed>=enemySpaceShip.health) {
		
				SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);

			}
			else {
				Healthbar(g,10,0);
			}
		}
		tmp.y=tmp.y-15;
		});		
		enemySpaceShip.gun.laserShootersLinkedList.forEach((tmp)->{
		g.setColor(enemySpaceShip.gun.lasercolor);
		g.drawLine(tmp.x,tmp.y,tmp.x,tmp.y+15);
		if(tmp.y+15>=userSpaceShip.getY() && tmp.y+15<=userSpaceShip.getY()+main.MainClass.spaceShipHeight && tmp.x>=userSpaceShip.getX() && tmp.x<=userSpaceShip.getX() +main.MainClass.spaceShipWidth) {
			explosion(g,userSpaceShip.getX()+main.MainClass.spaceShipWidth/2-10,userSpaceShip.getY());
			if(my_losed>=userSpaceShip.health) {
				SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);

				
			}
			else {
				Healthbar(g,0,10);
			}
		}
		tmp.y=tmp.y+15;
		});	
	}
	public void explosion(Graphics g,int x,int y) {
		explosion.explosion_list(explosions);
		for(int i=0;i<explosions.size();i=i+1) {
			g.drawImage(explosions.get(i),x,y,15,15,null);
		}

	
	        
	}
	public void  Healthbar(Graphics g,int enemyloss,int myloss) {
		enemy_losed+=enemyloss;
		my_losed+=myloss;
        g.setColor(Color.white);
        g.fillRect(main.MainClass.cosmosWidth/2-enemySpaceShip.health/2,10, enemySpaceShip.health, 30); 
        g.setColor(Color.red);
        g.fillRect(main.MainClass.cosmosWidth/2-enemySpaceShip.health/2,15,  enemySpaceShip.health-enemy_losed, 20); 
        g.setColor(Color.white);
        g.fillRect(main.MainClass.cosmosWidth/2-100,main.MainClass.cosmosHeight-75, userSpaceShip.health, 30); 
        g.setColor(Color.red);
        g.fillRect(main.MainClass.cosmosWidth/2-100,main.MainClass.cosmosHeight-70, userSpaceShip.health-my_losed, 20); 

	}
	@Override 
	public void keyPressed (KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) userSpaceShip.moveUP();
		if (e.getKeyCode() == KeyEvent.VK_DOWN) userSpaceShip.moveDOWN();
		if (e.getKeyCode() == KeyEvent.VK_LEFT) userSpaceShip.moveLEFT();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) userSpaceShip.moveRIGHT();
		if (e.getKeyCode() == KeyEvent.VK_B) SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			userSpaceShip.gun.fire(userSpaceShip.getX(),userSpaceShip.getY());		
			beam.loadLaserSound();
			
		}

		this.repaint();
	}
	@Override
	public void keyReleased (KeyEvent e) {}
	@Override 
	public void keyTyped (KeyEvent e){}
	void setUserSpaceShip(SpaceShip usel) {	
		userSpaceShip=usel;
	}
	
}