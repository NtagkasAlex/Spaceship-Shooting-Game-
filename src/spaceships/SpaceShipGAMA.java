package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;
public class SpaceShipGAMA extends SpaceShip{
	public static Image img;
	static{
	try{
		SpaceShipGAMA.img=ImageIO.read(MainClass.class.getResource("/images/GAMA.png/"));
		}
	catch (Exception ex) {System.out.println(ex);
		}
	}
	public SpaceShipGAMA(){
		super(Color.GRAY);
		SpaceShipName="GAMA";
		horPace=30;
		verPace=30;
		xcoords=0;
		health=200;

		ycoords=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipGAMA.img);
		}		
}
