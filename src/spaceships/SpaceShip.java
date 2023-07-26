package spaceships;
import javax.swing.*;
import main.*;
import spaceship_laserguns.*;
import java.awt.Color;
import java.util.LinkedList;

public class SpaceShip implements Navigation{
	public LinkedList <Laser> laserShootersLinkedList=new LinkedList<Laser>();
	protected ImageIcon SpaceShipImageIcon;
	protected String SpaceShipName;
	protected int xcoords;
	protected int ycoords;
	protected int horPace;
	public int health;
	public Lasergun gun;
	protected int verPace;
	public int getX() {return xcoords;}
	public int getY() {return ycoords;}
	public ImageIcon getIcon() {return SpaceShipImageIcon;}
	public void fire(int x, int y) {
		gun.laserShootersLinkedList.add(gun.laserShootersLinkedList.size(),new Laser(x,y));
	}
	public int moveUP() {
		ycoords-=verPace;
		if(ycoords<0)ycoords+=verPace;
		return ycoords;
		
	}
	public int moveDOWN() {
		ycoords+=verPace;
		if(ycoords+MainClass.spaceShipHeight>MainClass.cosmosHeight-MainClass.yOffSet)ycoords-=verPace;
		return ycoords;
		
	}
	public int moveRIGHT() {
		xcoords+=horPace;
		if(xcoords+MainClass.spaceShipWidth>MainClass.cosmosWidth)xcoords=xcoords-horPace;
		return xcoords;
		
	}
	public int moveLEFT() {
		xcoords-=horPace;
		if(xcoords<0)xcoords=xcoords+horPace;
		return xcoords;

	}
	public SpaceShip(Color clr){
		gun= new Lasergun(clr);
	}
}
