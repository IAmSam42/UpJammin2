package model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundModel {

	private int numberOfBanterClips = 11;
	private Clip mainClip;
	private int tickCount;
	private Clip[] banterClips;
	private int nextBant;
	private Random gen;
	
	public SoundModel() {
		
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("resources/sounds/BattleMusic.wav"));
				mainClip = AudioSystem.getClip(); 
				mainClip.open(audioInputStream);
				mainClip.loop(Clip.LOOP_CONTINUOUSLY);
				FloatControl gainControl = 
					    (FloatControl) mainClip.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(-15.0f);
				

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gen = new Random();
		
		banterClips = new Clip[numberOfBanterClips];
		for(int i = 0; i<numberOfBanterClips; i++)
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File("resources/sounds/banterClip"+i+".wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);	
					banterClips[i] = clip;

			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
		tickCount = 0;
		nextBant = gen.nextInt(1000);
		
	}
	
	public void tick(){

		tickCount++;
		if(tickCount == nextBant){
			
			if(banterClips.length > 0) {
				int x = gen.nextInt(banterClips.length-1);
				banterClips[x].start();
				nextBant = (int) (tickCount + (banterClips[x].getMicrosecondLength()/600000)) + gen.nextInt(1000);
			}
		} 
		
	}
}
