package spaceships;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;
public class SpaceShipZERO extends SpaceShip{
	public static Image img;
	static{
	try{
		SpaceShipZERO.img=ImageIO.read(MainClass.class.getResource("/images/ZERO.png"));
		}
	catch (Exception ex) {
		System.out.println(ex);
		}
	}
	public SpaceShipZERO(){
		super(Color.RED);
		SpaceShipName="ZERO";
		horPace=5;
		verPace=5;
		xcoords=0;
		health=200;

		ycoords=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;
		super.SpaceShipImageIcon=new ImageIcon(SpaceShipZERO.img);
		}		
}
