package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;

import main.MainClass;
public class SpaceShipENEMY extends SpaceShip{
	static Random random = new Random();
	public static Image img;
	static{
	try{
		
		SpaceShipENEMY.img=ImageIO.read(MainClass.class.getResource("/images/ENEMY.png/"));

		SpaceShipENEMY.img = SpaceShipENEMY.img.getScaledInstance(MainClass.spaceShipWidth, MainClass.spaceShipHeight,0);

		}
	catch (Exception ex) {System.out.println(ex);
		}
	}
	public SpaceShipENEMY(){
		super(Color.MAGENTA);
		SpaceShipName="ENEMY";
		horPace=15;
		verPace=15;
		xcoords=0;
		health=400;
		ycoords=MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipENEMY.img);
		}		
	public void huntUserSpaceShip(SpaceShip userspaceship) {
		int mv = random.nextInt(10);
		if(mv==0) this.gun.fire(this.getX(),this.getY()+100);
		if(userspaceship.xcoords>this.xcoords)this.xcoords=this.moveRIGHT();
		else this.xcoords=this.moveLEFT();
		
		int res=random.nextInt(4);
		if(res==2)this.moveLEFT();
		if(res==3)this.moveRIGHT();
	}
}
