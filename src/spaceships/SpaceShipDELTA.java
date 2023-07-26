package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;
public class SpaceShipDELTA extends SpaceShip{
	public static Image img;
	static{
	try{
		SpaceShipDELTA.img=ImageIO.read(MainClass.class.getResource("/images/DELTA.png/"));
		}
	catch (Exception ex) {System.out.println(ex);
		}
	}
	public SpaceShipDELTA(){
		super(Color.YELLOW);
		SpaceShipName="DELTA";
		horPace=40;
		verPace=40;
		xcoords=0;
		health=200;
		ycoords=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipDELTA.img);
		}		
}
