package effects;
import java.awt.Color;
import java.util.LinkedList;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
import main.MainClass;

public class Explosion{
    public  void explosion_list(LinkedList<Image> explosion) {
    	try {
    		 for(int i=0;i<9;i++){
    			   	explosion.add(ImageIO.read(MainClass.class.getResource("/images/explosion/e"+(i+1)+".png/")));
    		 }
    	}
		catch (Exception ex) {
			System.out.println(ex);

	    }

    }
    
}