package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;
public class SpaceShipALPHA extends SpaceShip{
	public static Image img;
	static{
	try{
		SpaceShipALPHA.img=ImageIO.read(MainClass.class.getResource("/images/ALPHA.png/"));

		}
	catch (Exception ex) {System.out.println(ex);
		}
	}
	public SpaceShipALPHA(){
		super(Color.CYAN);
		SpaceShipName="ALPHA";
		horPace=10;
		verPace=10;
		xcoords=0;
		health=200;
		ycoords=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipALPHA.img);
		}	
	
}
