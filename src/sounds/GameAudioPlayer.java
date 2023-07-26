package sounds;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import main.MainClass;
public class GameAudioPlayer{
	private AudioInputStream audioInputStream;
	Clip clip;
	
	public void loadSpaceAmbient() {
		try {
			audioInputStream=
				AudioSystem.getAudioInputStream(MainClass.class.getResource("/audio/space-ambience.wav"));
				clip=AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				FloatControl gainControl=
						(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-15.0f);
			clip.start();
				
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	public void loadLaserSound() {
		try {
			audioInputStream=
				AudioSystem.getAudioInputStream(MainClass.class.getResource("/audio/laser_sound.wav"));
				clip=AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl=
						(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-20.0f);
				clip.start();
				
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	public void spaceShipSelection() {
		try {
			audioInputStream=
				AudioSystem.getAudioInputStream(MainClass.class.getResource("/audio/spaceShipSelection.wav"));
				clip=AudioSystem.getClip();
				clip.open(audioInputStream);

				FloatControl gainControl=
						(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-10.0f);
				clip.start();
				
		}
		catch(Exception ex) {System.out.println(ex);}
	}
	
}