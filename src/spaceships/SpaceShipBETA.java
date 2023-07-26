package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;
public class SpaceShipBETA extends SpaceShip{
	public static Image img;
	static{
	try{
		SpaceShipBETA.img=ImageIO.read(MainClass.class.getResource("/images/BETA.png/"));
		}
	catch (Exception ex) {System.out.println(ex);
		}
	}
	public SpaceShipBETA(){
		super(Color.PINK);
		SpaceShipName="BETA";
		horPace=20;
		verPace=20;
		xcoords=0;
		health=200;
		ycoords=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipBETA.img);
		}		
}
